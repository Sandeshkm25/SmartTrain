package com.smarttrain.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smarttrain.entity.Train;

import com.smarttrain.serviceimpl.TrainImpl;

@RestController
@RequestMapping("/admin/train")
public class TrainController {

	@Autowired
	TrainImpl impl;
	
	@GetMapping
	public List<Train> fetchAll(){
		 return impl.fetchAll();
	}
	
	@PostMapping("/save")
	public Train add(@RequestBody Train train) {
		return impl.add(train);
	}
	
	@GetMapping("/search")
	public List<Train> searchTrain(@RequestParam String source,@RequestParam String destination,
			@RequestParam @DateTimeFormat(iso =ISO.DATE) LocalDate date){
		return impl.searchTrains(source, destination, date);
	}
	
	@PutMapping("/update")
	public String updateTrain(@RequestBody Train train) {
		return impl.updateTrain(train);
	}
	
	@DeleteMapping("/delete")
	public String delString(@RequestParam Long id) {
		return impl.deleteTrain(id);
	}
}
