package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService service;
	//ホーム画面遷移
	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("contents", "/home :: home_contents");
		return "homeLayout";
	}

	//ユーザー一覧表示
	@GetMapping("/userList")
	public String getUserList(Model model) {
		model.addAttribute("contents", "/userList :: userList_contents");
		List<User> userList = service.findAll();
		model.addAttribute("userList", userList);
		return "homeLayout";
	}


	//ログアウト用
	@PostMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}

}
