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

		if (speaker.toString() != "" && date_start.toString() == "" && date_end.toString() == "") {
			String query = "SELECT "
					+ "INTERVIEW_NO, "
					+ "INTERVIEW_DATE, "
					+ "INTERVIEW_SPEAKER, "
					+ "INTERVIEW_TITLE "
					+ "FROM interview_data "
					+ "WHERE INTERVIEW_SPEAKER="
					+ "'" + speaker + "'"
					+ " AND "
					+ "IS_DELETED = "
					+ false
					+ " ORDER BY INTERVIEW_NO DESC";
			System.out.println("名前");
			List<Interview> interviewList = send(query);
			return interviewList;
		}
		if (speaker.toString() == "" && date_start.toString() == "" && date_end.toString() != "") {
			Date end = java.sql.Date.valueOf(date_end);
			String query = "SELECT "
					+ "INTERVIEW_NO, "
					+ "INTERVIEW_DATE, "
					+ "INTERVIEW_SPEAKER, "
					+ "INTERVIEW_TITLE "
					+ "FROM interview_data "
					+ "WHERE INTERVIEW_DATE <= "
					+ "'" + end + "'"
					+ " AND "
					+ "IS_DELETED = "
					+ false
					+ " ORDER BY INTERVIEW_NO DESC";
			System.out.println("日付後");
			List<Interview> interviewList = send(query);
			return interviewList;
		}
		if (speaker.toString() == "" && date_start.toString() != "" && date_end.toString() == "") {
			Date start = java.sql.Date.valueOf(date_start);
			String query = "SELECT "
					+ "INTERVIEW_NO, "
					+ "INTERVIEW_DATE, "
					+ "INTERVIEW_SPEAKER, "
					+ "INTERVIEW_TITLE "
					+ "FROM interview_data "
					+ "WHERE INTERVIEW_DATE >= "
					+ "'" + start + "'"
					+ " AND "
					+ "IS_DELETED = "
					+ false
					+ " ORDER BY INTERVIEW_NO DESC";
			System.out.println("日付前");
			List<Interview> interviewList = send(query);
			return interviewList;
		}
		if (speaker.toString() == "" && date_start.toString() != "" && date_end.toString() != "") {
			Date start = java.sql.Date.valueOf(date_start);
			Date end = java.sql.Date.valueOf(date_end);
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
					+ " AND "
					+ "IS_DELETED = "
					+ false
					+ " ORDER BY INTERVIEW_NO DESC";
			System.out.println("日付前：日付後");
			List<Interview> interviewList = send(query);
			return interviewList;
		}
		if (speaker.toString() != "" && date_start.toString() != "" && date_end.toString() == "") {
			Date start = java.sql.Date.valueOf(date_start);
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
					+ " AND "
					+ "IS_DELETED = "
					+ false
					+ " ORDER BY INTERVIEW_NO DESC";

			System.out.println("名前：日付前");

			List<Interview> interviewList = send(query);
			return interviewList;
		}
		if (speaker.toString() != "" && date_start.toString() == "" && date_end.toString() != "") {
			Date end = java.sql.Date.valueOf(date_end);
			String query = "SELECT "
					+ "INTERVIEW_NO, "
					+ "INTERVIEW_DATE, "
					+ "INTERVIEW_SPEAKER, "
					+ "INTERVIEW_TITLE "
					+ "FROM interview_data "
					+ "WHERE INTERVIEW_SPEAKER="
					+ "'" + speaker + "'"
					+ " AND INTERVIEW_DATE <= "
					+ "'" + end + "'"
					+ " AND "
					+ "IS_DELETED = "
					+ false
					+ " ORDER BY INTERVIEW_NO DESC";
			System.out.println("名前：日付後");

			List<Interview> interviewList = send(query);
			return interviewList;
		}
		if (speaker.toString() != "" && date_start.toString() != "" && date_end.toString() != "") {
			Date start = java.sql.Date.valueOf(date_start);
			Date end = java.sql.Date.valueOf(date_end);
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
					+ " AND "
					+ "IS_DELETED = "
					+ false
					+ " ORDER BY INTERVIEW_NO DESC";
			System.out.println("名前：日付前：日付後");

			List<Interview> interviewList = send(query);
			return interviewList;
		}
		System.out.println("検索に失敗しました");
		List<Interview> interviewList = new ArrayList<Interview>();
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
				+ " WHERE "
				+ "IS_DELETED = "
				+ false
				+ " ORDER BY INTERVIEW_NO DESC";
		List<Interview> interviewList = send(query);
		return interviewList;
	}

}
