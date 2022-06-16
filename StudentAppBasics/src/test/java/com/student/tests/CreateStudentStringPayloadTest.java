package com.student.tests;

import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateStudentStringPayloadTest extends TestBase{
	
	@Test
	void createNewStudent() {
		String payload="{\"firstName\":\"Reece\",\"lastName\":\"Jason\",\"email\":\"test5@gmail.com\",\"programme\":\"Computer Science\",\"courses\":[\"C++\",\"JAVA\"]}";
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(payload)
		.post()
		.then().statusCode(201);
	}

}
