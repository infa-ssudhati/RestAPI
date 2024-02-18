package com.herokuapp.restfulbooker;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.restfulbooks.Booking;
import com.herokuapp.restfulbooks.Bookingdates;
import com.herokuapp.restfulbooks.Bookingid;
import com.herokuapp.restfulbooks.baseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class createBookingTests extends baseTest{
	@Test(enabled=false)
	public void createBookingTest() {
	Response response = createBooking();
	response.print();
	//get json body
	
	Assert.assertEquals(response.getStatusCode(),200, "Not 200 status code");
	SoftAssert softAssert = new SoftAssert();
	String firstname = response.jsonPath().getString("booking.firstname");
	softAssert.assertEquals(firstname,"firstname", "NA");
	String lastname = response.jsonPath().getString("booking.lastname");
	softAssert.assertEquals(lastname,"Brown", "NA");
	int totalpriceirstname = response.jsonPath().getInt("booking.totalprice");
	softAssert.assertEquals(totalpriceirstname,111, "NA");
	boolean depositpaid = response.jsonPath().getBoolean("booking.depositpaid");
	softAssert.assertTrue(depositpaid,"true");
	String bookingdateschekin = response.jsonPath().getString("booking.bookingdates.checkin");
	softAssert.assertEquals(bookingdateschekin,"2018-01-01", "NA");
	String bookingcheckout = response.jsonPath().getString("booking.bookingdates.checkout");
	softAssert.assertEquals(bookingcheckout,"2019-01-01", "NA");
	String additionalneeds = response.jsonPath().getString("booking.additionalneeds");
	softAssert.assertEquals(additionalneeds,"Baby crib", "NA");
	softAssert.assertAll();
	
	//assert the json body
	
	//
	}
	@Test
	public void createBookingPOJOTest() {
	//create body using pojo
		Bookingdates bookingdates = new Bookingdates("2018-01-01", "2019-01-01");
		Booking booking =new Booking("Smith", "pepa", 123, false, bookingdates, "happy");
		//get json body
		
		
		Response response = RestAssured.given(spec).contentType(ContentType.JSON).body(booking).post("/booking");
		response.print();
		Bookingid bookingid=response.as(Bookingid.class);
		Assert.assertEquals(response.getStatusCode(),200, "Not 123 status code");
		
		System.out.println("response booking "+bookingid.getBooking().toString());
		System.out.println(" Request booking"+booking.toString());
		
		Assert.assertEquals(bookingid.getBooking().toString(), booking.toString());
		
		/* not needed for pojo deserialization
		SoftAssert softAssert = new SoftAssert();
		String firstname = response.jsonPath().getString("booking.firstname");
		softAssert.assertEquals(firstname,"Smith", "NA");
		String lastname = response.jsonPath().getString("booking.lastname");
		softAssert.assertEquals(lastname,"pepa", "NA");
		int totalpriceirstname = response.jsonPath().getInt("booking.totalprice");
		softAssert.assertEquals(totalpriceirstname,123, "NA");
		boolean depositpaid = response.jsonPath().getBoolean("booking.depositpaid");
		softAssert.assertFalse(depositpaid,"False");
		String bookingdateschekin = response.jsonPath().getString("booking.bookingdates.checkin");
		softAssert.assertEquals(bookingdateschekin,"2018-01-01", "NA");
		String bookingcheckout = response.jsonPath().getString("booking.bookingdates.checkout");
		softAssert.assertEquals(bookingcheckout,"2019-01-01", "NA");
		String additionalneeds = response.jsonPath().getString("booking.additionalneeds");
		softAssert.assertEquals(additionalneeds,"happy", "NA");
		softAssert.assertAll();
		*/
		
		//assert the json body
		
		//
		}
}
