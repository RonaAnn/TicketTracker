package com.greatlearning.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.greatlearning.app.model.Ticket;
import com.greatlearning.app.repository.TicketRepository;

@Configuration
public class BootStrapAppData {

	@Autowired
	public TicketRepository repository;	

	@EventListener(ApplicationReadyEvent.class)
	public void onReady(ApplicationReadyEvent event) {

		Ticket ticket1 = new Ticket();

		ticket1.setTitle("BA2491A");
		ticket1.setDescription("Kochi - Delhi");
		ticket1.setContent("Business Class");
		this.repository.save(ticket1);

		Ticket ticket2 = new Ticket();

		ticket2.setTitle("SK7631J");
		ticket2.setDescription("Bahrain - Dubai");
		ticket2.setContent("First Class");
		this.repository.save(ticket2);
		

	}

}
