package com.typicode.jsonplaceholder.steps;

import com.typicode.jsonplaceholder.api.dto.CreatePostDto;
import io.restassured.response.ValidatableResponse;

import static com.typicode.jsonplaceholder.config.EndPoints.POSTS;
import static com.typicode.jsonplaceholder.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

public class PostSteps {

    public static ValidatableResponse createPost(CreatePostDto post) {
        return given()
                .spec(requestSpecification())
                .body(post)
                .when()
                .post(POSTS)
                .then()
                .log().ifError();
    }
}
