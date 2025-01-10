package com.typicode.jsonplaceholder.steps;

import com.typicode.jsonplaceholder.api.dto.PostRequestDto;
import com.typicode.jsonplaceholder.api.dto.PostResponseDto;
import com.typicode.jsonplaceholder.config.EndPoints;
import com.typicode.jsonplaceholder.services.posts.PostsService;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static com.typicode.jsonplaceholder.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

public class PostSteps {

    PostService postService = new PostService();

    public PostResponseDto createPost(PostRequestDto body, int statusCode) {
        return postService.post(body, statusCode).as(PostResponseDto.class);
    }


//    @Step("Отправка запроса на получение поста")
    public ValidatableResponse readPost(int postId) {
        return given()
                .spec(requestSpecification())
                .when()
                .get(EndPoints.POSTS + postId)
                .then();
    }

//    @Step("Отправка запроса на получение всех постов")
    public ValidatableResponse readAllPosts() {
        return given()
                .spec(requestSpecification())
                .when()
                .get(EndPoints.POSTS)
                .then()
                .log().ifError();
    }

//    @Step("Отправка запроса на обновление поста")
    public ValidatableResponse updatePost(int postId, PostRequestDto body) {
        return given()
                .spec(requestSpecification())
                .body(body)
                .when()
                .put(EndPoints.POSTS + postId)
                .then()
                .log().ifError();
    }

//    @Step("Отправка запроса на удаление поста")
    public ValidatableResponse deletePost(int postId) {
        return given()
                .spec(requestSpecification())
                .when()
                .delete(EndPoints.POSTS + postId)
                .then()
                .log().ifError();
    }
}