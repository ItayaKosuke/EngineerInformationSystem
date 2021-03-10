package com.example.demo.userMaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserMasterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	List<User> select() {
		String query = "SELECT "
				+ "REGISTER_NO, "
				+ "LOGIN_ID, "
				+ "LOGIN_PASS, "
				+ "USER_NAME, "
				+ "INITIAL_PASS "
				+ "FROM login_data ";
		List<Map<String, Object>> userResult = jdbcTemplate.queryForList(query);

		List<User> userList = new ArrayList<User>();

		for (Map<String, Object> result : userResult) {
			User user = new User(
					((Integer) result.get("REGISTER_NO")).intValue(),
					(String) result.get("LOGIN_ID"), (String) result.get("LOGIN_PASS"),
					(String) result.get("USER_NAME"), (String) result.get("INITIAL_PASS"));
			userList.add(user);
		}
		return userList;
	}

	public Boolean add(User user) {
		if (jdbcTemplate.update("INSERT INTO login_data(LOGIN_ID,LOGIN_PASS,USER_NAME,INITIAL_PASS)Values(?,?,?,?)",
				user.getUserId(), user.getUserPassword(), user.getUserName(), "inipass") == 1) {
			return true;
		}
		return false;
	}

	public Boolean edit() {
		if (true) {
			return true;
		}
		return false;
	}

	public Boolean delete(User user) {
		if (jdbcTemplate.update("DELETE FROM login_data WHERE REGISTER_NO = ?", user.getUserNumber()) == 1) {
			return true;
		}
		return false;
	}
}
