package com.smarttrain.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.smarttrain.entity.Train;

public interface TrainImpl {

	List<Train> fetchAll();
	
	Train add(@RequestBody Train train) ;
	
	 List<Train> searchTrains(String source,String destination,LocalDate date);
	 
	 String updateTrain(Train train);
	 String deleteTrain(Long id);
}
