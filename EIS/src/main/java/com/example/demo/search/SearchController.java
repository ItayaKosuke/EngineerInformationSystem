package com.example.demo.search;

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
	public String postSearch(@RequestParam("search_name")String str,Model model) {

		Interview interview = searchRepository.search(str);
		model.addAttribute("info_date_1",interview.getInterviewDate());
		model.addAttribute("info_name_1",interview.getInterviewSpeaker());
		model.addAttribute("info_title_1",interview.getInterviewTitle());

		return "view/search/search";
	}
}
