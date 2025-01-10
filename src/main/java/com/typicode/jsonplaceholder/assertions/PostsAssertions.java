package com.typicode.jsonplaceholder.assertions;

import com.typicode.jsonplaceholder.api.dto.CreatePostDto;
import com.typicode.jsonplaceholder.helpers.HttpStatus;
import io.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;

import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class PostsAssertions {
    public static void assertPostCreate(ValidatableResponse response) {
        response
                .statusCode(HttpStatus.CREATED)
                .assertThat()
                .body("id", equalTo(101));
    }

    public static void assertPostRead(ValidatableResponse response, int expectedUserId, int expectedPostId) {
        response
                .statusCode(HttpStatus.OK)
                .assertThat()
                .body("userId", equalTo(expectedUserId))
                .assertThat()
                .body("id", equalTo(expectedPostId));
    }

    public static void assertPostUpdate(ValidatableResponse response, CreatePostDto post) {
        response
                .statusCode(HttpStatus.OK)
                .assertThat()
                .body("userId", equalTo(post.getUserId()))
                .assertThat()
                .body("body", equalTo(post.getBody()))
                .assertThat()
                .body("title", equalTo(post.getTitle()));
    }

    public static void assertPostDelete(ValidatableResponse response) {
        response
                .statusCode(HttpStatus.OK);
    }
}
