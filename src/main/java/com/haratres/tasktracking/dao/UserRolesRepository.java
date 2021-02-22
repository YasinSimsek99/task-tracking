package com.haratres.tasktracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haratres.tasktracking.entity.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer>{
	
	public UserRoles findByUserId(int userId);

}
