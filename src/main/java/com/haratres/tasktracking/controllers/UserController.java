package com.haratres.tasktracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haratres.tasktracking.entity.Task;
import com.haratres.tasktracking.entity.User;
import com.haratres.tasktracking.service.TaskService;
import com.haratres.tasktracking.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@GetMapping("/homepage")
	public String userHomePage(Model theModel) {
		// seçime göre listeleme
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		theModel.addAttribute("tasks", taskService.findByUsername(authentication.getName()));
		theModel.addAttribute("select", new Task());
		return "/users/homepage";
	}

	@RequestMapping("/new")
	public String showNewTaskForm(Model model) {
		Task task = new Task();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUserName(authentication.getName());

		model.addAttribute("users", user);
		model.addAttribute("task", task);

		return "/users/new-task";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTask(@ModelAttribute("task") Task task) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (task.getUserId() == 0) {

			task.setUserId(userService.findByUserName(authentication.getName()).getId());
		}
		task.setUsername(authentication.getName());
		taskService.save(task);

		return "redirect:/user/homepage";
	}

	@RequestMapping("/edit/{id}")
	public String editUserTask(@PathVariable(name = "id") Long id, Model theModel) {

		theModel.addAttribute("task", taskService.findById(id));
		return "/users/update-task";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {

		return "redirect:/";
	}

	@RequestMapping(value = "/homepage/status", method = RequestMethod.POST)
	public String selectStatus(@ModelAttribute("select") Task task, Model theModel) {

		if (task.getStatus().equals("Hepsi")) {
			return "redirect:/user/homepage";
		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			theModel.addAttribute("tasks",
					taskService.findByStatusAndUsername(task.getStatus(), authentication.getName()));
			theModel.addAttribute("select", new Task());
			return "/users/homepage";
		}

	}

}
