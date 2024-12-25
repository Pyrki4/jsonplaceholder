package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.api.dto.PostDto;
import com.typicode.jsonplaceholder.api.generators.PostGenerator;
import com.typicode.jsonplaceholder.base.PostBaseTest;
import com.typicode.jsonplaceholder.helpers.HttpStatus;
import com.typicode.jsonplaceholder.steps.PostSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

public class PostsTests extends PostBaseTest {
    private static final Logger logger = LogManager.getLogger(PostsTests.class);

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

    @Test
    public void getPostById() {
        postResponse = PostSteps.readPost(1);
        postResponse.assertThat().body("id", equalTo(1));

    }
}
