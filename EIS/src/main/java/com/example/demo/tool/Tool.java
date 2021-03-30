package com.example.demo.tool;

public class Tool {
	public String filter(String str) {
		String[] remove = new String[] { " ", "　" };
		for (int i = 0; i < remove.length; i++) {
			str = str.replaceAll(remove[i], "");
		}
		return str;
	}
}
