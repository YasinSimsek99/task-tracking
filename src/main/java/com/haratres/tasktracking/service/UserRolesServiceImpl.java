package com.haratres.tasktracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haratres.tasktracking.dao.UserRolesRepository;
import com.haratres.tasktracking.entity.UserRoles;

@Service
public class UserRolesServiceImpl implements UserRolesService {

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Override
	public void save(UserRoles userRole) {
		userRolesRepository.save(userRole);
	}

	@Override
	public void deleteAll() {
		userRolesRepository.deleteAll();
	}

	@Override
	public List<UserRoles> findAll() {
		return userRolesRepository.findAll();
	}

	@Override
	public UserRoles findByUserId(int userId) {
		return userRolesRepository.findByUserId(userId);
	}

}
