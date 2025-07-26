package com.smarttrain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarttrain.dto.BookingRequest;
import com.smarttrain.dto.TicketRequest;
import com.smarttrain.entity.Booking;
import com.smarttrain.entity.Ticket;
import com.smarttrain.entity.Train;
import com.smarttrain.entity.User;
import com.smarttrain.exception.ResourceNotFoundException;
import com.smarttrain.repository.BookingRepository;
import com.smarttrain.repository.TrainRepository;
import com.smarttrain.repository.UserRepository;
import com.smarttrain.serviceimpl.BookingImpl;

@Service
public class BookingService implements BookingImpl{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TrainRepository trainRepo;
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Override
	public String createBooking(BookingRequest request) {

		User user =userRepo.findById(request.getUserId()).orElse(null);
		Train train =trainRepo.findById(request.getTrainId()).orElse(null);
		
		Booking booking=new Booking();
		booking.setTrain(train);
		booking.setUser(user);
		booking.setTravelDate(request.getTravelDate());
		booking.setSeatCount(request.getSeatCount());
		List<Ticket> tickets=new ArrayList<Ticket>();
		for(TicketRequest t:request.getTickets()) {
			Ticket ticket=new Ticket();
			ticket.setAge(t.getAge());
			ticket.setGender(t.getGender());
			ticket.setPassengerName(t.getPassengerName());
			ticket.setSeatsBooked(1);
			ticket.setPrice(train.getPricePerSeat());
			ticket.setBooking(booking);
			
			ticket.setTraveldate(request.getTravelDate());
			tickets.add(ticket);
		}
		 booking.setTickets(tickets);
		bookingRepo.save(booking);
		 train.setTotalSeats((train.getTotalSeats()-booking.getSeatCount()));
		 return "Booking successful with " + tickets.size() + " ticket(s)";
		
	
	}

	@Override
	public List<Booking> fetchAllBookings() {
	
		return bookingRepo.findAll();
	}

	@Override
	public String cancelBooking(Booking booking) {
		
		if(bookingRepo.existsById(booking.getId())) {
			bookingRepo.delete(booking);
			Train train= booking.getTrain();
			train.setTotalSeats((train.getTotalSeats()+booking.getSeatCount()));
			trainRepo.save(train);
			return "Booking cancelled and seats restored";
		}
		return "Booking not found";
	}

	@Override
	public List<Booking> findByUserId(Long userId) {
		if(bookingRepo.existsById(userId)) {
			return bookingRepo.findByUserId(userId);
		}
		return null;
	}

	@Override
	public List<Booking> fetchAllBooking() {
		return bookingRepo.findAll();
	}

	
	
}
