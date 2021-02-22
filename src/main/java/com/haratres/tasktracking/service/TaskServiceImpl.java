package com.haratres.tasktracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haratres.tasktracking.dao.TaskRepository;
import com.haratres.tasktracking.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

	private TaskRepository taskRepository;

	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

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
	
	
}
