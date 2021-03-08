package com.example.demo.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interview.Interview;

@Controller
public class SearchController {

	private final int page_min = 1;
	private int page_max = 1;
	private int page = 1;
	private List<Interview> interview;

	@Autowired
	private SearchRepository searchRepository;

	@GetMapping("/search2")
	public String getSearch(Model model) {
		return "view/search/search2";
	}


	@RequestMapping(value = "/search2", method = RequestMethod.POST, params = "search_button")

	public String postSearch(@RequestParam("search_date_start") String start,
			@RequestParam(name = "search_date_end",defaultValue="") String end, @RequestParam("search_name") String name, Model model) {
		interview = searchRepository.search(start, end, name);
		page = 1;
		page_max = interview.size() / 10 + 1;
		display(model);
		return "view/search/search2";
	}

	@RequestMapping(value = "/search2", method = RequestMethod.POST, params = "prev_button")
	public String previousButton(Model model) {
		if (page != page_min) {
			page--;
		}
		display(model);
		return "view/search/search2";
	}

	@RequestMapping(value = "/search2", method = RequestMethod.POST, params = "next_button")
	public String nextButton(Model model) {
		if (page != page_max) {
			page++;
		}
		display(model);
		return "view/search/search2";
	}

	//{(page - 1) * 10}　そのページで表示する最終データの番号
	private void display(Model model) {
		for (int i = 0; i < interview.size() - (page - 1) * 10 && i < 10; i++) {
			String j = String.valueOf(i + 1);

			model.addAttribute("page_number", page + "/" + page_max);
			model.addAttribute("info_date_" + j, interview.get(i + (page - 1) * 10).getInterviewDate());
			model.addAttribute("info_name_" + j, interview.get(i + (page - 1) * 10).getInterviewSpeaker());
			model.addAttribute("info_title_" + j, interview.get(i + (page - 1) * 10).getInterviewTitle());
		}

	}
}