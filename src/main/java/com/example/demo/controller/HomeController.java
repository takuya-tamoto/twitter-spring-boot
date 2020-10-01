package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService service;

	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("contents", "/home :: home_contents");
		return "homeLayout";
	}

	@PostMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}

}
