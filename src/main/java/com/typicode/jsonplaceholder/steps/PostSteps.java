package com.typicode.jsonplaceholder.steps;

import com.typicode.jsonplaceholder.api.dto.PostRequestDto;
import com.typicode.jsonplaceholder.api.dto.PostResponseDto;
import com.typicode.jsonplaceholder.services.posts.PostService;
import io.qameta.allure.Step;

import java.util.List;

public class PostSteps {

    PostService postService = new PostService();

    @Step("Запрос на получение списка всех постов")
    public List<PostResponseDto> getAllPosts(int statusCode) {
        return postService.get(statusCode).body().jsonPath().getList("",PostResponseDto.class);
    }

    @Step("Запрос на получение поста по id:{postId}")
    public PostResponseDto getPostById(int postId, int statusCode) {
        return postService.get(postId, statusCode).as(PostResponseDto.class);
    }

    @Step("Запрос на создание поста")
    public PostResponseDto createPost(PostRequestDto body, int statusCode) {
        return postService.post(body, statusCode).as(PostResponseDto.class);
    }

    @Step("Запрос на обновление поста методом put")
    public PostResponseDto putUpdatePost(int postId, PostRequestDto body, int statusCode) {
        return postService.put(postId, body, statusCode).as(PostResponseDto.class);
    }

    @Step("Запрос на обновление поста методом patch")
    public PostResponseDto patchUpdatePost(int postId, PostRequestDto body, int statusCode) {
        return postService.patch(postId, body, statusCode).as(PostResponseDto.class);
    }

    @Step("Запрос на удаление поста")
    public PostResponseDto deletePost(int postId,int statusCode) {
        return postService.delete(postId, statusCode).as(PostResponseDto.class);
    }
}