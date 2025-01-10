package com.typicode.jsonplaceholder.helpers;

import com.typicode.jsonplaceholder.api.dto.PostDto;
import com.typicode.jsonplaceholder.services.posts.PostsService;
import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostWordFrequencyHelper {

    protected final static Logger logger = LogManager.getLogger(PostWordFrequencyHelper.class);

    public static List<Map.Entry<String, Integer>> getListOfPostWordsFrequency(List<PostDto> posts) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (PostDto post : posts) {
            String body = post.getBody();
            String[] words = body.split(" ");

            for (String word : words) {
                wordFrequency.compute(word, (key, count) -> (count == null) ? 1 : count + 1);
            }
        }
        return wordFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .toList();
    }

    public static void logPosts(ValidatableResponse response) {
        PostsService postsService = new PostsService();

        List<PostDto> posts = postsService.extractListOfPosts(response);

        List<Map.Entry<String, Integer>> sortedWords = PostWordFrequencyHelper.getListOfPostWordsFrequency(posts);

        PostsLogger.logList(sortedWords, logger);
    }
}