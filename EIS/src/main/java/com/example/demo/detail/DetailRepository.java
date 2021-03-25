package com.example.demo.detail;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.interview.Interview;

@Repository
public class DetailRepository {

	private int[] interviewNumber;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Interview> search(int number) {

		String query = "SELECT "
				+ "INTERVIEW_NO, "
				+ "INTERVIEW_SPEAKER, "
				+ "INTERVIEW_LISTENER, "
				+ "INTERVIEW_DATE, "
				+ "INTERVIEW_STYLE, "
				+ "INTERVIEW_TYPE, "
				+ "INTERVIEW_TITLE, "
				+ "INTERVIEW_DETAIL "
				+ "FROM interview_data "
				+ "WHERE INTERVIEW_NO="
				+ number;

		List<Interview> interviewList = send(query);
		return interviewList;
	}

	private List<Interview> send(String query) {
		List<Map<String, Object>> interviewResult = jdbcTemplate.queryForList(query);

		List<Interview> interviewList = new ArrayList<Interview>();

		for (Map<String, Object> result : interviewResult) {
			Interview interview = new Interview(
					((Integer) result.get("INTERVIEW_NO")).intValue(), (String) result.get("INTERVIEW_SPEAKER"),
					(String) result.get("INTERVIEW_LISTENER"), (String) result.get("INTERVIEW_DATE").toString(),
					(String) result.get("INTERVIEW_STYLE"), (String) result.get("INTERVIEW_TYPE"),
					(String) result.get("INTERVIEW_TITLE"), (String) result.get("INTERVIEW_DETAIL"));
			interviewList.add(interview);
		}
		return interviewList;
	}

	private List<Interview> sendNumber(String query) {
		List<Map<String, Object>> interviewResult = jdbcTemplate.queryForList(query);

		List<Interview> interviewList = new ArrayList<Interview>();

		for (Map<String, Object> result : interviewResult) {
			Interview interview = new Interview(
					((Integer) result.get("INTERVIEW_NO")).intValue());
			interviewList.add(interview);
		}
		return interviewList;
	}

	public Boolean update(int number, String speaker, String style, String listener, String date, String type,
			String title, String contents) {
		if (jdbcTemplate.update(
				"update interview_data set INTERVIEW_SPEAKER = ?,INTERVIEW_STYLE = ? ,INTERVIEW_LISTENER = ?,INTERVIEW_DATE = ?,INTERVIEW_TYPE = ?,INTERVIEW_TITLE = ?,INTERVIEW_DETAIL = ? WHERE INTERVIEW_NO = ? ",
				speaker,
				style, listener, date, type, title, contents, number) == 1) {
			return true;
		}
		return false;
	}

