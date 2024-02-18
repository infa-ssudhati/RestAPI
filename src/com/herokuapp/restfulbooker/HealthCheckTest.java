package com.herokuapp.restfulbooker;

import org.testng.annotations.Test;

import com.herokuapp.restfulbooks.baseTest;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class HealthCheckTest extends baseTest {
	
	@Test
	public void healthCheckTest() {
		
		
		
		given().spec(spec).
		when().get("/ping")
		.then()
		.assertThat().statusCode(201);
	}
	
	@Test
	public void headerAndCookiesTest() {
		Response response=RestAssured.given(spec).get("/ping");
	//Headers
		Headers headers = response.getHeaders();
		Header Serverheader = headers.get("Server");
		System.out.println(Serverheader.getName() + ":" +Serverheader.getValue());
		String serverHeader2 = response.getHeader("Server");
		System.out.println("Header: " +serverHeader2);
		
		
		//Cookies
		Cookies cookies = response.getDetailedCookies();
		System.out.println("Cookies: " +cookies);
		
	}

}
