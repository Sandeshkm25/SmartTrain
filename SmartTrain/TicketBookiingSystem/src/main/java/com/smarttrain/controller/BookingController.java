package com.smarttrain.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smarttrain.dto.BookingRequest;

import com.smarttrain.entity.Booking;

import com.smarttrain.serviceimpl.BookingImpl;

@RestController
@RequestMapping("/user/booking")
public class BookingController {

	@Autowired
	BookingImpl bookingImpl;

	@PostMapping
	public String createBooking(@RequestBody BookingRequest request) {
		return bookingImpl.createBooking(request);
	}

	@GetMapping
	public List<Booking> fetchAllBookings() {
		return bookingImpl.fetchAllBookings();
	}

	@DeleteMapping
	public String cancelBooking(@RequestBody Booking booking) {
		return bookingImpl.cancelBooking(booking);
	}
	
	@GetMapping("/userId")
	public List<Booking> findByUserId(@RequestParam Long userId){
		return bookingImpl.findByUserId(userId);
	}
	
	@GetMapping("/all")
	public List<Booking> fetchAllBooking(){
		return bookingImpl.fetchAllBooking();
	}
}
