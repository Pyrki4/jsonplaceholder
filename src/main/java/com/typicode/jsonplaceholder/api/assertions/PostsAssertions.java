package com.typicode.jsonplaceholder.api.assertions;

import com.typicode.jsonplaceholder.api.dto.PostRequestDto;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static org.hamcrest.Matchers.equalTo;

public class PostsAssertions {

    public static void assertPostCreate(ValidatableResponse response) {
        response
                .statusCode(HttpStatus.SC_CREATED)
                .assertThat()
                .body("id", equalTo(101));
    }

    public static void assertPostRead(ValidatableResponse response, int expectedUserId, int expectedPostId) {
        response
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("userId", equalTo(expectedUserId))
                .assertThat()
                .body("id", equalTo(expectedPostId));
    }

    public static void assertPostUpdate(ValidatableResponse response, PostRequestDto post) {
        response
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("userId", equalTo(post.getUserId()))
                .assertThat()
                .body("body", equalTo(post.getBody()))
                .assertThat()
                .body("title", equalTo(post.getTitle()));
    }

    public static void assertPostDelete(ValidatableResponse response) {
        response
                .statusCode(HttpStatus.SC_OK);
    }
}