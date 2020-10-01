package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Message;
import com.example.demo.domain.repository.MessageDao;

@Service
public class MessageService {

	@Autowired
	MessageDao dao;

	//登録用メソッド
	public boolean insert(Message msg) {
		int rowNumber = dao.insert(msg);
		boolean result = false;
		if (rowNumber > 0) {
			return true;
		}
		return result;
	}

	//ユーザー一覧用
//	public List<User> findAll() {
//		return dao.findAll();
//	}
//
//	//ユーザー1件取得
//	public User findOne(int id) {
//		return dao.findOne(id);
//	}

}
