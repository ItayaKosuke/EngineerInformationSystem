package com.example.demo.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.interview.Interview;
import com.example.demo.user.User;

@Repository
public class InputRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Boolean add(String speaker, String listener, String date, String method, String type, String title,
			String contents, String speaker_id, String listener_id) {
		if (jdbcTemplate.update(
				"INSERT INTO interview_data(INTERVIEW_SPEAKER, INTERVIEW_LISTENER,  INTERVIEW_DATE,INTERVIEW_STYLE, INTERVIEW_TYPE, INTERVIEW_TITLE, INTERVIEW_DETAIL, INTERVIEW_SPEAKER_ID, INTERVIEW_LISTENER_ID, IS_DELETED)Values(?,?,?,?,?,?,?,?,?,?)",
				speaker, listener, date, method, type, title, contents, speaker_id, listener_id, false) == 1) {
			return true;
		}
		return false;
	}

	public Boolean temporary(String speaker, String listener, String date, String method, String type,
			String title,
			String contents, String speaker_id, String listener_id) {
		if (jdbcTemplate.update(
				"INSERT INTO temporary_data(INTERVIEW_SPEAKER, INTERVIEW_LISTENER,  INTERVIEW_DATE,INTERVIEW_STYLE, INTERVIEW_TYPE, INTERVIEW_TITLE, INTERVIEW_DETAIL, INTERVIEW_SPEAKER_ID, INTERVIEW_LISTENER_ID, IS_DELETED)Values(?,?,?,?,?,?,?,?,?,?)",
				speaker, listener, date, method, type, title, contents, speaker_id, listener_id, false) == 1) {
			return true;
		}
		return false;
	}

	public Boolean delete(int number) {
		if (jdbcTemplate.update("update temporary_data set IS_DELETED = ? WHERE INTERVIEW_NO = ? ", true,
				number) == 1) {
			return true;
		}
		return false;
	}

	public Boolean delete(User user) {
		if (jdbcTemplate.update("update temporary_data set IS_DELETED = ? WHERE INTERVIEW_NO = ? ", true,
				user.getUserNumber()) == 1) {
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
				+ false;
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
		//DBに該当ユーザーがいなかった場合
		if (userList.size() == 0) {
			User user = new User("未登録のユーザーです");
			userList.add(user);
		}
		return userList;
	}

	public List<Interview> search(int number) {

		String query = "SELECT "
				+ "INTERVIEW_NO, "
				+ "INTERVIEW_SPEAKER, "
				+ "INTERVIEW_LISTENER, "
				+ "INTERVIEW_DATE, "
				+ "INTERVIEW_STYLE, "
				+ "INTERVIEW_TYPE, "
				+ "INTERVIEW_TITLE, "
				+ "INTERVIEW_DETAIL, "
				+ "INTERVIEW_SPEAKER_ID, "
				+ "INTERVIEW_LISTENER_ID "
				+ "FROM temporary_data "
				+ "WHERE INTERVIEW_NO= "
				+ number;

		List<Interview> interviewList = send_temporary(query);
		return interviewList;
	}

	private List<Interview> send_temporary(String query) {
		List<Map<String, Object>> interviewResult = jdbcTemplate.queryForList(query);

		List<Interview> interviewList = new ArrayList<Interview>();

		for (Map<String, Object> result : interviewResult) {
			Interview interview = new Interview(
					((Integer) result.get("INTERVIEW_NO")).intValue(), (String) result.get("INTERVIEW_SPEAKER"),
					(String) result.get("INTERVIEW_LISTENER"), (String) result.get("INTERVIEW_DATE").toString(),
					(String) result.get("INTERVIEW_STYLE"), (String) result.get("INTERVIEW_TYPE"),
					(String) result.get("INTERVIEW_TITLE"), (String) result.get("INTERVIEW_DETAIL"),
					((Integer) result.get("INTERVIEW_SPEAKER_ID")).intValue(),
					((Integer) result.get("INTERVIEW_LISTENER_ID")).intValue());
			interviewList.add(interview);
		}
		return interviewList;
	}

}
