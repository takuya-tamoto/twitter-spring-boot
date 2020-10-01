package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.domain.model.User;

public interface UserDao {

	//Usersテーブルに1件登録
	public int insert(User user) throws DataAccessException;

	//データ1件取得
	public User findOne(int id) throws DataAccessException;

	//全ユーザー情報取得
	public List<User> findAll() throws DataAccessException;

	//ユーザー更新用
	public int update(User user) throws DataAccessException;

}
