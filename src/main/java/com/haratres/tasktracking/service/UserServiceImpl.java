package com.haratres.tasktracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haratres.tasktracking.dao.UserRepository;
import com.haratres.tasktracking.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);		
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.getUserByUsername(userName);
	}

	@Override
	public List<User> getAllUsers() {
		return  userRepository.findAll();
	}

	@Override
	public User findUserByUserId(Long userId) {
		return userRepository.findById(userId).get();
	}

}
