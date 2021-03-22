package com.example.demo.detail;

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
public class DetailController {

	private String result_date_start;
	private String result_date_end;
	private String result_name;
	private List<Interview> interview;

	@Autowired
	private DetailRepository detailRepository;

	@GetMapping("/detail")
	public String getSearch(Model model) {
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "fix_button")
	public String postUpdate(@RequestParam("number") int number, @RequestParam("speaker") String speaker,
			@RequestParam("style") String style, @RequestParam("listener") String listener,
			@RequestParam("date") String date, @RequestParam("type") String type,
			@RequestParam("title") String title, @RequestParam("contents") String contents, Model model) {
		detailRepository.update(number, speaker, style, listener, date, type, title, contents);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_1")
	public String postSearch1(@RequestParam("info_number_1") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			Model model) {
		this.result_date_start = result_date_start;
		this.result_date_end = result_date_end;
		this.result_name = result_name;
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_2")
	public String postSearch2(@RequestParam("info_number_2") int number, Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_3")
	public String postSearch3(@RequestParam("info_number_3") int number, Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_4")
	public String postSearch4(@RequestParam("info_number_4") int number, Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_5")
	public String postSearch5(@RequestParam("info_number_5") int number, Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_6")
	public String postSearch6(@RequestParam("info_number_6") int number, Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_7")
	public String postSearch7(@RequestParam("info_number_7") int number, Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_8")
	public String postSearch8(@RequestParam("info_number_8") int number, Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_9")
	public String postSearch9(@RequestParam("info_number_9") int number, Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_10")
	public String postSearch10(@RequestParam("info_number_10") int number, Model model) {
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	private void display(Model model) {
		model.addAttribute("result_date_start", result_date_start);
		model.addAttribute("result_date_end", result_date_end);
		model.addAttribute("result_name", result_name);
		model.addAttribute("number", interview.get(0).getInterviewNumber());
		model.addAttribute("speaker", interview.get(0).getInterviewSpeaker());
		model.addAttribute("listener", interview.get(0).getInterviewListener());
		model.addAttribute("date", interview.get(0).getInterviewDate());
		model.addAttribute("type", interview.get(0).getInterviewType());
		model.addAttribute("style", interview.get(0).getInterviewStyle());
		model.addAttribute("title", interview.get(0).getInterviewTitle());
		model.addAttribute("contents", interview.get(0).getInterviewDetail());
	}
}