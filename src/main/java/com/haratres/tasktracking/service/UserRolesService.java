package com.haratres.tasktracking.service;

import java.util.List;

import com.haratres.tasktracking.entity.UserRoles;

public interface UserRolesService {
	
	public void save(UserRoles userRole);
	
	public void deleteAll();
	
	public List<UserRoles> findAll();
	
	public UserRoles findByUserId(int userId);

}
