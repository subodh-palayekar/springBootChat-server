package com.socketApp.websocket.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socketApp.websocket.model.AppUser;
import com.socketApp.websocket.service.AppUserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AppUserController {
	
	@Autowired
	private AppUserService appUserService;
	
	
	@PostMapping("/register")
	public AppUser registerUser(@RequestBody AppUser user) {
		
		return appUserService.registerUser(user);
	}
	
	@GetMapping("/user")
	public List<AppUser> fetchAllUsers(){
		
		return appUserService.fetchAllUsers();
	}
	
	@PostMapping("/login")
	public AppUser loginUser(@RequestBody AppUser user) throws Exception {
		
		AppUser dbUser = appUserService.getUserByUserName(user.getUserName());
		
		if(dbUser.getPassword().equals(user.getPassword())) {
			
			return dbUser;
		}
		
		throw new Exception("Invalid Credentials");
	}
	
}
