package com.greatlearning.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.app.model.Ticket;
import com.greatlearning.app.service.TicketServiceImpl;

@Controller
@RequestMapping("/admin")
public class TicketTrackerAppController {

	@Autowired
	private TicketServiceImpl service;

	public TicketTrackerAppController(TicketServiceImpl ticketServiceImpl) {

		service = ticketServiceImpl;
	}

	@GetMapping("/tickets")
	public String homePage(Model model) {

		List<Ticket> tickets = service.getAllTickets();
		model.addAttribute("tickets", tickets);

		return ("admin/tickets-list");
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("ticket") Ticket ticket) {

		this.service.save(ticket);

		return "redirect:/admin/tickets";
	}

	@PostMapping("/view")
	public String getTicketById(@RequestParam("id") int id, Model model) {

		Ticket ticket = service.getTicketById(id);
		model.addAttribute("tickets", ticket);

		return "admin/ticket-view";
	}

	@GetMapping("/add")
	public String addNewTicket(Model model) {

		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);

		return "admin/ticket-create-form";
	}

	@PostMapping("/update")
	public String updateTicketInfo(@RequestParam("id") int id, Model model) {

		Ticket ticket = service.getTicketById(id);

		model.addAttribute("ticket", ticket);

		return "admin/ticket-edit-form";
	}

	@PostMapping("/delete")
	public String deleteTicket(@RequestParam("id") int id) {

		service.deleteTicketById(id);

		return ("redirect:/admin/tickets");
	}
	
	@GetMapping("/search")
	public String home(@RequestParam("keyword")String keyword,Model model) {
		if (keyword != null) {
			List<Ticket> ticket1 = service.findByKeyword(keyword.toUpperCase());
			model.addAttribute("tickets", ticket1);
		} else {
			List<Ticket> list = service.getAllTickets();
			model.addAttribute("tickets", list);
		}
		return "admin/tickets-list";
	}
}
