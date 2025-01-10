package com.typicode.jsonplaceholder.api.generators;

import com.github.javafaker.Faker;
import com.typicode.jsonplaceholder.api.dto.PostRequestDto;

public class PostGenerator {
    private static final Faker faker = new Faker();

    public static PostRequestDto getNewPost() {
        return PostRequestDto.builder()
                .userId(faker.random().nextInt(1, 101))
                .title(String.join(" ", faker.lorem().words(6)))
                .body(faker.lorem().paragraph())
                .build();
    }

    public static PostRequestDto getNewPostWithoutBody() {
        return PostRequestDto.builder()
                .userId(faker.random().nextInt(1, 101))
                .title(String.join(" ", faker.lorem().words(6)))
                .build();
    }

    public static PostRequestDto getNewPostWithoutTitle() {
        return PostRequestDto.builder()
                .userId(faker.random().nextInt(1, 101))
                .body(faker.lorem().paragraph())
                .build();
    }

    public static PostRequestDto getNewPostWithoutUserId() {
        return PostRequestDto.builder()
                .title(String.join(" ", faker.lorem().words(6)))
                .body(faker.lorem().paragraph())
                .build();
    }
}