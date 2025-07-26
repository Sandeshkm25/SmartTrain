package com.smarttrain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarttrain.entity.Ticket;
import com.smarttrain.serviceimpl.TicketImpl;

@RestController
@RequestMapping("/user/ticket")
public class TicketController {

	@Autowired
	TicketImpl impl;
	
	@GetMapping("/{id}")
	public Ticket fetchById(@PathVariable long id){
		return impl.fetchById(id);
	}
	
	@GetMapping("/all")
	public List<Ticket> fetchAll() {
		return impl.fetchAll();
	}
	
	@DeleteMapping("/{id}")
	public String cancelTicket(@PathVariable Long id) {
		return impl.cancelTicket(id);
	}
}