	public List<Interview> reference(String date_start, String date_end, String speaker, String title) {

		if (title.toString() != "") {
			if (speaker.toString() == "" && date_start.toString() == "" && date_end.toString() == "") {
				String query = "SELECT "
						+ "INTERVIEW_NO "
						+ "FROM interview_data "
						+ "WHERE INTERVIEW_TITLE "
						+ "LIKE "
						+ "'%" + title + "%'"
						+ " AND IS_DELETED = "
						+ false
						+ " ORDER BY INTERVIEW_DATE DESC";
				System.out.println("タイトル");
				List<Interview> interviewList = sendNumber(query);
				return interviewList;
			} else if (speaker.toString() != "") {
				if (date_start.toString() == "" && date_end.toString() == "") {
					String query = "SELECT "
							+ "INTERVIEW_NO "
							+ "FROM interview_data "
							+ "WHERE INTERVIEW_TITLE "
							+ "LIKE "
							+ "'%" + title + "%'"
							+ " AND "
							+ "INTERVIEW_SPEAKER="
							+ "'" + speaker + "'"
							+ " AND "
							+ "IS_DELETED = "
							+ false
							+ " ORDER BY INTERVIEW_DATE DESC";
					System.out.println("タイトル:名前");
					List<Interview> interviewList = sendNumber(query);
					return interviewList;
				}
				if (date_start.toString() != "" && date_end.toString() == "") {
					Date start = java.sql.Date.valueOf(date_start);
					String query = "SELECT "
							+ "INTERVIEW_NO "
							+ "FROM interview_data "
							+ "WHERE INTERVIEW_TITLE "
							+ "LIKE "
							+ "'%" + title + "%'"
							+ " AND INTERVIEW_SPEAKER="
							+ "'" + speaker + "'"
							+ " AND INTERVIEW_DATE >= "
							+ "'" + start + "'"
							+ " AND "
							+ "IS_DELETED = "
							+ false
							+ " ORDER BY INTERVIEW_DATE DESC";

					System.out.println("タイトル:名前:日付前");

					List<Interview> interviewList = sendNumber(query);
					return interviewList;
				}
				if (date_start.toString() == "" && date_end.toString() != "") {
					Date end = java.sql.Date.valueOf(date_end);
					String query = "SELECT "
							+ "INTERVIEW_NO "
							+ "FROM interview_data "
							+ "WHERE INTERVIEW_TITLE "
							+ "LIKE "
							+ "'%" + title + "%'"
							+ " AND INTERVIEW_SPEAKER="
							+ "'" + speaker + "'"
							+ " AND INTERVIEW_DATE <= "
							+ "'" + end + "'"
							+ " AND "
							+ "IS_DELETED = "
							+ false
							+ " ORDER BY INTERVIEW_DATE DESC";
					System.out.println("タイトル:名前:日付後");

					List<Interview> interviewList = sendNumber(query);
					return interviewList;
				}
				if (date_start.toString() != "" && date_end.toString() != "") {
					Date start = java.sql.Date.valueOf(date_start);
					Date end = java.sql.Date.valueOf(date_end);
					String query = "SELECT "
							+ "INTERVIEW_NO "
							+ "FROM interview_data "
							+ "WHERE INTERVIEW_TITLE "
							+ "LIKE "
							+ "'%" + title + "%'"
							+ " AND INTERVIEW_SPEAKER="
							+ "'" + speaker + "'"
							+ " AND INTERVIEW_DATE >= "
							+ "'" + start + "'"
							+ " AND INTERVIEW_DATE <= "
							+ "'" + end + "'"
							+ " AND "
							+ "IS_DELETED = "
							+ false
							+ " ORDER BY INTERVIEW_DATE DESC";
					System.out.println("タイトル:名前:日付前:日付後");

					List<Interview> interviewList = sendNumber(query);
					return interviewList;
				}
			} else if (date_start.toString() != "") {
				if (date_end.toString() == "") {
					Date start = java.sql.Date.valueOf(date_start);
					String query = "SELECT "
							+ "INTERVIEW_NO "
							+ "FROM interview_data "
							+ "WHERE INTERVIEW_TITLE "
							+ "LIKE "
							+ "'%" + title + "%'"
							+ " AND INTERVIEW_DATE >= "
							+ "'" + start + "'"
							+ " AND "
							+ "IS_DELETED = "
							+ false
							+ " ORDER BY INTERVIEW_DATE DESC";
					System.out.println("タイトル:日付前");
					List<Interview> interviewList = sendNumber(query);
					return interviewList;
				}
				if (date_end.toString() != "") {
					Date start = java.sql.Date.valueOf(date_start);
					Date end = java.sql.Date.valueOf(date_end);
					String query = "SELECT "
							+ "INTERVIEW_NO "
							+ "FROM interview_data "
							+ "WHERE INTERVIEW_TITLE "
							+ "LIKE "
							+ "'%" + title + "%'"
							+ " AND INTERVIEW_DATE >= "
							+ "'" + start + "'"
							+ " AND INTERVIEW_DATE <= "
							+ "'" + end + "'"
							+ " AND "
							+ "IS_DELETED = "
							+ false
							+ " ORDER BY INTERVIEW_DATE DESC";
					System.out.println("タイトル:日付前:日付後");
					List<Interview> interviewList = sendNumber(query);
					return interviewList;
				}
			} else {
				if (date_end.toString() != "") {
					Date end = java.sql.Date.valueOf(date_end);
					String query = "SELECT "
							+ "INTERVIEW_NO "
							+ "FROM interview_data "
							+ "WHERE INTERVIEW_TITLE "
							+ "LIKE "
							+ "'%" + title + "%'"
							+ " AND INTERVIEW_DATE <= "
							+ "'" + end + "'"
							+ " AND "
							+ "IS_DELETED = "
							+ false
							+ " ORDER BY INTERVIEW_DATE DESC";
					System.out.println("タイトル:日付後");
					List<Interview> interviewList = sendNumber(query);
					return interviewList;
				}
			}
		} else if (speaker.toString() != "") {
			if (date_start.toString() == "" && date_end.toString() == "") {
				String query = "SELECT "
						+ "INTERVIEW_NO "
						+ "FROM interview_data "
						+ "WHERE INTERVIEW_SPEAKER="
						+ "'" + speaker + "'"
						+ " AND "
						+ "IS_DELETED = "
						+ false
						+ " ORDER BY INTERVIEW_DATE DESC";
				System.out.println("名前");
				List<Interview> interviewList = sendNumber(query);
				return interviewList;
			}
			if (date_start.toString() != "" && date_end.toString() == "") {
				Date start = java.sql.Date.valueOf(date_start);
				String query = "SELECT "
						+ "INTERVIEW_NO "
						+ "FROM interview_data "
						+ "WHERE INTERVIEW_SPEAKER="
						+ "'" + speaker + "'"
						+ " AND INTERVIEW_DATE >= "
						+ "'" + start + "'"
						+ " AND "
						+ "IS_DELETED = "
						+ false
						+ " ORDER BY INTERVIEW_DATE DESC";

				System.out.println("名前:日付前");

				List<Interview> interviewList = sendNumber(query);
				return interviewList;
			}
			if (date_start.toString() == "" && date_end.toString() != "") {
				Date end = java.sql.Date.valueOf(date_end);
				String query = "SELECT "
						+ "INTERVIEW_NO "
						+ "FROM interview_data "
						+ "WHERE INTERVIEW_SPEAKER="
						+ "'" + speaker + "'"
						+ " AND INTERVIEW_DATE <= "
						+ "'" + end + "'"
						+ " AND "
						+ "IS_DELETED = "
						+ false
						+ " ORDER BY INTERVIEW_DATE DESC";
				System.out.println("名前:日付後");

				List<Interview> interviewList = sendNumber(query);
				return interviewList;
			}
			if (date_start.toString() != "" && date_end.toString() != "") {
				Date start = java.sql.Date.valueOf(date_start);
				Date end = java.sql.Date.valueOf(date_end);
				String query = "SELECT "
						+ "INTERVIEW_NO "
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
						+ " ORDER BY INTERVIEW_DATE DESC";
				System.out.println("名前:日付前:日付後");

				List<Interview> interviewList = sendNumber(query);
				return interviewList;
			}
		} else if (date_start.toString() != "") {
			if (date_end.toString() == "") {
				Date start = java.sql.Date.valueOf(date_start);
				String query = "SELECT "
						+ "INTERVIEW_NO"
						+ "FROM interview_data "
						+ "WHERE INTERVIEW_DATE >= "
						+ "'" + start + "'"
						+ " AND "
						+ "IS_DELETED = "
						+ false
						+ " ORDER BY INTERVIEW_DATE DESC";
				System.out.println("日付前");
				List<Interview> interviewList = sendNumber(query);
				return interviewList;
			}
			if (date_end.toString() != "") {
				Date start = java.sql.Date.valueOf(date_start);
				Date end = java.sql.Date.valueOf(date_end);
				String query = "SELECT "
						+ "INTERVIEW_NO "
						+ "FROM interview_data "
						+ "WHERE INTERVIEW_DATE >= "
						+ "'" + start + "'"
						+ " AND INTERVIEW_DATE <= "
						+ "'" + end + "'"
						+ " AND "
						+ "IS_DELETED = "
						+ false
						+ " ORDER BY INTERVIEW_DATE DESC";
				System.out.println("日付前:日付後");
				List<Interview> interviewList = sendNumber(query);
				return interviewList;
			}
		} else {
			if (date_end.toString() != "") {
				Date end = java.sql.Date.valueOf(date_end);
				String query = "SELECT "
						+ "INTERVIEW_NO "
						+ "FROM interview_data "
						+ "WHERE INTERVIEW_DATE <= "
						+ "'" + end + "'"
						+ " AND "
						+ "IS_DELETED = "
						+ false
						+ " ORDER BY INTERVIEW_DATE DESC";
				System.out.println("日付後");
				List<Interview> interviewList = sendNumber(query);
				return interviewList;
			} else {
				String query = "SELECT "
						+ "INTERVIEW_NO "
						+ "FROM interview_data "
						+ "WHERE IS_DELETED = "
						+ false
						+ " ORDER BY INTERVIEW_DATE DESC";
				System.out.println("全件");
				List<Interview> interviewList = sendNumber(query);
				return interviewList;
			}
		}
		System.out.println("検索に失敗しました");

		List<Interview> interviewList = new ArrayList<Interview>();
		return interviewList;
	}

