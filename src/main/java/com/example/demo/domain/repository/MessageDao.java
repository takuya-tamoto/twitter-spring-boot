package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.domain.model.Message;


public interface MessageDao {

	public int insert(Message message) throws DataAccessException;

	//データ1件取得
	public Message findOne(int id) throws DataAccessException;

	//全ユーザー情報取得
	public List<Message> findAll() throws DataAccessException;

}
