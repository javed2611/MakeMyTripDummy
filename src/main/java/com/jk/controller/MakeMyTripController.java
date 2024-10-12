package com.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jk.response.Passenger;
import com.jk.response.Ticket;
import com.jk.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	@Autowired
	private MakeMyTripService makeMyTripService;

	@GetMapping("/")
	public String index(Model model) {
		Ticket[] ticket = makeMyTripService.getTicket();
		model.addAttribute("tickets", ticket);
		return "index";
	}

	@GetMapping("/bookTicket")
	public String loadBookTicketPage(Model model) {
		Passenger passenger = new Passenger();
		model.addAttribute("passenger", passenger);
		return "bookTicket";
	}

	@PostMapping("/ticket")
	public String bookTicket(Passenger passenger, Model model) {
		Ticket ticket = makeMyTripService.bookTickets(passenger);
		model.addAttribute("ticket", ticket);
		return "bookTicket";
	}
}
