package com.example.demo.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class InputRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Boolean add(String speaker, String listener, String date, String method_pulldown
							, String type, String title, String contents) {
		String query = "INSERT "
				+ "INTERVIEW_NO, "
				+ "INTERVIEW_SPEAKER="
				+ "'" + speaker + "'"
				+ "INTERVIEW_LISTENER="
				+ "'" + listener + "'"
				+ "INTERVIEW_DATE="
				+ "'" + date + "'"
				+ "INTERVIEW_STYLE="
				+ "'" + method_pulldown + "'"
				+ "INTERVIEW_TYPE="
				+ "'" + type + "'"
				+ "INTERVIEW_TITLE="
				+ "'" + title + "'"
				+ "INTERVIEW_DETAIL="
				+ "'" + contents + "'"
				+ "FROM interview_data ";

		if(jdbcTemplate.update(query)==1)
		{
			return true;
		}
		return false;
	}

}
