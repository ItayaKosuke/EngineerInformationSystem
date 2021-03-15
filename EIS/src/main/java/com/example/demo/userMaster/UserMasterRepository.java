package com.example.demo.userMaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserMasterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	List<User> select() {
		String query = "SELECT "
				+ "REGISTER_NO, "
				+ "LOGIN_ID, "
				+ "ORIGINAL_PASS "
				+ "FROM login_data ";
		List<Map<String, Object>> userResult = jdbcTemplate.queryForList(query);

		List<User> userList = new ArrayList<User>();

		for (Map<String, Object> result : userResult) {
			User user = new User(
					((Integer) result.get("REGISTER_NO")).intValue(),
					(String) result.get("LOGIN_ID"), (String) result.get("ORIGINAL_PASS"));
			userList.add(user);
		}
		return userList;
	}

	public Boolean add(User user) {
		String originalPass = createPassword();
		String initialPass = passwordEncoder.encode(originalPass);
		if (jdbcTemplate.update(
				"INSERT INTO login_data(LOGIN_ID,LOGIN_PASS,ORIGINAL_PASS,INITIAL_PASS,ROLE)Values(?,?,?,?,?)",
				user.getUserId(), initialPass, originalPass, initialPass, "user") == 1) {
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

	public Boolean passReset(User user)
	{
		if(jdbcTemplate.update("update login_data set LOGIN_PASS = INITIAL_PASS WHERE REGISTER_NO = ? ",user.getUserNumber())==1)
		{
			return true;
		}
		return false;

	}

	private String createPassword() {
		String password = "inipass";
		return password;
	}
}
