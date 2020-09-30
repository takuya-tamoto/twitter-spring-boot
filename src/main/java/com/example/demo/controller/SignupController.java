package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.SignupForm;

@Controller
public class SignupController {

	//新規登録画面遷移
	@GetMapping("/signup")
	public String signUp(@ModelAttribute SignupForm form, Model model) {
		return "signup";
	}

	//ユーザー情報をPOST
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm form,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return signUp(form, model);
		}
		System.out.println(form);
		return "redirect:/login";
	}

}
