package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.base.BaseTest;
import com.typicode.jsonplaceholder.helpers.PostWordFrequencyHelper;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование частоты слов в постах")
public class PostsWordFrequencyTest extends BaseTest {

    @DisplayName("Часто встречающиеся слова в постах")
    @Test
    public void postsWordFrequency() {
        var response = client.getAllPosts(HttpStatus.SC_OK);
        PostWordFrequencyHelper.logPostsWordFrequency(response);
    }
}