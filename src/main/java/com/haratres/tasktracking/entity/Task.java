package com.haratres.tasktracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "task_name")
	private String taskName;
	@Column(name = "username")
	private String username;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private String status;
	@Column(name = "complate_date")
	private String complateDate;
	@Column(name = "user_id")
	private long userId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComplateDate() {
		return complateDate;
	}

	public void setComplateDate(String comlateDate) {
		this.complateDate = comlateDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", username=" + username + ", description=" + description
				+ ", status=" + status + ", complateDate=" + complateDate + ", userId=" + userId + "]";
	}

	public Task(String taskName, String username, String description, String status, String complateDate, long userId) {
		this.taskName = taskName;
		this.username = username;
		this.description = description;
		this.status = status;
		this.complateDate = complateDate;
		this.userId = userId;
	}

	public Task() {
	}

}
