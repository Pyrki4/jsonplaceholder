package com.typicode.jsonplaceholder.steps;

import com.typicode.jsonplaceholder.api.dto.PostRequestDto;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static com.typicode.jsonplaceholder.config.EndPoints.POSTS;
import static com.typicode.jsonplaceholder.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

public class PostSteps {

    @Step("Отправка запроса на создание поста")
    public ValidatableResponse createPost(PostRequestDto post) {
        return given()
                .spec(requestSpecification())
                .body(post)
                .when()
                .post(POSTS)
                .then()
                .log().ifError();
    }

    @Step("Отправка запроса на получение поста")
    public ValidatableResponse readPost(int postId) {
        return given()
                .spec(requestSpecification())
                .when()
                .get(POSTS + postId)
                .then();
    }

    @Step("Отправка запроса на получение всех постов")
    public ValidatableResponse readAllPosts() {
        return given()
                .spec(requestSpecification())
                .when()
                .get(POSTS)
                .then()
                .log().ifError();
    }

    @Step("Отправка запроса на обновление поста")
    public ValidatableResponse updatePost(int postId, PostRequestDto body) {
        return given()
                .spec(requestSpecification())
                .body(body)
                .when()
                .put(POSTS + postId)
                .then()
                .log().ifError();
    }

    @Step("Отправка запроса на удаление поста")
    public ValidatableResponse deletePost(int postId) {
        return given()
                .spec(requestSpecification())
                .when()
                .delete(POSTS + postId)
                .then()
                .log().ifError();
    }
}