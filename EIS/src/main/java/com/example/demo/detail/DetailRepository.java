package com.example.demo.detail;

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

	//該当データ全ての面談番号を検索画面から受け取りセットする
	public void setInterviewNumber(int[] interviewNumber) {
		this.interviewNumber = interviewNumber;
	}
}
