package com.devskills.ticketingsystem.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devskills.ticketingsystem.model.Ticket;
import com.devskills.ticketingsystem.model.User;
import com.devskills.ticketingsystem.service.TicketService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
	
	private final TicketService ticketService;
	
	@GetMapping("")
	public ResponseEntity< List<Ticket> > getTickets() {
		return ResponseEntity.ok().body(ticketService.getTickets());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(ticketService.getTicket(id));
	}
	
	@PostMapping("")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/tickets").toUriString());
		return ResponseEntity.created(uri).body(ticketService.saveTicket(ticket));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") Long id, @RequestBody Ticket ticket) {
		return ResponseEntity.ok().body(ticketService.updateTicket(id, ticket));
	}
	
	@PutMapping("/{id}/assign/{userId}")
	public ResponseEntity<User> assignTicket(@PathVariable("id") Long id, @PathVariable("userId") Long useId) {
		return ResponseEntity.ok().body(ticketService.assignTicket(id, useId));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable("id") Long id) {
		ticketService.deleteTicket(id);
		return ResponseEntity.ok().build();
	}
	
}
