package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.api.dto.PostDto;
import com.typicode.jsonplaceholder.api.generators.PostGenerator;
import com.typicode.jsonplaceholder.base.PostBaseTest;
import com.typicode.jsonplaceholder.helpers.HttpStatus;
import com.typicode.jsonplaceholder.steps.PostSteps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.typicode.jsonplaceholder.helpers.HttpStatus.NOT_FOUND;
import static org.hamcrest.core.IsEqual.equalTo;

@DisplayName("Тестирование постов")
public class PostsTests extends PostBaseTest {
    @Test
    public void createPostWithValidData() {
        post = PostGenerator.getNewPost();
        postResponse = PostSteps.createPost(post);

        postResponse
                .statusCode(HttpStatus.CREATED)
                .assertThat()
                .body("id", equalTo(101));

        logger.info(postResponse);
    }

    @Test
    public void createPostWithoutUserId() {
        post = PostGenerator.getNewPostWithoutUserId();
        postResponse = PostSteps.createPost(post);

        postResponse
                .statusCode(HttpStatus.CREATED)
                .assertThat()
                .body("id", equalTo(101));
    }

    @Test
    public void createPostWithoutTitle() {
        post = PostGenerator.getNewPostWithoutTitle();
        postResponse = PostSteps.createPost(post);

        postResponse
                .statusCode(HttpStatus.CREATED)
                .assertThat()
                .body("id", equalTo(101));
    }

    @Test
    public void createPostWithoutBody() {
        post = PostGenerator.getNewPostWithoutBody();
        postResponse = PostSteps.createPost(post);

        postResponse
                .statusCode(HttpStatus.CREATED)
                .assertThat()
                .body("id", equalTo(101));
    }

    @Test
    public void getAllPosts() {
        postResponse = PostSteps.readPosts();
        List<PostDto> posts = postResponse
                .extract()
                .body()
                .jsonPath()
                .getList("", PostDto.class);

        Assertions.assertThat(posts.size()).isEqualTo(100);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 50, 100})
    public void getPostById(int postId) {
        postResponse = PostSteps.readPost(postId);
        postResponse.assertThat().body("id", equalTo(postId));
        logger.info("test with postId:" + postId);
    }

    @ParameterizedTest
    @ValueSource(ints = {101, 102})
    public void getPostWithoutId(int postId) {
        postResponse = PostSteps.readPost(postId);
        postResponse
                .statusCode(NOT_FOUND);
        logger.info("test with postId:" + postId);
    }
}
