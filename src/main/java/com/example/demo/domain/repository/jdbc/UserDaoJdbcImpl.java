package com.example.demo.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int insert(User user) throws DataAccessException {
		int rowNumber = jdbc.update("INSERT INTO users ("
				+ "name, "
				+ "account, "
				+ "password, "
				+ "email, "
				+ "description) "
				+ "VALUES (?,?,?,?,?)"
				,user.getName()
				,user.getAccount()
				,user.getPassword()
				,user.getEmail()
				,user.getDescription());
		return rowNumber;
	}

	@Override
	public User findOne(int id) throws DataAccessException {
		return null;
	}

	@Override
	public List<User> findAll() throws DataAccessException {
		return null;
	}

	@Override
	public int update(User user) throws DataAccessException {
		return 0;
	}

}
