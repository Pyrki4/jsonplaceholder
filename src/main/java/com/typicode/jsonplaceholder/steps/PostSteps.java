package com.typicode.jsonplaceholder.steps;

import com.typicode.jsonplaceholder.api.dto.CreatePostDto;
import io.restassured.response.ValidatableResponse;

import static com.typicode.jsonplaceholder.config.EndPoints.POSTS;
import static com.typicode.jsonplaceholder.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

public class PostSteps {

    public ValidatableResponse createPost(CreatePostDto post) {
        return given()
                .spec(requestSpecification())
                .body(post)
                .when()
                .post(POSTS)
                .then()
                .log().ifError();
    }

    public ValidatableResponse readPost(int postId) {
        return given()
                .spec(requestSpecification())
                .when()
                .get(POSTS + postId)
                .then();
    }

    public ValidatableResponse readAllPosts() {
        return given()
                .spec(requestSpecification())
                .when()
                .get(POSTS)
                .then()
                .log().ifError();
    }

    public ValidatableResponse updatePost(int postId, CreatePostDto body) {
        return given()
                .spec(requestSpecification())
                .body(body)
                .when()
                .put(POSTS + postId)
                .then()
                .log().ifError();
    }

    public ValidatableResponse deletePost(int postId) {
        return given()
                .spec(requestSpecification())
                .when()
                .delete(POSTS + postId)
                .then()
                .log().ifError();
    }
}
