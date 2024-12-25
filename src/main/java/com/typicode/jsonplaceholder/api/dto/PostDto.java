package com.typicode.jsonplaceholder.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private int userId;
    private String title;
    private String body;
    private int id;
}