package com.engineerlab.api.tests;

import com.engineerlab.api.base.BaseTest;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserDetails extends BaseTest {

    @Test
    public void getSingleUser() {

        given()
                .spec(requestSpec)
        .when()
                .get("/posts/1")
        .then()
                
                .statusCode(200)
                .contentType("application/json")
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", containsString("repellat"));
    }
}