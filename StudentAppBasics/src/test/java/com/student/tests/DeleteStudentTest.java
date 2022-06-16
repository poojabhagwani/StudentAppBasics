package com.student.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

public class DeleteStudentTest extends TestBase{
	
	@Test
	void deleteStudent() {
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.delete("/101")
		.then().statusCode(204);
	}

}
