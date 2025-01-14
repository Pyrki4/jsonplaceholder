package com.typicode.jsonplaceholder.api.assertions;

import com.typicode.jsonplaceholder.api.dto.PostRequestDto;
import com.typicode.jsonplaceholder.api.dto.PostResponseDto;
import org.junit.jupiter.api.Assertions;

public class PostsAssertions {

    public static void assertPostCreate(PostResponseDto response) {
        var id = response.getId();
        Assertions.assertEquals(101, id);
    }

    public static void assertPostRead(PostResponseDto response, int expectedPostId) {
        var id = response.getId();
        Assertions.assertEquals(expectedPostId, id);
    }

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

    public static void assertPostDelete(PostResponseDto response) {
        Assertions.assertEquals(0, response.getId());
        Assertions.assertNull(response.getBody());
        Assertions.assertNull(response.getTitle());
        Assertions.assertEquals(0, response.getUserId());
    }
}
