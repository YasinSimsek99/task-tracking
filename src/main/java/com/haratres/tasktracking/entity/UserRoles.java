package com.haratres.tasktracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRoles {

	@Id
	@Column(name = "user_id")
	private int userId;
	@Column(name = "role_id")
	private int roleId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public UserRoles(int userId, int roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public UserRoles() {
	}

}
