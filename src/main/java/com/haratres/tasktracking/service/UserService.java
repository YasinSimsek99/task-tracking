package com.haratres.tasktracking.service;

import java.util.List;

import com.haratres.tasktracking.entity.User;

public interface UserService {

	public void save(User user);
	
	public User findByUserName(String userName);
	
	public List<User> getAllUsers();
	
	public User findUserByUserId(Long userId);
}
