package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.api.assertions.PostsAssertions;
import com.typicode.jsonplaceholder.api.dto.PostRequestDto;
import com.typicode.jsonplaceholder.api.generators.PostGenerator;
import com.typicode.jsonplaceholder.base.BaseTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование CRUD операций постов")
public class CRUDOperationsTests extends BaseTest {

    @DisplayName("Создание поста")
    @Test
    public void createPostTest() {
        var response = client.createPost(PostGenerator.getNewPost(), HttpStatus.SC_CREATED);
        PostsAssertions.assertPostCreate(response);
    }

    @DisplayName("Получение поста")
    @Test
    public void getPostByIdTest() {
        var response = client.getPostById(1, HttpStatus.SC_OK);
        PostsAssertions.assertPostRead(response, 1);
    }

    @DisplayName("Обновление поста с помощью метода put")
    @Test
    public void updatePostByMethodPutTest() {
        PostRequestDto requestPost = PostGenerator.getNewPost();
        var response = client.putUpdatePost(1, requestPost, HttpStatus.SC_OK);
        PostsAssertions.assertPostUpdate(response, requestPost);
    }

    @DisplayName("Обновление поста с помощью метода patch")
    @Test
    public void updatePostByMethodPatchTest() {
        PostRequestDto requestPost = PostGenerator.getNewPostWithoutUserId();
        var response = client.patchUpdatePost(1, requestPost, HttpStatus.SC_OK);
        PostsAssertions.assertPostUpdate(response, requestPost);
    }

    @DisplayName("Удаление поста")
    @Test
    public void deletePostTest() {
        var response = client.deletePost(1, HttpStatus.SC_OK);
        PostsAssertions.assertPostDelete(response);
    }
}