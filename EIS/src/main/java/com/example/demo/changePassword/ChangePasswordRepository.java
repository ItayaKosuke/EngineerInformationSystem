package com.example.demo.changePassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class ChangePasswordRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	PasswordEncoder passwordEncoder;

	public Boolean update(String id, String new_pass) {
		String password = passwordEncoder.encode(new_pass);
		if (jdbcTemplate.update("update login_data set LOGIN_PASS = ? WHERE LOGIN_ID = ? AND IS_DELETED = ?", password,
				id,
				false) == 1) {
			return true;
		}
		return false;
	}

	public String selectPass(String id) {
		String query = "SELECT "
				+ "LOGIN_PASS "
				+ "FROM login_data "
				+ "WHERE "
				+ "LOGIN_ID = "
				+ "'" + id + "'"
				+ " AND "
				+ "IS_DELETED = "
				+ false;
		String userPass = jdbcTemplate.queryForObject(query, String.class);
		return userPass;
	}
}
