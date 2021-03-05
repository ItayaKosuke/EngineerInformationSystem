package com.example.demo.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@Autowired
	private SearchRepository searchRepository;

	@GetMapping("/search")
	public String getSearch(Model model) {
		return "view/search/search2";
	}

	@PostMapping("/search")
	public String postSearch(@RequestParam("search_date_start") String start,
			@RequestParam("search_date_end") String end, @RequestParam("search_name") String name, Model model) {

		List<Interview> interview = searchRepository.search(start,end,name);

		for (int i = 0; i < interview.size() && i < 10; i++) {
			String j = String.valueOf(i + 1);
			model.addAttribute("info_date_" + j, interview.get(i).getInterviewDate());
			model.addAttribute("info_name_" + j, interview.get(i).getInterviewSpeaker());
			model.addAttribute("info_title_" + j, interview.get(i).getInterviewTitle());
		}
		return "view/search/search";
	}
}
