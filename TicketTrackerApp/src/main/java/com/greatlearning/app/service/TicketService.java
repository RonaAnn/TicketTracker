package com.greatlearning.app.service;

import java.util.List;

import com.greatlearning.app.model.Ticket;

public interface TicketService {

	public List<Ticket> getAllTickets();

	public Ticket getTicketById(int id);

	public void deleteTicketById(int id);

	public Ticket save(Ticket ticket);
	
	public List<Ticket> findByKeyword(String keyword);

}
