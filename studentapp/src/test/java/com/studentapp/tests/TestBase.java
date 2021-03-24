package com.studentapp.tests;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.studentapp.util.PropertyReader;

import io.restassured.RestAssured;


public class TestBase {

	public static PropertyReader prop;
	
	@Rule
	public TestRule listner = new TestWatcher() {
		
		@Override
		protected void succeeded(Description description) {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		}
		
		@Override
		protected void failed(Throwable e, Description description) {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.err.println("Test Failed : " + description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}

		@Override
		protected void starting(Description description) {
			

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Starting Test: " + description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}

		@Override
		protected void finished(Description description) {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Ending Test: " + description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
	};
	
	@BeforeClass
	public static void initURL() {
	    prop = PropertyReader.getInstance();
	 	
		RestAssured.baseURI= prop.getProperty("baseUrl"); //"http://localhost/student";
		RestAssured.port= Integer.valueOf(prop.getProperty("port"));//8085;
		//RestAssured.port= 8085;
	}
}
