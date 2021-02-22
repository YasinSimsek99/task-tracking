package com.haratres.tasktracking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haratres.tasktracking.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	public List<Task> findByUserId(String userId);
}
