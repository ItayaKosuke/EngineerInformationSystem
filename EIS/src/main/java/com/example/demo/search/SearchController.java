package com.example.demo.search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

	@GetMapping("/search")
	public String getSearch(Model model) {
		return "view/search/search";
	}
	@PostMapping("/search")
	public String postSearch(Model model) {
		return "view/search/search";
	}

}
