package com.haratres.tasktracking.service;

import java.util.List;

import com.haratres.tasktracking.entity.Task;

public interface TaskService {

	public void save(Task task);

	public void deleteAll();

	public List<Task> findAll();

	public List<Task> findByUserId(String userId);

}
