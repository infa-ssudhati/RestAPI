package com.herokuapp.restfulbooker;

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
import com.herokuapp.restfulbooks.baseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getBookingIdsTests extends baseTest{

@Test

public void getBookingIdsWithoutFilterTest() {
	
//Get Response with booking Ids
	Response response = RestAssured.given(spec).get("/booking");
	response.print();
	Assert.assertEquals(response.getStatusCode(),200, "Not 200 status code");
	List<Integer> bookingIds = response.jsonPath().getList("bookingid");
	Assert.assertFalse(bookingIds.isEmpty(),"List of booking Ids's in empty but it should not be");
	
	
	//verify response code
	
}
@Test
public void getBookingIdsWithFilterTest() {
	spec.queryParam("firstname", "Susan");
	Response response = RestAssured.given(spec).get("/booking");
	response.print();
	Assert.assertEquals(response.getStatusCode(),200, "Not 200 status code");
	List<Integer> bookingIds = response.jsonPath().getList("bookingid");
	Assert.assertFalse(bookingIds.isEmpty(),"List of booking Ids's in empty but it should not be");
	
	
}

	
}
