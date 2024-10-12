package com.jk.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jk.response.Passenger;
import com.jk.response.Ticket;

@Service
public class MakeMyTripService {
	public static final String BOOK_TICKET_URL = "https://classes.ashokit.in/ticket";
	public static final String GET_TICKET_URL = "https://classes.ashokit.in/tickets";

	public Ticket bookTickets(Passenger passenger) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		return responseEntity.getBody();
	}

	public Ticket[] getTicket() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket[]> responseEntity = rt.getForEntity(GET_TICKET_URL, Ticket[].class);

		return responseEntity.getBody();
	}
}
