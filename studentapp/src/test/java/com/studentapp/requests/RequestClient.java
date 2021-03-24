package com.studentapp.requests;

import com.studentapp.spec.SpecificationFactory;
import com.studentapp.tests.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class RequestClient extends TestBase {

/*
 * @return  Response of get request 
 */
 public Response doGetRequest(String requestPath) {
		
		return RestAssured.given().when().get(requestPath);
		
	}
 
 /* @uri  url to post request 
  * @body body of the post request
  * @return Response of post Request 
  */
	public Response doPostRequest(String uri,Object body) {
		
		return RestAssured.given()
			  .contentType(ContentType.JSON)
			  .spec(SpecificationFactory.logPayloadResponseInfo())
			  .log()
			  .body()
			  .when()
			  .body(body)
			  .post(uri);
	}
 
	/*
     *   @return response of put request  
     */
	public Response doPutRequest(String uri,Object body) {
	         return given()
				.contentType(ContentType.JSON)
				.when()
				.body(body)
				.put(uri);
	   	
	}
	
	/*
	 * @ return response of patch request
	 * patch update single content 
	 */
	public Response doPatchRequest(String uri,Object body) {
		 return given()
				 .contentType(ContentType.JSON)
				 .when()
				 .body(body)
				 .patch(uri);
	}
	
	/*
	 * @ return response of delete request 
	 */
	public Response doDeletRequest(String uri) {
		
		return given().when().delete(uri);
	}
	
}
