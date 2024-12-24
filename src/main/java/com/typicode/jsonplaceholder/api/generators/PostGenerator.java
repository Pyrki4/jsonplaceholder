package com.typicode.jsonplaceholder.api.generators;

import com.github.javafaker.Faker;
import com.typicode.jsonplaceholder.api.dto.CreatePostDto;

public class PostGenerator {
    private static final Faker faker = new Faker();

    public static CreatePostDto getNewPost() {
        return CreatePostDto.builder()
                .userId(faker.random().nextInt(1, 101))
                .title(String.join(" ", faker.lorem().words(6)))
                .body(faker.lorem().paragraph())
                .build();
    }

    public static CreatePostDto getNewPostWithoutBody() {
        return CreatePostDto.builder()
                .userId(faker.random().nextInt(1, 101))
                .title(String.join(" ", faker.lorem().words(6)))
                .build();
    }

    public static CreatePostDto getNewPostWithoutTitle() {
        return CreatePostDto.builder()
                .userId(faker.random().nextInt(1, 101))
                .body(faker.lorem().paragraph())
                .build();
    }

    public static CreatePostDto getNewPostWithoutUserId() {
        return CreatePostDto.builder()
                .title(String.join(" ", faker.lorem().words(6)))
                .body(faker.lorem().paragraph())
                .build();
    }
}