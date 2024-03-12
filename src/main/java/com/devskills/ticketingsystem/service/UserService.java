package com.devskills.ticketingsystem.service;

import java.util.List;

import com.devskills.ticketingsystem.model.Ticket;
import com.devskills.ticketingsystem.model.User;

public interface UserService {
	List<User> getUsers();
	List<Ticket> getTickets(Long id);
	User saveUser(User user);
	User updateUser(Long id, User user);
}
