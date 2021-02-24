package com.haratres.tasktracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haratres.tasktracking.dao.TaskRepository;
import com.haratres.tasktracking.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void save(Task task) {
		taskRepository.save(task);
	}

	@Override
	public void deleteAll() {
		taskRepository.deleteAll();
	}

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public List<Task> findByUserId(String userId) {
		return taskRepository.findByUserId(userId);
	}

	@Override
	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public Task findById(Long id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public List<Task> findByUsername(String username) {

		return taskRepository.findByUsername(username);
	}

	@Override
	public List<Task> findByStatusAndUsername(String status, String username) {
		return taskRepository.findByStatusAndUsername(status, username);
	}

	@Override
	public List<Task> findByStatus(String status) {
		return taskRepository.findByStatus(status);
	}

}
