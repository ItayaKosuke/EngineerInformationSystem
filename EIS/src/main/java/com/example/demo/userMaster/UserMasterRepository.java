package com.example.demo.userMaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.user.User;

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
				+ "USER_NAME, "
				+ "ORIGINAL_PASS "
				+ "FROM login_data "
				+ "WHERE IS_DELETED = "
				+ "FALSE";
		List<Map<String, Object>> userResult = jdbcTemplate.queryForList(query);

		List<User> userList = new ArrayList<User>();

		for (Map<String, Object> result : userResult) {
			User user = new User(
					((Integer) result.get("REGISTER_NO")).intValue(),
					(String) result.get("LOGIN_ID"), (String) result.get("USER_NAME"),
					(String) result.get("ORIGINAL_PASS"));
			userList.add(user);
		}
		return userList;
	}

	public Boolean add(User user) {
		//登録したいログインIDで使用可能（false）なものがないか調べる
		String hit_query = "SELECT "
				+ "COUNT(LOGIN_ID) "
				+ "FROM login_data "
				+ "WHERE "
				+ "LOGIN_ID = "
				+ "'" + user.getUserId() + "'"
				+ " AND "
				+ "IS_DELETED = "
				+ false;
		int hitNumber = jdbcTemplate.queryForObject(hit_query, Integer.class);
		if (hitNumber == 0) {
			String revision_query = "SELECT "
					+ "MAX(REVISION) "
					+ "FROM login_data "
					+ "WHERE "
					+ "LOGIN_ID = "
					+ "'" + user.getUserId() + "'"
					+ " AND "
					+ "IS_DELETED = "
					+ true;
			int revision;
			String rev_count = jdbcTemplate.queryForObject(revision_query, String.class);
			//Revisionがなければnullが返りparseできないため条件分岐
			if (rev_count == null) {
				revision = 1;
			} else {
				revision = Integer.parseInt(rev_count) + 1;
			}
			String originalPass = createPassword();
			String initialPass = passwordEncoder.encode(originalPass);
			if (jdbcTemplate.update(
					"INSERT INTO login_data(LOGIN_ID,USER_NAME,CALL_NAME,LOGIN_PASS,ORIGINAL_PASS,INITIAL_PASS,ROLE,IS_DELETED,REVISION)Values(?,?,?,?,?,?,?,?,?)",
					user.getUserId(), user.getUserName(), user.getCallName(), initialPass, originalPass, initialPass,
					"user", false, revision) == 1) {
				return true;
			}
			return false;
		}
		System.out.println("エラーメッセージ：このアカウントは既に存在します");
		return false;
	}

	public Boolean delete(User user) {
		if (jdbcTemplate.update("update login_data set IS_DELETED = ? WHERE REGISTER_NO = ? ", true,
				user.getUserNumber()) == 1) {
			return true;
		}
		return false;
	}

	public Boolean passReset(User user) {
		if (jdbcTemplate.update(
				"update login_data set LOGIN_PASS = INITIAL_PASS WHERE REGISTER_NO = ? AND IS_DELETED = ?",
				user.getUserNumber(), false) == 1) {
			return true;
		}
		return false;

	}

	private String createPassword() {
		String pwd = RandomStringUtils.randomAlphanumeric(8);
		return pwd;
	}
}
