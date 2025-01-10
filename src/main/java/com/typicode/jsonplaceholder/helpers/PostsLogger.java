package com.typicode.jsonplaceholder.helpers;

import java.util.List;
import java.util.Map;

public class PostsLogger {

    public static void logList(List<Map.Entry<String, Integer>> sortedWords, org.apache.logging.log4j.Logger logger) {
        int i = 1;

        for (Map.Entry<String, Integer> entry : sortedWords) {
            logger.info(i + " ." + entry.getKey() + ": " + entry.getValue());
            i++;
        }
    }
}
