package com.example.demo.domain.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.Message;
import com.example.demo.domain.repository.MessageDao;


@Repository
public class MessageDaoJdbcImpl implements MessageDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int insert(Message msg) throws DataAccessException {
		int rowNumber = jdbc.update("INSERT INTO messages ( user_id, text ) VALUES (?,?)"
				,msg.getUser_id()
				,msg.getText());
		return rowNumber;
	}

	@Override
	public Message findOne(int id) throws DataAccessException {

//		Map<String, Object> map = jdbc.queryForMap("SELECT * FROM users WHERE id = ?", id);
//		User user = new User();
//		user.setId((Integer)map.get("id"));
//		user.setName((String)map.get("name"));
//		user.setAccount((String)map.get("account"));
//		user.setEmail((String)map.get("email"));
//		user.setPassword((String)map.get("password"));
//		user.setDescription((String)map.get("description"));
		return null;
	}

	@Override
	public List<Message> findAll() throws DataAccessException {

//		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM users");
//		List<User> userList = new ArrayList<>();
//		for (Map<String, Object>map:getList) {
//			User user = new User();
//			user.setId((Integer)map.get("id"));
//			user.setName((String)map.get("name"));
//			user.setAccount((String)map.get("account"));
//			user.setEmail((String)map.get("email"));
//			user.setPassword((String)map.get("password"));
//			user.setDescription((String)map.get("description"));
//			userList.add(user);
//		}
		return null;
	}

//	@Override
//	public int update(Message msg) throws DataAccessException {
//		return 0;
//	}


}
