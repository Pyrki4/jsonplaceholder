package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.api.generators.PostGenerator;
import com.typicode.jsonplaceholder.base.PostBaseTest;
import com.typicode.jsonplaceholder.helpers.HttpStatus;
import com.typicode.jsonplaceholder.steps.PostSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class PostsTests extends PostBaseTest {
    private static final Logger logger = LogManager.getLogger(PostsTests.class);

    @Test
    public void createPostWithValidData() {
        post = PostGenerator.getNewPostWithoutUserId();
        postResponse = PostSteps.createPost(post);

        logger.info(postResponse.log().all());

        postResponse
                .statusCode(HttpStatus.CREATED);
    }
}
