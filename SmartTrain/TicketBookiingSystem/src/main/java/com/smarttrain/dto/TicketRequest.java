package com.smarttrain.dto;


public class TicketRequest {

	private String passengerName;
	private int age;
	private String gender;
	public TicketRequest(String passengerName, int age, String gender) {
		super();
		this.passengerName = passengerName;
		this.age = age;
		this.gender = gender;
	}
	public TicketRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
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
	
	
}
