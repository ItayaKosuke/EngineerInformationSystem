package com.example.demo.edit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.interview.Interview;

@Repository
public class EditRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
				+ "FROM interview_data "
				+ "WHERE INTERVIEW_NO= "
				+ number
				+ " AND IS_DELETED= "
				+ false;

		List<Interview> interviewList = send(query);
		return interviewList;
	}

	private List<Interview> send(String query) {
		List<Map<String, Object>> interviewResult = jdbcTemplate.queryForList(query);

		List<Interview> interviewList = new ArrayList<Interview>();

		for (Map<String, Object> result : interviewResult) {
			Interview interview = new Interview(
					((Integer) result.get("INTERVIEW_NO")).intValue(), (String) result.get("INTERVIEW_SPEAKER"),
					(String) result.get("INTERVIEW_LISTENER"),
					(String) result.get("INTERVIEW_DATE").toString(),
					(String) result.get("INTERVIEW_STYLE"), (String) result.get("INTERVIEW_TYPE"),
					(String) result.get("INTERVIEW_TITLE"), (String) result.get("INTERVIEW_DETAIL"),
					((Integer) result.get("INTERVIEW_SPEAKER_ID")).intValue(),
					((Integer) result.get("INTERVIEW_LISTENER_ID")).intValue());
			interviewList.add(interview);
		}
		return interviewList;
	}
}
