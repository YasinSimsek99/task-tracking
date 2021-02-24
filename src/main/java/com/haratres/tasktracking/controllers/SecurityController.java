package com.haratres.tasktracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haratres.tasktracking.entity.User;
import com.haratres.tasktracking.entity.UserRoles;
import com.haratres.tasktracking.service.UserRolesService;
import com.haratres.tasktracking.service.UserService;

@Controller
public class SecurityController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRolesService userRolesService;

	@RequestMapping({ "/index", "/" })
	public String index() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model theModel) {
		theModel.addAttribute("user", new User());
		return "/security/login";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"))) {
			return "redirect:/admin/task/list";
		}

		else
			return "redirect:/user/homepage";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		System.err.println(user.toString());

		if (userService.findByUserName(user.getUsername()) == null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			userService.save(user);
			user = userService.findByUserName(user.getUsername());

			UserRoles userRoles = new UserRoles();
			userRoles.setRoleId(1);
			userRoles.setUserId(user.getId().intValue());
			
			userRolesService.save(userRoles);
			return "security/register-success";
		} else {
			return "security/register-fail";
		}
	}

}
