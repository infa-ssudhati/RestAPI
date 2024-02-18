package com.herokuapp.restfulbooks;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class baseTest {
	protected RequestSpecification  spec;
	@BeforeMethod
	public void setup() {
		spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
	}

	protected Response createBooking() {
		
		JSONObject body = new JSONObject();
		
		body.put("firstname","firstname");
		body.put("lastname","Brown");
		body.put("totalprice","111");
		body.put("depositpaid",true);
		
		
		JSONObject bookingdates =new JSONObject();
		bookingdates.put("checkin","2018-01-01");
		bookingdates.put("checkout","2019-01-01");
		body.put("bookingdates",bookingdates);
		body.put("additionalneeds","Baby crib");
		Response response= RestAssured.given(spec).contentType(ContentType.JSON).body(body.toString()).post("/booking");
		response.print();
		return response;
	}
	

}
