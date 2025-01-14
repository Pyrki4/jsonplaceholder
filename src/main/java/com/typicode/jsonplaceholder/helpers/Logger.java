package com.typicode.jsonplaceholder.helpers;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Logger {

    @Step("Логирование списка слов с их количеством в постах")
    public static void logList(List<Map.Entry<String, Integer>> list) {
        int i = 1;

        for (Map.Entry<String, Integer> entry : list) {
            log.info(i + " ." + entry.getKey() + ": " + entry.getValue());
            i++;
        }
    }
}
