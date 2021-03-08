package com.example.demo.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.interview.Interview;

@Controller
public class DetailController {

	private List<Interview> interview;

	@Autowired
	private DetailRepository detailRepository;

	@GetMapping("/detail")
	public String getSearch(Model model) {
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_1")
	public String postSearch(Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	private void display(Model model) {
		model.addAttribute("speaker", interview.get(0).getInterviewSpeaker());
		model.addAttribute("listener", interview.get(0).getInterviewListener());
		model.addAttribute("date", interview.get(0).getInterviewDate());
		model.addAttribute("type", interview.get(0).getInterviewType());
		model.addAttribute("method", interview.get(0).getInterviewStyle());
		model.addAttribute("title", interview.get(0).getInterviewTitle());
		model.addAttribute("contents", interview.get(0).getInterviewDetail());
	}
}