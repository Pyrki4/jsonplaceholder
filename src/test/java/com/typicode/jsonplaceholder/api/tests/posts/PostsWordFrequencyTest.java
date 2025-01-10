package com.typicode.jsonplaceholder.api.tests.posts;

import com.typicode.jsonplaceholder.base.BaseTest;
import com.typicode.jsonplaceholder.helpers.PostWordFrequencyHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Часто встречающиеся слова в постах")
public class PostsWordFrequencyTest extends BaseTest {

    @DisplayName("Проверка часто встречающихся слов в постах")
    @Test
    public void postsWordFrequency() {
        var response = posts.readAllPosts();

        PostWordFrequencyHelper.logPosts(response);
    }
}
