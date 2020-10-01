package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	//ログイン画面遷移
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	//ログインボタンポスト用
	@PostMapping("/login")
	public String postLogin(Model model) {
		return "redirect:/home";
	}



}
