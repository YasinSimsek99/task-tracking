package com.haratres.tasktracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haratres.tasktracking.entity.Task;
import com.haratres.tasktracking.service.TaskService;
import com.haratres.tasktracking.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;

	@GetMapping("/task/list")
	public String testsetset(Model theModel) {
		theModel.addAttribute("tasks", taskService.findAll());
		theModel.addAttribute("select", new Task());
		return "/admin/user-tasks";
	}

	@RequestMapping("/delete/{id}")
	public String deleteTask(@PathVariable(name = "id") Long id) {
		taskService.deleteById(id);
		return "redirect:/admin/task/list";
	}

	@RequestMapping("/edit/{id}")
	public String updateTask(@PathVariable(name = "id") Long id, Model theModel) {
		theModel.addAttribute("task", taskService.findById(id));

		return "/admin/update-task";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("task") Task task) {
		System.err.println(task.toString());

	//	task.setUsername(taskService.findById(task.getId()).getUsername());
		System.err.println(task.toString());
		taskService.save(task);
		return "redirect:/admin/task/list";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("task") Task task) {
		task.setUsername(userService.findUserByUserId(task.getUserId()).getUsername());
		taskService.save(task);
		return "redirect:/admin/task/list";
	}

	@GetMapping("/task/new")
	public String newTask(Model theModel) {
		Task task = new Task();
		theModel.addAttribute("task", task);
		theModel.addAttribute("users", userService.getAllUsers());
		return "/admin/new-task";
	}

	@RequestMapping(value = "/task/list/status", method = RequestMethod.POST)
	public String selectStatus(@ModelAttribute("select") Task task, Model theModel) {
		if (task.getStatus().equals("Hepsi")) {
			return "redirect:/admin/task/list";
		} else {
			theModel.addAttribute("tasks", taskService.findByStatus(task.getStatus()));
			theModel.addAttribute("select", new Task());
			return "/admin/user-tasks";
		}

	}
}
