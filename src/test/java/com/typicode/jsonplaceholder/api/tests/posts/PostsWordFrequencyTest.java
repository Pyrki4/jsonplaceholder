package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.api.dto.PostDto;
import com.typicode.jsonplaceholder.base.BaseTest;
import com.typicode.jsonplaceholder.helpers.PostWordFrequencyHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

@Slf4j
public class PostsWordFrequencyTest extends BaseTest {

    @DisplayName("Проверка часто встречающихся слов в постах")
    @Test
    public void postsWordFrequency() {
        var response = posts.readAllPosts();

        List<PostDto> posts = postsService.extractListOfPosts(response);

        List<Map.Entry<String, Integer>> sortedWords = PostWordFrequencyHelper.getListOfPostWordsFrequency(posts);

        int i = 1;

        for (Map.Entry<String, Integer> entry : sortedWords) {
            log.info(i + " ." + entry.getKey() + ": " + entry.getValue());
            i++;
        }
    }
}
