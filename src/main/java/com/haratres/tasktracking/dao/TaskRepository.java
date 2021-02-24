package com.haratres.tasktracking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haratres.tasktracking.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	public List<Task> findByUserId(String userId);

	public void deleteById(Long id);

	public Optional<Task> findById(Long id);

	public List<Task> findByUsername(String username);

	public List<Task> findByStatusAndUsername(String status, String username);

	public List<Task> findByStatus(String status);
}
