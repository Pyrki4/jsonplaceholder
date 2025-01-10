package com.typicode.jsonplaceholder.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private int userId;
    private String title;
    private String body;
    private int id;
}