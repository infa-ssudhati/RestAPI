package com.herokuapp.restfulbooker;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.restfulbooks.baseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PartialUpdateBookingTests extends baseTest {
	@Test
	public void updateBookingTest() {
		
		Response response = createBooking();
	//	response.print();
		//update booking
		int bookingId = response.jsonPath().getInt("bookingid");
		// create JSON Body
		

		JSONObject body = new JSONObject();
		
		body.put("firstname","James");
		body.put("lastname","Bru");
				
		JSONObject bookingdates =new JSONObject();
		bookingdates.put("checkin","2018-04-01");
		bookingdates.put("checkout","2019-04-01");
		body.put("bookingdates",bookingdates);
		//body.put("additionalneeds","Baby crib");
			
		
		//get booking
		
		Response responseupdate= RestAssured.given(spec).auth().preemptive().basic("admin", "password123").contentType(ContentType.JSON).body(body.toString()).patch("/booking/"+bookingId);
		responseupdate.print();
		
		
		Assert.assertEquals(responseupdate.getStatusCode(),200, "Not 200 status code");
		SoftAssert softAssert = new SoftAssert();
		String firstname = responseupdate.jsonPath().getString("firstname");
		softAssert.assertEquals(firstname,"James", "NA");
		String lastname = responseupdate.jsonPath().getString("lastname");
		softAssert.assertEquals(lastname,"Bru", "NA");
		int totalpriceirstname = responseupdate.jsonPath().getInt("totalprice");
		softAssert.assertEquals(totalpriceirstname,111, "NA");
		boolean depositpaid = responseupdate.jsonPath().getBoolean("depositpaid");
		softAssert.assertTrue(depositpaid,"true");
		String bookingdateschekin = responseupdate.jsonPath().getString("bookingdates.checkin");
		softAssert.assertEquals(bookingdateschekin,"2018-04-01", "NA");
		String bookingcheckout = responseupdate.jsonPath().getString("bookingdates.checkout");
		softAssert.assertEquals(bookingcheckout,"2019-04-01", "NA");
		String additionalneeds = responseupdate.jsonPath().getString("additionalneeds");
		softAssert.assertEquals(additionalneeds,"Baby crib", "NA");
		softAssert.assertAll();
	}

}
