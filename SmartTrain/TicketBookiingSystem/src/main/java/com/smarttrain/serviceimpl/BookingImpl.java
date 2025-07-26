package com.smarttrain.serviceimpl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.smarttrain.dto.BookingRequest;
import com.smarttrain.entity.Booking;
import com.smarttrain.entity.Train;

public interface BookingImpl {

	 String createBooking(BookingRequest request);

	 List<Booking> fetchAllBookings();
	 
	 String cancelBooking( Booking booking);
	 
	 List<Booking> findByUserId(Long userId);
	 
	 List<Booking> fetchAllBooking();
	 
	
}
