package com.alkemy.movie.movie;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    @Test
    public void postTest() {
        RestAssured.baseURI = "http://localhost:8095";
        String myData = "{\n" +
                "    \"name_genre\": \"drama\",\n" +
                "    \"image_genre\": \"/usr/tmp/drama.jpg\"\n" +
                "}";
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(myData)
                .when()
                        .post("/genrefilms")
                .then()
                        .extract().response();
        //System.out.println(response.body().asString());
        //System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
        //Assert.assertEquals(response.jsonPath().getInt("id"),1);
    }
    @Test
    public void getTest() {
        RestAssured.baseURI = "http://localhost:8095/";
        Response response =
                given()
                        .contentType(ContentType.JSON)
                .when()
                        .get("/genrefilms")
                .then()
                        .extract().response();
        System.out.println(response.body().asString());
        System.out.println(response.getStatusCode());
    }
}
