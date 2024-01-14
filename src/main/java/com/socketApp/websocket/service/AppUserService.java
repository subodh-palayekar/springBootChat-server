package com.socketApp.websocket.service;

import java.util.List;

import com.socketApp.websocket.model.AppUser;

public interface AppUserService {

	AppUser registerUser(AppUser user);

	List<AppUser> fetchAllUsers();

	AppUser getUserByUserName(String userName);

}
