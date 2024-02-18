package com.herokuapp.restfulbooker;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.restfulbooks.baseTest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class getBokkingTests extends baseTest{
	
	
	@Test(enabled=false)
	public void getBokking() {
		//questSpecification  spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
		spec.pathParam("bookingId",5);
		
		
	
		Response response=RestAssured.given(spec).get("/booking/{bookingId}");
		response.print();
		Assert.assertEquals(response.getStatusCode(),200, "Not 200 status code");
		SoftAssert softAssert = new SoftAssert();
		String firstname = response.jsonPath().getString("firstname");
		softAssert.assertEquals(firstname,"Mary", "NA");
		String lastname = response.jsonPath().getString("lastname");
		softAssert.assertEquals(lastname,"Ericsson", "NA");
		int totalpriceirstname = response.jsonPath().getInt("totalprice");
		softAssert.assertEquals(totalpriceirstname,937, "NA");
		boolean depositpaid = response.jsonPath().getBoolean("depositpaid");
		softAssert.assertFalse(depositpaid,"NA");
		String bookingdateschekin = response.jsonPath().getString("bookingdates.checkin");
		softAssert.assertEquals(bookingdateschekin,"2021-10-07", "NA");
		String bookingcheckout = response.jsonPath().getString("bookingdates.checkout");
		softAssert.assertEquals(bookingcheckout,"2023-02-05", "NA");
		String additionalneeds = response.jsonPath().getString("additionalneeds");
		softAssert.assertEquals(additionalneeds,"Breakfast", "NA");
		
	}
	@Test
	public void getBookingXML() {
		//questSpecification  spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
		spec.pathParam("bookingId",5);
		Header xml = new Header("Accept", "application/xml");
		spec.header(xml);
	
		Response response=RestAssured.given(spec).get("/booking/{bookingId}");
		response.print();
		Assert.assertEquals(response.getStatusCode(),200, "Not 200 status code");
		SoftAssert softAssert = new SoftAssert();
		String firstname = response.xmlPath().getString("booking.firstname");
		softAssert.assertEquals(firstname,"Mary", "NA");
		String lastname = response.xmlPath().getString("booking.lastname");
		softAssert.assertEquals(lastname,"Ericsson", "NA");
		int totalpriceirstname = response.xmlPath().getInt("booking.totalprice");
		softAssert.assertEquals(totalpriceirstname,937, "NA");
		boolean depositpaid = response.xmlPath().getBoolean("booking.depositpaid");
		softAssert.assertFalse(depositpaid,"NA");
		String bookingdateschekin = response.xmlPath().getString("booking.bookingdates.checkin");
		softAssert.assertEquals(bookingdateschekin,"2021-10-07", "NA");
		String bookingcheckout = response.xmlPath().getString("booking.bookingdates.checkout");
		softAssert.assertEquals(bookingcheckout,"2023-02-05", "NA");
		String additionalneeds = response.xmlPath().getString("booking.additionalneeds");
		softAssert.assertEquals(additionalneeds,"Breakfast", "NA");
		
	}


}
