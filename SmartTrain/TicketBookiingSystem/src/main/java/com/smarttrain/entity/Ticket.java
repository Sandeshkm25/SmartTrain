package com.smarttrain.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String passengerName;
	private LocalDate traveldate;
	private int seatsBooked;
	private double price;
	private int age;
	private String gender;
	
	@ManyToOne
	@JoinColumn(name="booking_id")
	@JsonBackReference
	private Booking booking;


	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Ticket(String passengerName, LocalDate traveldate, int seatsBooked, double price, int age, String gender,
			Booking booking) {
		super();
		passengerName = passengerName;
		this.traveldate = traveldate;
		this.seatsBooked = seatsBooked;
		this.price = price;
		this.age = age;
		this.gender = gender;
		this.booking = booking;
	}



	public Long getId() {
		return id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public LocalDate getTraveldate() {
		return traveldate;
	}

	public void setTraveldate(LocalDate traveldate) {
		this.traveldate = traveldate;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Booking getBooking() {
		return booking;
	}



	public void setBooking(Booking booking) {
		this.booking = booking;
	}

    
	
	
	
}
