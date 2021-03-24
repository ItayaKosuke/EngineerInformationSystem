package com.example.demo.interview;

import lombok.Data;

@Data
public class Interview {

	private int interviewNumber;
	private String interviewSpeaker;
	private String interviewListener;
	private String interviewDate;
	private String interviewStyle;
	private String interviewType;
	private String interviewTitle;
	private String interviewDetail;
	private int interviewSpeakerId;
	private int interviewListenerId;

	public Interview(Integer interviewNumber, String interviewSpeaker, String interviewDate, String interviewTitle) {
		this.interviewNumber = interviewNumber;
		this.interviewSpeaker = interviewSpeaker;
		this.interviewDate = interviewDate;
		this.interviewTitle = interviewTitle;
	}

	public Interview(Integer interviewNumber, String interviewSpeaker, String interviewDate, String interviewTitle,
			String interviewDetail) {
		this.interviewNumber = interviewNumber;
		this.interviewSpeaker = interviewSpeaker;
		this.interviewDate = interviewDate;
		this.interviewTitle = interviewTitle;
		this.interviewDetail = interviewDetail;
	}

	public Interview(Integer interviewNumber, String interviewSpeaker, String interviewListener, String interviewDate,
			String interviewStyle, String interviewType, String interviewTitle, String interviewDetail) {
		this.interviewNumber = interviewNumber;
		this.interviewSpeaker = interviewSpeaker;
		this.interviewListener = interviewListener;
		this.interviewDate = interviewDate;
		this.interviewStyle = interviewStyle;
		this.interviewType = interviewType;
		this.interviewTitle = interviewTitle;
		this.interviewDetail = interviewDetail;
	}

	public Interview(Integer interviewNumber, String interviewSpeaker, String interviewListener, String interviewDate,
			String interviewStyle, String interviewType, String interviewTitle, String interviewDetail,
			int interviewSpeakerId, int interviewListenerId) {
		this.interviewNumber = interviewNumber;
		this.interviewSpeaker = interviewSpeaker;
		this.interviewListener = interviewListener;
		this.interviewDate = interviewDate;
		this.interviewStyle = interviewStyle;
		this.interviewType = interviewType;
		this.interviewTitle = interviewTitle;
		this.interviewDetail = interviewDetail;
		this.interviewSpeakerId = interviewSpeakerId;
		this.interviewListenerId = interviewListenerId;
	}
}
