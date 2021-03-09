package com.example.demo.userMaster;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userPassword;
	private String userName;
	private String userInitialPassword;
	private int userNumber;

	User(int userNumber) {
		this.userNumber = userNumber;
	}

	User(String userId, String userPassword, String userName) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
	}

	User(String userId, String userPassword, String userName, String userInitialPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userInitialPassword = userInitialPassword;
	}
}
