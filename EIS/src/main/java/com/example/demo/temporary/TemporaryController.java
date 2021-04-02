package com.example.demo.temporary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interview.Interview;

@Controller
public class TemporaryController {
	private final int page_min = 1;
	private int page_max = 1;
	private int page = 1;
	private int sequence = 0;
	private String search_date_start;
	private String search_date_end;
	private String search_name;
	private String search_title;
	private String listener_id;
	private List<Interview> interview;

	@Autowired
	private TemporaryRepository temporaryRepository;

	@GetMapping("/temporary")
	public String getSearch(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		listener_id = auth.getName();
		interview = temporaryRepository.search(listener_id);
		page = 1;
		page_max = interview.size() / 20 + 1;
		display(model);
		keep(model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/temporary", method = RequestMethod.POST, params = "temporary_button")
	public String getJump(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		listener_id = auth.getName();
		interview = temporaryRepository.search(listener_id);
		page = 1;
		page_max = interview.size() / 20 + 1;
		display(model);
		keep(model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/temporary", method = RequestMethod.POST, params = "search_button")

	public String postSearch(@RequestParam("search_date_start") String start,
			@RequestParam("search_date_end") String end,
			@RequestParam("search_name") String name, @RequestParam("search_title") String title, Model model) {
		interview = temporaryRepository.search(start, end, name, title, listener_id);
		page = 1;
		page_max = interview.size() / 20 + 1;
		this.search_date_start = start;
		this.search_date_end = end;
		this.search_name = name;
		this.search_title = title;
		display(model);
		keep(model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/temporary", method = RequestMethod.POST, params = "prev_button")
	public String previousButton(Model model) {
		if (page != page_min) {
			page--;
		}
		display(model);
		keep(model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/temporary", method = RequestMethod.POST, params = "next_button")
	public String nextButton(Model model) {
		if (page != page_max) {
			page++;
		}
		display(model);
		keep(model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/temporary", method = RequestMethod.POST, params = "prev_jump_button")
	public String previousJumpButton(Model model) {
		if (page - 4 <= page_min) {
			page = page_min;
		} else {
			page = page - 5;
		}
		display(model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "temporary", method = RequestMethod.POST, params = "next_jump_button")
	public String nextJumpButton(Model model) {
		if (page + 4 >= page_max) {
			page = page_max;
		} else {
			page = page + 5;
		}
		display(model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/temporary", method = RequestMethod.POST, params = "sequence_button")
	public String sequenceButton(Model model) {
		if (sequence == 0) {
			this.sequence = 1;
		} else if (sequence == 1) {
			this.sequence = 0;
		}
		display(model);
		keep(model);
		return "view/temporary/temporary";
	}

	//{(page - 1) * 20}　そのページで表示する最終データの番号
	private void display(Model model) {
		model.addAttribute("result_date_start", search_date_start);
		model.addAttribute("result_date_end", search_date_end);
		model.addAttribute("result_name", search_name);
		model.addAttribute("result_title", search_title);
		model.addAttribute("page_number", page + "/" + page_max);
		if (sequence == 0) {
			for (int i = 0; i < interview.size() - (page - 1) * 20 && i < 20; i++) {
				String j = String.valueOf(i + 1);

				model.addAttribute("info_date_" + j, interview.get(i + (page - 1) * 10).getInterviewDate());
				model.addAttribute("info_name_" + j, interview.get(i + (page - 1) * 10).getInterviewSpeaker());
				model.addAttribute("info_title_" + j, interview.get(i + (page - 1) * 10).getInterviewTitle());
				model.addAttribute("info_number_" + j, interview.get(i + (page - 1) * 10).getInterviewNumber());
			}
		}
		//逆数に注意
		if (sequence == 1) {
			for (int i = 0; i < interview.size() - (page - 1) * 20 && i < 20; i++) {
				String j = String.valueOf(i + 1);

				model.addAttribute("info_date_" + j,
						interview.get(interview.size() - (i + 1) - (page - 1) * 10).getInterviewDate());
				model.addAttribute("info_name_" + j,
						interview.get(interview.size() - (i + 1) - (page - 1) * 10).getInterviewSpeaker());
				model.addAttribute("info_title_" + j,
						interview.get(interview.size() - (i + 1) - (page - 1) * 10).getInterviewTitle());
				model.addAttribute("info_number_" + j,
						interview.get(interview.size() - (i + 1) - (page - 1) * 10).getInterviewNumber());
			}
		}
	}

	private void keep(Model model) {
		model.addAttribute("search_date_start", search_date_start);
		model.addAttribute("search_date_end", search_date_end);
		model.addAttribute("search_name", search_name);
		model.addAttribute("search_title", search_title);
	}
}
