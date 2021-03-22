package com.example.demo.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.user.User;

@Repository
public class InputRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Boolean add(String speaker, String listener, String date, String method_pulldown, String type, String title,
			String contents, String author) {
		if (jdbcTemplate.update(
				"INSERT INTO interview_data(INTERVIEW_SPEAKER, INTERVIEW_LISTENER,  INTERVIEW_DATE,INTERVIEW_STYLE, INTERVIEW_TYPE, INTERVIEW_TITLE, INTERVIEW_DETAIL, INTERVIEW_AUTHOR, IS_DELETED)Values(?,?,?,?,?,?,?,?,?)",
				speaker, listener, date, method_pulldown, type, title, contents, author, false) == 1) {
			return true;
		}
		return false;
	}

	public List<User> search(String id) {

		String query = "SELECT "
				+ "USER_NAME "
				+ "FROM login_data "
				+ " WHERE "
				+ "LOGIN_ID = "
				+ "'" + id + "'"
				+ " AND "
				+ "IS_DELETED = "
				+ false
				+ " ORDER BY USER_NAME DESC";
		List<User> userList = send(query);
		return userList;
	}

	private List<User> send(String query) {
		List<Map<String, Object>> userResult = jdbcTemplate.queryForList(query);

		List<User> userList = new ArrayList<User>();

		for (Map<String, Object> result : userResult) {
			User user = new User((String) result.get("USER_NAME"));
			userList.add(user);
		}
		return userList;
	}
}
