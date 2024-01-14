package com.socketApp.websocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socketApp.websocket.model.AppUser;
import com.socketApp.websocket.repository.AppUserRepository;


@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public AppUser registerUser(AppUser user) {
		
		try {
			return appUserRepository.save(user);
		} catch (Exception e) {
			throw new RuntimeException("error while Registering user" + e.getMessage());
		}
	}

	@Override
	public List<AppUser> fetchAllUsers() {
		
		try {
			return appUserRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("error while getting all user" + e.getMessage());
		}
	}

	@Override
	public AppUser getUserByUserName(String userName) {
		
		try {
			return appUserRepository.findAppUserByUserName(userName);
		} catch (Exception e) {
			 throw new RuntimeException("User Not found");
		}
	}

}
