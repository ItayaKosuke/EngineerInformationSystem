package com.example.demo.search;

import lombok.Data;

@Data
public class Interview {

	private int		interviewNumber;
	private String	interviewSpeaker;
	private String	interviewListener;
	private String	interviewDate;
	private String	interviewStyle;
	private String	interviewType;
	private String	interviewTitle;
	private String	interviewDetail;

	public Interview(Integer interviewNumber,String interviewSpeaker,String interviewDate,String interviewTitle) {
		this.interviewNumber 	= interviewNumber;
		this.interviewSpeaker 	= interviewSpeaker;
		this.interviewDate 		= interviewDate;
		this.interviewTitle 	= interviewTitle;
	}
}