	//検索条件から該当する全ての面談番号を取得して、配列フィールドに格納する
	public int selectParseNumber(String date_start, String date_end, String speaker, String title, int current_number) {
		List<Interview> interviewList = reference(date_start, date_end, speaker, title);
		interviewNumber = new int[interviewList.size()];
		for (int i = 0; i < interviewList.size(); i++) {
			interviewNumber[i] = interviewList.get(i).getInterviewNumber();
			System.out.println("interviewList.get(i).getInterviewNumber()" + interviewList.get(i).getInterviewNumber());
		}
		return selectNumber(selectPage(current_number));
	}

	//該当データの{面談番号}を検索して{該当の配列の値}を探し{配列の番号（現在のページナンバー）]を返す
	public int selectPage(int current_number) {
		int current_page = 0;
		for (int i = 0; i < interviewNumber.length; i++) {
			if (current_number == interviewNumber[i]) {
				current_page = i;
				break;
			}
		}
		return current_page;
	}

	//該当データの{全ての面談番号}を検索して{面談番号の総数}で表示すべき{ページ番号]を表示する
	public int selectLimitNumber() {
		int page_max = interviewNumber.length;
		return page_max;
	}

	//該当データの{全ての面談番号}を検索して{現在のページナンバー}で表示すべき{面談番号]を表示する
	public int selectNumber(int current_page) {
		int number = interviewNumber[current_page];
		return number;
	}
}
