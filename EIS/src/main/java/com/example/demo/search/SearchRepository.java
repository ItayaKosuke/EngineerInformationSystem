package com.example.demo.search;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.interview.Interview;
import com.example.demo.tool.Tool;

@Repository
public class SearchRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	Tool tool = new Tool();

	private String query_first = "SELECT "
			+ "INTERVIEW_NO, "
			+ "INTERVIEW_DATE, "
			+ "INTERVIEW_SPEAKER, "
			+ "INTERVIEW_TITLE, "
			+ "INTERVIEW_DETAIL "
			+ "FROM interview_data "
			+ "WHERE IS_DELETED = "
			+ false;

	private String query_third = " ORDER BY INTERVIEW_DATE DESC";

	public List<Interview> search(String date_start, String date_end, String speaker, String title) {

		speaker = tool.filter(speaker);
		title = tool.filter(title);

		List<Interview> interviewList = new ArrayList<Interview>();

		if (speaker.toString() != "") {
			if (searchName(speaker)) {
				if (title.toString() != "") {
					if (date_start.toString() != "") {
						if (date_end.toString() != "") {
							System.out.println("名前完全：タイトル：日付前：日付後");
							Date start = java.sql.Date.valueOf(date_start);
							Date end = java.sql.Date.valueOf(date_end);
							String query_second = " AND INTERVIEW_SPEAKER = "
									+ "'" + speaker + "'"
									+ " AND INTERVIEW_TITLE LIKE "
									+ "'%" + title + "%'"
									+ " AND INTERVIEW_DATE >= "
									+ "'" + start + "'"
									+ " AND INTERVIEW_DATE <= "
									+ "'" + end + "'";
							interviewList = send(query_first + query_second + query_third);
						} else {
							System.out.println("名前完全：タイトル：日付前");
							Date start = java.sql.Date.valueOf(date_start);
							String query_second = " AND INTERVIEW_SPEAKER = "
									+ "'" + speaker + "'"
									+ " AND INTERVIEW_TITLE LIKE "
									+ "'%" + title + "%'"
									+ " AND INTERVIEW_DATE >= "
									+ "'" + start + "'";
							interviewList = send(query_first + query_second + query_third);
						}
					} else {
						if (date_end.toString() != "") {
							System.out.println("名前完全：タイトル：日付後");
							Date end = java.sql.Date.valueOf(date_end);
							String query_second = " AND INTERVIEW_SPEAKER = "
									+ "'" + speaker + "'"
									+ " AND INTERVIEW_TITLE LIKE "
									+ "'%" + title + "%'"
									+ " AND INTERVIEW_DATE <= "
									+ "'" + end + "'";
							interviewList = send(query_first + query_second + query_third);
						} else {
							System.out.println("名前完全：タイトル");
							String query_second = " AND INTERVIEW_SPEAKER = "
									+ "'" + speaker + "'"
									+ " AND INTERVIEW_TITLE LIKE "
									+ "'%" + title + "%'";
							interviewList = send(query_first + query_second + query_third);
						}
					}
				} else {
					if (date_start.toString() != "") {
						if (date_end.toString() != "") {
							System.out.println("名前完全：日付前：日付後");
							Date start = java.sql.Date.valueOf(date_start);
							Date end = java.sql.Date.valueOf(date_end);
							String query_second = " AND INTERVIEW_SPEAKER = "
									+ "'" + speaker + "'"
									+ " AND INTERVIEW_DATE >= "
									+ "'" + start + "'"
									+ " AND INTERVIEW_DATE <= "
									+ "'" + end + "'";
							interviewList = send(query_first + query_second + query_third);
						} else {
							System.out.println("名前完全：日付前");
							Date start = java.sql.Date.valueOf(date_start);
							String query_second = " AND INTERVIEW_SPEAKER = "
									+ "'" + speaker + "'"
									+ " AND INTERVIEW_DATE >= "
									+ "'" + start + "'";
							interviewList = send(query_first + query_second + query_third);
						}
					} else {
						if (date_end.toString() != "") {
							System.out.println("名前完全：日付後");
							Date end = java.sql.Date.valueOf(date_end);
							String query_second = " AND INTERVIEW_SPEAKER = "
									+ "'" + speaker + "'"
									+ " AND INTERVIEW_TITLE LIKE "
									+ "'" + end + "'";
							interviewList = send(query_first + query_second + query_third);
						} else {
							System.out.println("名前完全");
							String query_second = " AND INTERVIEW_SPEAKER = "
									+ "'" + speaker + "'";
							interviewList = send(query_first + query_second + query_third);
						}
					}
				}
			} else {
				//名前部分
				for (int i = 0; i < speaker.length();) {
					if (title.toString() != "") {
						if (date_start.toString() != "") {
							if (date_end.toString() != "") {
								System.out.println("名前部分：タイトル：日付前：日付後");
								Date start = java.sql.Date.valueOf(date_start);
								Date end = java.sql.Date.valueOf(date_end);
								String query_second = " AND INTERVIEW_SPEAKER LIKE "
										+ "'%" + speaker + "%'"
										+ " AND INTERVIEW_TITLE LIKE "
										+ "'%" + title + "%'"
										+ " AND INTERVIEW_DATE >= "
										+ "'" + start + "'"
										+ " AND INTERVIEW_DATE <= "
										+ "'" + end + "'";
								interviewList = send(query_first + query_second + query_third);
							} else {
								System.out.println("名前部分：タイトル：日付前");
								Date start = java.sql.Date.valueOf(date_start);
								String query_second = " AND INTERVIEW_SPEAKER LIKE "
										+ "'%" + speaker + "%'"
										+ " AND INTERVIEW_TITLE LIKE "
										+ "'%" + title + "%'"
										+ " AND INTERVIEW_DATE >= "
										+ "'" + start + "'";
								interviewList = send(query_first + query_second + query_third);
							}
						} else {
							if (date_end.toString() != "") {
								System.out.println("名前部分：タイトル：日付後");
								Date end = java.sql.Date.valueOf(date_end);
								String query_second = " AND INTERVIEW_SPEAKER LIKE "
										+ "'%" + speaker + "%'"
										+ " AND INTERVIEW_TITLE LIKE "
										+ "'%" + title + "%'"
										+ " AND INTERVIEW_DATE <= "
										+ "'" + end + "'";
								interviewList = send(query_first + query_second + query_third);
							} else {
								System.out.println("名前部分：タイトル");
								String query_second = " AND INTERVIEW_SPEAKER LIKE "
										+ "'%" + speaker + "%'"
										+ " AND INTERVIEW_TITLE LIKE "
										+ "'%" + title + "%'";
								interviewList = send(query_first + query_second + query_third);
							}
						}
					} else {
						if (date_start.toString() != "") {
							if (date_end.toString() != "") {
								System.out.println("名前部分：日付前：日付後");
								Date start = java.sql.Date.valueOf(date_start);
								Date end = java.sql.Date.valueOf(date_end);
								String query_second = " AND INTERVIEW_SPEAKER LIKE "
										+ "'%" + speaker + "%'"
										+ " AND INTERVIEW_DATE >= "
										+ "'" + start + "'"
										+ " AND INTERVIEW_DATE <= "
										+ "'" + end + "'";
								interviewList = send(query_first + query_second + query_third);
							} else {
								System.out.println("名前部分：日付前");
								Date start = java.sql.Date.valueOf(date_start);
								String query_second = " AND INTERVIEW_SPEAKER LIKE "
										+ "'%" + speaker + "%'"
										+ " AND INTERVIEW_DATE >= "
										+ "'" + start + "'";
								interviewList = send(query_first + query_second + query_third);
							}
						} else {
							if (date_end.toString() != "") {
								System.out.println("名前部分：日付後");
								Date end = java.sql.Date.valueOf(date_end);
								String query_second = " AND INTERVIEW_SPEAKER LIKE "
										+ "'%" + speaker + "%'"
										+ " AND INTERVIEW_DATE <= "
										+ "'" + end + "'";
								interviewList = send(query_first + query_second + query_third);

							} else {
								System.out.println("名前部分");
								String query_second = " AND INTERVIEW_SPEAKER LIKE "
										+ "'%" + speaker + "%'";
								interviewList = send(query_first + query_second + query_third);
							}
						}
					}
					if (interviewList.size() >= 1) {
						break;
					}
					speaker = speaker.substring(0, speaker.length() - 1);
				}
			}
		} else {
			if (title.toString() != "") {
				if (date_start.toString() != "") {
					if (date_end.toString() != "") {
						System.out.println("タイトル：日付前：日付後");
						Date start = java.sql.Date.valueOf(date_start);
						Date end = java.sql.Date.valueOf(date_end);
						String query_second = " AND INTERVIEW_TITLE LIKE "
								+ "'%" + title + "%'"
								+ " AND INTERVIEW_DATE >= "
								+ "'" + start + "'"
								+ " AND INTERVIEW_DATE <= "
								+ "'" + end + "'";
						interviewList = send(query_first + query_second + query_third);

					} else {
						System.out.println("タイトル：日付前");
						Date start = java.sql.Date.valueOf(date_start);
						String query_second = " AND INTERVIEW_TITLE LIKE "
								+ "'%" + title + "%'"
								+ " AND INTERVIEW_DATE >= "
								+ "'" + start + "'";
						interviewList = send(query_first + query_second + query_third);

					}
				} else {
					if (date_end.toString() != "") {
						System.out.println("タイトル：日付後");
						Date end = java.sql.Date.valueOf(date_end);
						String query_second = " AND INTERVIEW_TITLE LIKE "
								+ "'%" + title + "%'"
								+ " AND INTERVIEW_DATE <= "
								+ "'" + end + "'";
						interviewList = send(query_first + query_second + query_third);

					} else {
						System.out.println("タイトル");
						String query_second = " AND INTERVIEW_TITLE LIKE "
								+ "'%" + title + "%'";
						interviewList = send(query_first + query_second + query_third);

					}
				}
			} else {
				if (date_start.toString() != "") {
					if (date_end.toString() != "") {
						System.out.println("日付前：日付後");
						Date start = java.sql.Date.valueOf(date_start);
						Date end = java.sql.Date.valueOf(date_end);
						String query_second = " AND INTERVIEW_DATE >= "
								+ "'" + start + "'"
								+ " AND INTERVIEW_DATE <= "
								+ "'" + end + "'";
						interviewList = send(query_first + query_second + query_third);

					} else {
						System.out.println("日付前");
						Date start = java.sql.Date.valueOf(date_start);
						String query_second = " AND INTERVIEW_DATE >= "
								+ "'" + start + "'";
						interviewList = send(query_first + query_second + query_third);

					}
				} else {
					if (date_end.toString() != "") {
						System.out.println("日付後");
						Date end = java.sql.Date.valueOf(date_end);
						String query_second = " AND INTERVIEW_DATE <= "
								+ "'" + end + "'";
						interviewList = send(query_first + query_second + query_third);

					} else {
						String query_second = "";
						interviewList = send(query_first + query_second + query_third);
					}
				}
			}
		}
		return interviewList;
	}

	private List<Interview> send(String query) {
		List<Map<String, Object>> interviewResult = jdbcTemplate.queryForList(query);

		List<Interview> interviewList = new ArrayList<Interview>();

		for (Map<String, Object> result : interviewResult) {
			Interview interview = new Interview(
					((Integer) result.get("INTERVIEW_NO")).intValue(), (String) result.get("INTERVIEW_SPEAKER"),
					(String) result.get("INTERVIEW_DATE").toString(), (String) result.get("INTERVIEW_TITLE"),
					(String) result.get("INTERVIEW_DETAIL"));
			interviewList.add(interview);
		}
		return interviewList;
	}

	public List<Interview> search() {

		String query_second = "";
		List<Interview> interviewList = send(query_first + query_second + query_third);
		return interviewList;
	}

	private boolean searchName(String speaker) {
		String hit_query = "SELECT "
				+ "COUNT(USER_NAME) "
				+ "FROM login_data "
				+ "WHERE "
				+ "USER_NAME = "
				+ "'" + speaker + "'"
				+ " AND "
				+ "IS_DELETED = "
				+ false;
		int hitNumber = jdbcTemplate.queryForObject(hit_query, Integer.class);
		if (hitNumber == 1) {
			return true;
		}
		return false;
	}

	//全ての面談データの面談番号を配列に格納
	public int[] searchNumber(List<Interview> interview) {
		int[] interviewNumber = new int[interview.size()];
		for (int i = 0; i < interview.size(); i++) {
			interviewNumber[i] = interview.get(i).getInterviewNumber();
		}
		return interviewNumber;
	}
}