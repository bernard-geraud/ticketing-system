package com.devskills.ticketingsystem.service;

import java.util.List;

import com.devskills.ticketingsystem.model.Ticket;
import com.devskills.ticketingsystem.model.User;

public interface TicketService {
	List<Ticket> getTickets();
	Ticket getTicket(Long id);
	Ticket saveTicket(Ticket ticket);
	Ticket updateTicket(Long id, Ticket ticket);
	User assignTicket(Long id, Long userId);
	void deleteTicket(Long id);
}
