package com.smarttrain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smarttrain.entity.Booking;
import com.smarttrain.entity.Train;


public interface BookingRepository extends JpaRepository<Booking, Long> {

	 List<Booking> findByTrainAndTravelDate(Train train, LocalDate travelDate);
	 
	 List<Booking> findByUserId(Long id);
	 
	 @JsonIgnoreProperties("booking")
	 List<Booking> findAll();
}
