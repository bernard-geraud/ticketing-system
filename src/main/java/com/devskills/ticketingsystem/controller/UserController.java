package com.devskills.ticketingsystem.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
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
import com.devskills.ticketingsystem.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("")
	public ResponseEntity< List<User> > getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@GetMapping("/{id}/ticket")
	public ResponseEntity< List<Ticket> > getUserTickets(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(userService.getTickets(id));
	}
	
	@PostMapping("")
	public ResponseEntity<User> CreateUser(@RequestBody User user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return ResponseEntity.ok().body(userService.updateUser(id, user));
	}

}
