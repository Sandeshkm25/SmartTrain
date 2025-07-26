package com.smarttrain.serviceimpl;

import java.util.List;

import com.smarttrain.entity.Ticket;

public interface TicketImpl {

	Ticket fetchById(long id);
	List<Ticket> fetchAll();
	String cancelTicket(Long id);
}
