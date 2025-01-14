package com.typicode.jsonplaceholder.helpers;

import com.typicode.jsonplaceholder.api.dto.PostResponseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostWordFrequencyHelper {

    public static List<Map.Entry<String, Integer>> getListOfPostWordsFrequency(List<PostResponseDto> posts) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (PostResponseDto post : posts) {
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

    public static void logPostsWordFrequency(List<PostResponseDto> list) {
        List<Map.Entry<String, Integer>> sortedWords = PostWordFrequencyHelper.getListOfPostWordsFrequency(list);

        Logger.logList(sortedWords);
    }
}