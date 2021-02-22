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
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private String status;
	@Column(name = "complate_date")
	private String comlateDate;
	@Column(name = "user_id")
	private int userId;

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

	public String getComlateDate() {
		return comlateDate;
	}

	public void setComlateDate(String comlateDate) {
		this.comlateDate = comlateDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Task(String taskName, String description, String status, String comlateDate, int userId) {
		this.taskName = taskName;
		this.description = description;
		this.status = status;
		this.comlateDate = comlateDate;
		this.userId = userId;
	}

	public Task() {
	}

}
