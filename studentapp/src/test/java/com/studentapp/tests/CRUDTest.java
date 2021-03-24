package com.studentapp.tests;


import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.javafaker.Faker;
import com.studentapp.pojo.StudentClass;
import com.studentapp.requests.RequestFactory;
import com.studentapp.spec.SpecificationFactory;
import com.studentapp.tags.Regression;
import com.studentapp.tags.Smoke;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Story("Student CRUD Operations")
public class CRUDTest extends TestBase {

	RequestFactory request = new RequestFactory();
	
	@Category(Smoke.class)
	@Story("Get Student List")
	@DisplayName("Test to get all the students ")
	@Feature("Student Feature")
	@Tag("Smoke")
	@Test
	public void getAllStudents() {
		
		
		request.getAllStudents()
		.then()
		.spec(SpecificationFactory.getGenericResponseSpec())
		.statusCode(200);
		
	/*	RestAssured.given()
		.when() 	
		.get("/list")
		.then()
		.log()
		.body()
		.statusCode(200); 	*/
		
	}
	/*
	 * { "firstName": "MurphyYtest", "lastName": "Holmes", "email":
	 * "faucibus.orci.test@Duisac.net", "programme": "Financial Analysis",
	 * "courses": [ "Accounting", "Statistics" ] }
	 * 
	 */
	@Category({Regression.class,Smoke.class})
	@Story("To create Student")
	@DisplayName("Test to create Student ")
	@Feature("Student Feature")
	@Tag("Regresssion,Smoke")
	@Test
	public void createStudentTest() {
		
		List<String> courses = new ArrayList<String>();
		courses.add("Accounting");
		courses.add("Statistics");
					
		Faker fake = new Faker();
		String firstName =fake.name().firstName();
		String lastName= fake.name().lastName();
		String email=fake.internet().emailAddress();
		
		String programme ="Quality Analyst";
			
		request.createNewStudent("", firstName, lastName, email, programme, courses)
		.then()
		.spec(SpecificationFactory.getGenericResponseSpec())
		.log().all()
		.statusCode(201);
		
		/*	
		 * 
		 *
		 * 
		 * 	List<String> courses = new ArrayList<String>();
		courses.add("Accounting");
		courses.add("Statistics");
		
		StudentClass student = new StudentClass();
		
		Faker fake = new Faker();
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
		
		student.setProgramme("Quality Analyst");
		student.setCourses(courses);
		
		 given()
		.when()
		.contentType(ContentType.JSON)
		.log()
		.body()     
		.when()   
		.body(student)
		.post()
		.then()
		.statusCode(201)
		;
		 
		 List<String> courses = new ArrayList<String>();
		courses.add("Accounting");
		courses.add("Statistics");
		request.createNewStudent("", "Muritest", "TestLast", "Test@Testone.com", "Financial Analysis", courses).then().statusCode(201);
		
		List<String> courses = new ArrayList<String>();
		courses.add("Accounting");
		courses.add("Statistics");
		
		StudentClass student = new StudentClass();
		student.setFirstName("Test122");
		student.setLastName("stus");
		student.setEmail("test@test.com");
		student.setProgramme("Quality Analyst");
		student.setCourses(courses);
		
		 given()
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201)
		
		;*/
	}
}
