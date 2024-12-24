package com.typicode.jsonplaceholder.specifications;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.typicode.jsonplaceholder.config.Config.config;

public class Specifications {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(config.getBaseUriResources())
                .addFilter(FILTER)
                .build();
    }
}
