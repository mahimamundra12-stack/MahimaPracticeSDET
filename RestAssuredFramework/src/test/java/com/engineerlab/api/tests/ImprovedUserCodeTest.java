package com.engineerlab.api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ImprovedUserCodeTest  {

    @Test
    public void verifyGetPost() {
        Response response = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");

        System.out.println("Status Code : " + response.statusCode());
        System.out.println("Content Type : " + response.getContentType());
        System.out.println("Title : " + response.jsonPath().getString("title"));
        System.out.println("User ID : " + response.jsonPath().getInt("userId"));
        System.out.println("Response Time : " + response.getTime());
        System.out.println("Server : "+ response.getHeader("Server"));
        System.out.println("Cache Control : "+ response.getHeader("Cache-Control"));
        //  .then()
        // .log().all()

        // .statusCode(200)
        // .body("id", equalTo(1))
        // .body("title", notNullValue());
    }
}
