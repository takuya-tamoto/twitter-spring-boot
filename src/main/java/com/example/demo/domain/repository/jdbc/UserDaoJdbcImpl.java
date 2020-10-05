package com.example.demo.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
				+ "description, "
				+ "role) "
				+ "VALUES (?,?,?,?,?,?)"
				,user.getName()
				,user.getAccount()
				,user.getPassword()
				,user.getEmail()
				,user.getDescription()
				,user.getRole());
		return rowNumber;
	}

	@Override
	public User findOne(int id) throws DataAccessException {

		Map<String, Object> map = jdbc.queryForMap("SELECT * FROM users WHERE id = ?", id);
		User user = new User();
		user.setId((Integer)map.get("id"));
		user.setName((String)map.get("name"));
		user.setAccount((String)map.get("account"));
		user.setEmail((String)map.get("email"));
		user.setPassword((String)map.get("password"));
		user.setDescription((String)map.get("description"));
		return user;
	}

	@Override
	public List<User> findAll() throws DataAccessException {

		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM users");
		List<User> userList = new ArrayList<>();
		for (Map<String, Object>map:getList) {
			User user = new User();
			user.setId((Integer)map.get("id"));
			user.setName((String)map.get("name"));
			user.setAccount((String)map.get("account"));
			user.setEmail((String)map.get("email"));
			user.setPassword((String)map.get("password"));
			user.setDescription((String)map.get("description"));
			userList.add(user);
		}
		return userList;
	}

	@Override
	public int update(User user) throws DataAccessException {
		return 0;
	}

}
