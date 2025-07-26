package com.smarttrain.serviceimpl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.smarttrain.dto.UserLogin;
import com.smarttrain.entity.User;

public interface UserImpl {

//	String login(@RequestBody UserLogin user);
	
	String register(@RequestBody User user);
	
	List<User> getAllUsersWithBookings();
}
