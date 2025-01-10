package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.api.dto.PostRequestDto;
import com.typicode.jsonplaceholder.api.generators.PostGenerator;
import com.typicode.jsonplaceholder.api.assertions.PostsAssertions;
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
    public void readPostTest() {
        var response = client.readPost(1);
        PostsAssertions.assertPostRead(response, 1, 1);
    }

    @DisplayName("Обновление поста")
    @Test
    public void updatePostTest() {
        PostRequestDto updatePost = PostGenerator.getNewPost();
        var response = client.updatePost(1, updatePost);
        PostsAssertions.assertPostUpdate(response, updatePost);
    }

    @DisplayName("Удаление поста")
    @Test
    public void deletePostTest() {
        var response = client.deletePost(1);
        PostsAssertions.assertPostDelete(response);
    }
}