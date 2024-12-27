package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.api.dto.PostDto;
import com.typicode.jsonplaceholder.base.PostBaseTest;
import com.typicode.jsonplaceholder.helpers.PostWordFrequencyHelper;
import com.typicode.jsonplaceholder.steps.PostSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class PostsWordFrequencyTest extends PostBaseTest {

    @DisplayName("Проверка часто встречающихся слов в постах")
    @Test
    public void postsWordFrequency() {
        postResponse = PostSteps.readPosts();

        List<PostDto> posts = postsService.extractListOfPosts(postResponse);

        List<Map.Entry<String, Integer>> sortedWords = PostWordFrequencyHelper.getListOfPostWordsFrequency(posts);

        int i = 1;

        for (Map.Entry<String, Integer> entry : sortedWords) {
            logger.info(i + " ." + entry.getKey() + ": " + entry.getValue());
            i++;
        }
    }
}
