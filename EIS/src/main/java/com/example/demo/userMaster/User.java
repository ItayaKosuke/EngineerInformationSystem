package com.example.demo.userMaster;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userPassword;
	private String userName;
	private String callName;
	private String userInitialPassword;
	private int userNumber;
	private String userOriginalPassword;

	User(int userNumber) {
		this.userNumber = userNumber;
	}

	User(String userId, String userName, String callName) {
		this.userId = userId;
		this.userName = userName;
		this.callName = callName;
	}

	User(int userNumber, String userId, String userPassword, String userName, String userInitialPassword) {
		this.userNumber = userNumber;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userInitialPassword = userInitialPassword;
	}

	User(int userNumber, String userId, String userName, String userOriginalPassword) {
		this.userNumber = userNumber;
		this.userId = userId;
		this.userName = userName;
		this.userOriginalPassword = userOriginalPassword;
	}
}