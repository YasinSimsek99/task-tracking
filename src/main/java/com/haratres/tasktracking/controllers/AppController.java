package com.haratres.tasktracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haratres.tasktracking.entity.User;
import com.haratres.tasktracking.service.UserService;

@Controller

public class AppController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {

		return "index";
	}

	@RequestMapping("/new")
	public String showNewTaskForm(Model model) {

		return "new_product";
	}

	@RequestMapping("/delete/{id}")
	public String deleteTask(@PathVariable(name = "id") Long id) {

		return "redirect:/";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegister(Model theModel, User user) {

		User user2 = (User) theModel.getAttribute("user");
		System.out.println(user.getUsername() + " : " + user.getPassword() + "\n" + user2.getUsername() + " : "
				+ user2.getPassword());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user2.getPassword());
		user2.setPassword(encodedPassword);
// user standart user olarak diğer yerlere de tanımlanmalı
		// role_id = 1
		// user_roles tablosuna git => user_id ve role id yaz
		userService.save(user2);

		return "register_success";
	}
}
