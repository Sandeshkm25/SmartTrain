package com.smarttrain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarttrain.entity.Ticket;
import com.smarttrain.repository.TicketRepository;
import com.smarttrain.serviceimpl.TicketImpl;


@Service
public class TicketService implements TicketImpl{

	@Autowired
	TicketRepository repo;
	
	
	
	@Override
	public Ticket fetchById(long id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Ticket> fetchAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String cancelTicket(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Ticket with :"+id+" deleted";
			
		}
		return "Ticket With :"+id+" not Found";
		
	}

	
	
}
