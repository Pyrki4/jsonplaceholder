package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.api.dto.PostDto;
import com.typicode.jsonplaceholder.base.PostBaseTest;
import com.typicode.jsonplaceholder.steps.PostSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostsWordFrequencyTest extends PostBaseTest {

    private static final Logger logger = LogManager.getLogger(PostsWordFrequencyTest.class);

    @Test
    public void postsWordFrequency() {
        postResponse = PostSteps.readPosts();

        List<PostDto> posts = postResponse
                .extract()
                .body()
                .jsonPath()
                .getList("", PostDto.class);

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (PostDto post : posts) {
            String body = post.getBody();

            String[] words = body.split(" ");

            for (String word : words) {
                wordFrequency.compute(word, (key, count) -> (count == null) ? 1 : count + 1);
            }
        }
        List<Map.Entry<String, Integer>> sortedWords = wordFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10) // Ограничение на 10 записей
                .toList();

        for (Map.Entry<String, Integer> entry : sortedWords){
            int i = 0;
            logger.info((i + 1) + . + entry.getKey() + ": " + entry.getValue());
        }
    }
}
