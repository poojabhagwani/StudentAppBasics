package com.student.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

public class UpdateStudentEmailTest extends TestBase{
	
	@Test
	void updateStudent() {
		StudentPojo student = new StudentPojo();
		Faker fake = new Faker();
		student.setEmail(fake.internet().emailAddress());
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/101")
		.then().statusCode(200);
	}

}
