package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	//登録用メソッド
	public boolean insert(User user) {
		int rowNumber = dao.insert(user);
		boolean result = false;
		if (rowNumber > 0) {
			return true;
		}

		return result;
	}

}
