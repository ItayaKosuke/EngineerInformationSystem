package com.example.demo.search;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.interview.Interview;

@Repository
public class SearchRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Interview> search(String date_start, String date_end, String speaker) {

		if (date_start.toString() == "" || date_end.toString() == "") {
			String query = "SELECT "
					+ "INTERVIEW_NO, "
					+ "INTERVIEW_DATE, "
					+ "INTERVIEW_SPEAKER, "
					+ "INTERVIEW_TITLE "
					+ "FROM interview_data "
					+ "WHERE INTERVIEW_SPEAKER="
					+ "'" + speaker + "'"
					+ " ORDER BY INTERVIEW_NO DESC ";
			List<Interview> interviewList = send(query);
			return interviewList;
		}
		Date start = java.sql.Date.valueOf(date_start);
		Date end = java.sql.Date.valueOf(date_end);
		if (speaker == "") {
			String query = "SELECT "
					+ "INTERVIEW_NO, "
					+ "INTERVIEW_DATE, "
					+ "INTERVIEW_SPEAKER, "
					+ "INTERVIEW_TITLE "
					+ "FROM interview_data "
					+ "WHERE INTERVIEW_DATE >= "
					+ "'" + start + "'"
					+ "AND INTERVIEW_DATE <= "
					+ "'" + end + "'"
					+ " ORDER BY INTERVIEW_NO DESC";
			List<Interview> interviewList = send(query);
			return interviewList;
		}
		String query = "SELECT "
				+ "INTERVIEW_NO, "
				+ "INTERVIEW_DATE, "
				+ "INTERVIEW_SPEAKER, "
				+ "INTERVIEW_TITLE "
				+ "FROM interview_data "
				+ "WHERE INTERVIEW_SPEAKER="
				+ "'" + speaker + "'"
				+ " AND INTERVIEW_DATE >= "
				+ "'" + start + "'"
				+ " AND INTERVIEW_DATE <= "
				+ "'" + end + "'"
				+ " ORDER BY INTERVIEW_NO DESC";

		List<Interview> interviewList = send(query);
		return interviewList;
	}

	private List<Interview> send(String query) {
		List<Map<String, Object>> interviewResult = jdbcTemplate.queryForList(query);

		List<Interview> interviewList = new ArrayList<Interview>();

		for (Map<String, Object> result : interviewResult) {
			Interview interview = new Interview(
					((Integer) result.get("INTERVIEW_NO")).intValue(), (String) result.get("INTERVIEW_SPEAKER"),
					(String) result.get("INTERVIEW_DATE").toString(), (String) result.get("INTERVIEW_TITLE"));
			interviewList.add(interview);
		}
		return interviewList;
	}

	public List<Interview> search() {

		String query = "SELECT "
				+ "INTERVIEW_NO, "
				+ "INTERVIEW_DATE, "
				+ "INTERVIEW_SPEAKER, "
				+ "INTERVIEW_TITLE "
				+ "FROM interview_data "
				+ "ORDER BY INTERVIEW_NO DESC";
		List<Interview> interviewList = send(query);
		return interviewList;
	}

}
