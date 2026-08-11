package com.engineerlab.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserTest {
    String baseUrl = "https://jsonplaceholder.typicode.com";

    @Test

    public void verifyGetPost() {

        Response response =

                given()
                        .when()
                        .get(baseUrl + "/posts/1");

        Assert.assertEquals(response.statusCode(), 200);

        System.out.println(response.jsonPath().getString("title"));
        System.out.println(response.prettyPeek());
        Assert.assertTrue( response.jsonPath().getString("title").contains("repellat"));
        // given()

        // .when()

        // .get("https://jsonplaceholder.typicode.com/posts/1")

        // .then()
        // .log().all()

        // .statusCode(200)
        // .body("id", equalTo(1))
        // .body("title", notNullValue());
    }
}
