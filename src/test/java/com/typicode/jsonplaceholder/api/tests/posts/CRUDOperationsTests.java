package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.api.dto.CreatePostDto;
import com.typicode.jsonplaceholder.api.generators.PostGenerator;
import com.typicode.jsonplaceholder.assertions.PostsAssertions;
import com.typicode.jsonplaceholder.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование CRUD операций постов")
public class CRUDOperationsTests extends BaseTest {

    @Test
    public void createPostTest() {
        var response = posts.createPost(PostGenerator.getNewPost());
        PostsAssertions.assertPostCreate(response);
    }

    @Test
    public void readPostTest() {
        var response = posts.readPost(1);
        PostsAssertions.assertPostRead(response, 1, 1);
    }

    @Test
    public void updatePostTest() {
        CreatePostDto updatePost = PostGenerator.getNewPost();
        var response = posts.updatePost(1, updatePost);
        PostsAssertions.assertPostUpdate(response, updatePost);
    }

    @Test
    public void deletePostTest() {
        var response = posts.deletePost(1);
        PostsAssertions.assertPostDelete(response);
    }
}
