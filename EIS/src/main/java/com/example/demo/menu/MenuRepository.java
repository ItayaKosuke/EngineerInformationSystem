package com.example.demo.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.user.User;

@Repository
public class MenuRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> search(String id) {

		String query = "SELECT "
				+ "USER_NAME "
				+ "FROM login_data "
				+ " WHERE "
				+ "LOGIN_ID = "
				+ "'" + id + "'"
				+ " AND "
				+ "IS_DELETED = "
				+ false;
		List<User> userList = send(query);
		return userList;
	}

	private List<User> send(String query) {
		List<Map<String, Object>> userResult = jdbcTemplate.queryForList(query);

		List<User> userList = new ArrayList<User>();

		for (Map<String, Object> result : userResult) {
			User user = new User((String) result.get("ROLE"));
			userList.add(user);
		}
		//DBに該当ユーザーがいなかった場合
		if (userList.size() == 0) {
			User user = new User("NOT_ROLE");
			userList.add(user);
		}
		return userList;
	}

}
