package com.typicode.jsonplaceholder.helpers;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Logger {

    public static void logList(List<Map.Entry<String, Integer>> list) {
        int i = 1;

        for (Map.Entry<String, Integer> entry : list) {
            log.info(i + " ." + entry.getKey() + ": " + entry.getValue());
            i++;
        }
    }
}
