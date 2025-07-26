package com.smarttrain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarttrain.dto.UserLogin;
import com.smarttrain.entity.User;
import com.smarttrain.repository.UserRepository;
import com.smarttrain.serviceimpl.UserImpl;

@Service
public class UserService implements UserImpl
{

	@Autowired
	UserRepository userRepo;
	
//	@Override
//	public String login(UserLogin user) {
//		List<User> dbUser = userRepo.findByEmail(user.getEmail());
//		if(dbUser!=null && dbUser.getPassword().equals(user.getPassword()) ) {
//			 return "Login "+dbUser.getName()+" successfully";
//		}
//		return "Login "+dbUser.getName()+" Unsuccessfull";
//	}

	@Override
	public String register(User user) {
		 if(userRepo.findByEmail(user.getEmail())!=null) {
			  
			 return "email already Registered";
		 }
		 userRepo.save(user);
		 return "user Registered successfully";
	}

	@Override
	public List<User> getAllUsersWithBookings() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
