package com.studentapp.requests;

import java.util.List;

import com.studentapp.pojo.StudentClass;
import com.studentapp.tests.TestBase;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestFactory extends TestBase {

	RequestClient requestClient = new RequestClient();
	
	@Step("Step to get all the students details from database ")
	public Response getAllStudents() {
		
		Response response = requestClient.doGetRequest("/list");
				
				/*RestAssured.given()
				 .when()
				 .get("/list"); */
		
		return response;
	}
	
	@Step("Step to create New Student : {0},{1},{2},{3},{4}")
	public Response createNewStudent(String url,String firstName,String lastName, String email,
			                         String programme,List<String> courses) {
		
		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
			
		return requestClient.doPostRequest(url, student);
	
	}
	
	@Step("Step to update Student put : studentID {0},{1},{2},{3},{4}")
	public Response updateStudent(int studentId,String firstName,String lastName, String email, String programme,List<String> courses) {
		
		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
		return  requestClient.doPutRequest("/"+studentId, student);
		
	}
	
	@Step("Delete student info with id: {0} ")
	public Response deleteStudent(int studentId) {
		return requestClient.doDeletRequest("/"+studentId);
		
		//return response; 
	}

	@Step("get student info by id ")
	public Response getStudentById(int studentId) {
		return requestClient.doGetRequest( "/"+ studentId);
	}
	
}


