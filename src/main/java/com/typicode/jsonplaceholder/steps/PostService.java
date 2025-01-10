package com.typicode.jsonplaceholder.steps;

import com.typicode.jsonplaceholder.api.dto.PostRequestDto;
import com.typicode.jsonplaceholder.config.EndPoints;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static com.typicode.jsonplaceholder.specifications.Specifications.requestSpecification;
import static io.restassured.RestAssured.given;

@Slf4j
public class PostService {

    public Response post(PostRequestDto body, int statusCode) {
        var response = given()
                .spec(requestSpecification())
                .body(body)
                .when()
                .post(EndPoints.POSTS);

        return logAndValidateResponse(response,statusCode);
    }

    private Response logAndValidateResponse(Response resp, int statusCode) {
        log.info("Received response for {}: Status code {}, Body: {}", resp.getStatusCode(), resp.asPrettyString());

        try {
            return resp.then()
                    .statusCode(statusCode)
                    .extract().response();
        } catch (AssertionError ar) {
            log.error("Expected status code {}, but got {}. Full response: {}", statusCode, resp.getStatusCode(), resp.asPrettyString());
            throw ar;
        }
    }
}


