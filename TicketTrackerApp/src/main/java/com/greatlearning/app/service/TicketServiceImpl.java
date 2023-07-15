package com.greatlearning.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.app.model.Ticket;
import com.greatlearning.app.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private final TicketRepository repository;

	public TicketServiceImpl(TicketRepository repository) {

		this.repository = repository;
	}

	@Override
	public List<Ticket> getAllTickets() {

		return this.repository.findAll();
	}

	@Override
	public Ticket getTicketById(int id) {

		Optional<Ticket> ticket = this.repository.findById(id);

		if (ticket.isPresent()) {

			return ticket.get();
		}

		throw new IllegalArgumentException("Invalid  ticket id passed.");
	}

	@Override
	public void deleteTicketById(int id) {

		this.repository.deleteById(id);

	}

	@Override
	public Ticket save(Ticket ticket) {

		return this.repository.save(ticket);
	}

	@Override
	public List<Ticket> findByKeyword(String keyword) {
		
		return this.repository.findByKeyword(keyword);
	}

}
