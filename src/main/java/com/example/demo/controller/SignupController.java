package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.GroupOrder;
import com.example.demo.domain.model.SignupForm;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

@Controller
public class SignupController {


	@Autowired
	private UserService userService;
	//新規登録画面遷移
	@GetMapping("/signup")
	public String signUp(@ModelAttribute SignupForm form, Model model) {
		return "signup";
	}

	//ユーザー情報をPOST
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return signUp(form, model);
		}
		System.out.println(form);
		User user = new User();
		user.setName(form.getName());
		user.setAccount(form.getAccount());
		user.setPassword(form.getPassword());
		user.setEmail(form.getEmail());
		user.setDescription(form.getDescription());
		boolean resultCheck = userService.insert(user);
		if (resultCheck == true) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}

		return "redirect:/login";
	}

}
