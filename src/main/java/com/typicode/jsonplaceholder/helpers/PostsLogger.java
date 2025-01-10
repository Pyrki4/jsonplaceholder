package com.typicode.jsonplaceholder.helpers;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class PostsLogger {

    public static void logList(List<Map.Entry<String, Integer>> sortedWords) {
        int i = 1;

        for (Map.Entry<String, Integer> entry : sortedWords) {
            log.info(i + " ." + entry.getKey() + ": " + entry.getValue());
            i++;
        }
    }
}
