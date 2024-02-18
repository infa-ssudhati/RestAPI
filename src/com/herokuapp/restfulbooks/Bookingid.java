package com.herokuapp.restfulbooks;

public class Bookingid {
	
private  int bookingid;
private Booking booking;
	


	public Bookingid() {
		// TODO Auto-generated constructor stub
	}



	public Bookingid(int bookingid, Booking booking) {
		
		this.bookingid = bookingid;
		this.booking = booking;
	}



	public int getBookingid() {
		return bookingid;
	}



	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}



	public Booking getBooking() {
		return booking;
	}



	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
