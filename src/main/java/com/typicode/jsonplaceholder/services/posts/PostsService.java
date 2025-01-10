package com.typicode.jsonplaceholder.services.posts;

import com.typicode.jsonplaceholder.api.dto.PostResponseDto;
import io.restassured.response.ValidatableResponse;

import java.util.List;

public class PostsService {

    public List<PostResponseDto> extractListOfPosts(ValidatableResponse postResponse) {
        return postResponse
                .extract()
                .body()
                .jsonPath()
                .getList("", PostResponseDto.class);
    }
}
