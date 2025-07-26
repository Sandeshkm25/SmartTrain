package com.smarttrain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarttrain.dto.UserLogin;
import com.smarttrain.entity.User;
import com.smarttrain.repository.UserRepository;
import com.smarttrain.serviceimpl.UserImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserImpl  impl;
	
//	@PostMapping("/login")
//	public String login(@RequestBody UserLogin user) {
//		return impl.login(user);
//	}
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		return impl.register(user);
	}
	
	@GetMapping("/bookings")
	public List<User> getAllUsersWithBookings(){
		return impl.getAllUsersWithBookings();
	}
}
