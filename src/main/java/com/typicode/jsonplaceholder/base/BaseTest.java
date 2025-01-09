package com.typicode.jsonplaceholder.base;

import com.typicode.jsonplaceholder.api.dto.CreatePostDto;
import com.typicode.jsonplaceholder.services.posts.PostsService;
import com.typicode.jsonplaceholder.steps.PostSteps;
import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseTest {

    protected CreatePostDto post;
    protected ValidatableResponse postResponse;
    protected final Logger logger = LogManager.getLogger(getClass());
    protected PostsService postsService = new PostsService();
    protected PostSteps posts = new PostSteps();
}
