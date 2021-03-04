package com.example.demo.search;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SearchRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Interview search(String speaker) {

		String query = "SELECT "
				+ "INTERVIEW_NO, "
				+ "INTERVIEW_DATE, "
				+ "INTERVIEW_SPEAKER, "
				+ "INTERVIEW_TITLE "
				+ "FROM interview_data "
				+ "WHERE INTERVIEW_SPEAKER=?";
		Map<String, Object> interviewResult =jdbcTemplate.queryForMap(query, speaker);

		int		interviewNumber		=(Integer)interviewResult.get("INTERVIEW_NO");
		String	interviewSpeaker	=(String)interviewResult.get("INTERVIEW_SPEAKER");
		String	interviewDate		=(String)interviewResult.get("INTERVIEW_DATE");
		String	interviewTitle		=(String)interviewResult.get("INTERVIEW_TITLE");

		Interview interview = new Interview();
		interview.setInterviewNumber(interviewNumber);
		interview.setInterviewSpeaker(interviewSpeaker);
		interview.setInterviewDate(interviewDate);
		interview.setInterviewTitle(interviewTitle);
		return interview;
	}
}
