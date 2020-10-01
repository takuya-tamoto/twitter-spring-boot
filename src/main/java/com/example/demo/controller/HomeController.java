package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.domain.model.Message;
import com.example.demo.domain.model.MessageForm;
import com.example.demo.domain.model.SignupForm;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.MessageService;
import com.example.demo.domain.service.UserService;

@Controller
@SessionAttributes(types = User.class)
public class HomeController {

	@Autowired
	UserService userService;
	MessageService messageService;

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
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "homeLayout";
	}

	//ユーザー詳細画面
	@GetMapping("/userDetail/{id}")
	public String userDetail(@ModelAttribute SignupForm form, Model model,
			@PathVariable("id") int id) {
		model.addAttribute("contents", "/userDetail :: userDetail_contents");
		User user = userService.findOne(id);
		model.addAttribute("user", user);
		return "homeLayout";
	}

	//投稿画面遷移
	@GetMapping("/message")
	public String getMessage(@ModelAttribute MessageForm form, Model model) {
		model.addAttribute("contents", "/message :: message_contents");
		return "homeLayout";
	}

	//投稿登録機能
	@PostMapping("/message")
	public String postMessage(@ModelAttribute MessageForm form,
			BindingResult result, User user, Model model ) {
		if (result.hasErrors()) {
			return getMessage(form, model);
		}
		System.out.println(form);
		Message msg = new Message();
		msg.setUser_id(user.getId());
		msg.setText(form.getText());
		boolean resultCheck = messageService.insert(msg);
		if (resultCheck == true) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}

		return "redirect:/message";
	}



	//ログアウト用
	@PostMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}

}
