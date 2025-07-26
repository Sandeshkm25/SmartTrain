package com.smarttrain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarttrain.entity.Booking;
import com.smarttrain.entity.Train;
import com.smarttrain.repository.BookingRepository;
import com.smarttrain.repository.TrainRepository;
import com.smarttrain.serviceimpl.TrainImpl;

@Service
public class TrainService implements TrainImpl{

	@Autowired
	TrainRepository repo;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public List<Train> fetchAll() {
		return repo.findAll();
	}

	@Override
	public Train add(Train train) {
		return repo.save(train);
	}


	@Override
	public List<Train> searchTrains(String source, String destination, LocalDate date) {
		 List<Train> trains= repo.searchTrain(source, destination);
		 
		 return trains.stream().filter(train -> {
			 List<Booking> booking =bookingRepository.findByTrainAndTravelDate(train, date);
			 int bookedseats = booking.stream().mapToInt(Booking::getSeatCount).sum();
			 return (train.getTotalSeats()-bookedseats)>0;
		 }).collect(Collectors.toList());
	}

	@Override
	public String updateTrain(Train train) {
		if(repo.existsById(train.getId())) {
			repo.save(train);
			return "Train with id :"+train.getId()+" updated Successfully";
		}
		return "Train With Id :"+train.getId()+" not Exist";
	}

	@Override
	public String deleteTrain(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Train with id :"+id+" Deleted Successfully";
		}
		return "Train With Id :"+id+" not Exist";
	}

	
	
}
