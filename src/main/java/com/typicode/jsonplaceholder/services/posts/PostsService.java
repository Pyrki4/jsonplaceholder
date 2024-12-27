package com.typicode.jsonplaceholder.services.posts;

import com.typicode.jsonplaceholder.api.dto.PostDto;
import io.restassured.response.ValidatableResponse;

import java.util.List;

public class PostsService {

    public List<PostDto> extractListOfPosts(ValidatableResponse postResponse) {
        return postResponse
                .extract()
                .body()
                .jsonPath()
                .getList("", PostDto.class);
    }
}
