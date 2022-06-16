package com.student.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

public class CreateStudentPOJOPayloadTest extends TestBase{
	
	@Test
	void createNewStudent() {
		List<String> courses = new ArrayList<String>();
		Faker fake = new Faker();
		courses.add("JAVA");
		courses.add("C++");
		
		StudentPojo student = new StudentPojo();
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then().statusCode(201);
	}

}
