package com.student.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class MyFirstTest extends TestBase{
	
	private void styles() {
       RestAssured.given()
       .queryParam("", "")
 .when()
 .get("https://www.google.com")
 .then();

       
       RestAssured.given()
                  .expect()
                  .when();
}
	
	@Test
	void getAllStudents() {
		/*
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get("http://localhost:8085/student/list");
		response.prettyPrint();
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
		*/
		//RestAssured.given().when().get("http://localhost:8085/student/list").then().statusCode(200);
		RestAssured.given()
        .expect()
        .statusCode(200)
        .when()
        .get("/list");
		
		given().when().get("/list").then().statusCode(200);
	}
	//@Disabled
	@Test
	void getSingleStudent() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("programme", "Computer Science");
		params.put("limit", "1");
		Response response = given()
				//.queryParam("programme","Computer Science")
				//.queryParam("limit","1")
				.queryParams(params)
				.when()
				.get("/list");
		
		response.prettyPrint();
	}
	
	@Test
	void getFirstStudent() {
		Response response = given()
				.pathParam("id", 2)
				//.queryParam("programme","Computer Science")
				//.queryParam("limit","1")
				//.queryParams(params)
				.when()
				.get("/{id}");
		
		response.prettyPrint();
	}
	}

