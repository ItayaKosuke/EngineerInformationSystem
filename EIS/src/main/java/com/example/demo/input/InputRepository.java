package com.example.demo.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class InputRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Boolean add(String speaker, String listener, String date, String method_pulldown
							, String type, String title, String contents) {
		if(jdbcTemplate.update("INSERT INTO interview_data(INTERVIEW_SPEAKER, INTERVIEW_LISTENER,  INTERVIEW_DATE,INTERVIEW_STYLE, INTERVIEW_TYPE, INTERVIEW_TITLE, INTERVIEW_DETAIL)Values(?,?,?,?,?,?,?)",
														speaker, listener, date, method_pulldown, type, title, contents)==1)
		{
			return true;
		}
		return false;
	}

}