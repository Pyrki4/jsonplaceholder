package com.typicode.jsonplaceholder.api.assertions;

import com.typicode.jsonplaceholder.api.dto.PostRequestDto;
import com.typicode.jsonplaceholder.api.dto.PostResponseDto;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class PostsAssertions {

    @Step("Проверка полей созданного поста")
    public static void assertPostCreate(PostResponseDto response) {
        var id = response.getId();
        Assertions.assertEquals(101, id);
    }

    @Step("Проверка полей полученного поста")
    public static void assertPostRead(PostResponseDto response, int expectedPostId) {
        var id = response.getId();
        Assertions.assertEquals(expectedPostId, id);
    }

    @Step("Проверка полей обновленного поста")
    public static void assertPostUpdate(PostResponseDto response, PostRequestDto post) {
        if (post.getBody() != null) {
            Assertions.assertEquals(post.getBody(), response.getBody());
        }
        if (post.getTitle() != null) {
            Assertions.assertEquals(post.getTitle(), response.getTitle());
        }
        if (post.getUserId() != 0) {
            Assertions.assertEquals(post.getUserId(), response.getUserId());
        }
    }

    @Step("Проверка полей удаленного поста")
    public static void assertPostDelete(PostResponseDto response) {
        Assertions.assertEquals(0, response.getId());
        Assertions.assertNull(response.getBody());
        Assertions.assertNull(response.getTitle());
        Assertions.assertEquals(0, response.getUserId());
    }
}
