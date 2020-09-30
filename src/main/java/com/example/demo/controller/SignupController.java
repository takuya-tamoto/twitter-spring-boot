package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
	
	//新規登録画面遷移
	@GetMapping("/signup")
	public String signUp(Model model) {
		return "signup";
	}
	
	//ユーザー情報をPOST
	@PostMapping("/signup")
	public String postSignUp(Model model) {
		return "redirect:/login"; 
	}

}
