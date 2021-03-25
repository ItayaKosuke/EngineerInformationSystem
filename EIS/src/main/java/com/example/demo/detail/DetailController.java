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
	private String result_title;
	private final int page_min = 1;
	private int page_max = 1;
	private int page = 1;
	private List<Interview> interview;

	@Autowired
	private DetailRepository detailRepository;

	@GetMapping("/detail")
	public String getSearch(Model model) {
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "prev_button")
	public String previousButton(Model model) {
		if (page != page_min) {
			page--;
		}
		//(page - 1)*配列とページのズレの修正*
		interview = detailRepository.search(detailRepository.selectNumber(page - 1));
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "next_button")
	public String nextButton(Model model) {
		if (page != page_max) {
			page++;
		}
		//(page - 1)*配列とページのズレの修正*
		interview = detailRepository.search(detailRepository.selectNumber(page - 1));
		display(model);
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
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_2")
	public String postSearch2(@RequestParam("info_number_2") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_3")
	public String postSearch3(@RequestParam("info_number_3") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		this.result_date_start = result_date_start;
		this.result_date_end = result_date_end;
		this.result_name = result_name;
		this.result_title = result_title;
		interview = detailRepository.search(number);
		display(model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_4")
	public String postSearch4(@RequestParam("info_number_4") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_5")
	public String postSearch5(@RequestParam("info_number_5") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_6")
	public String postSearch6(@RequestParam("info_number_6") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_7")
	public String postSearch7(@RequestParam("info_number_7") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_8")
	public String postSearch8(@RequestParam("info_number_8") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_9")
	public String postSearch9(@RequestParam("info_number_9") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_10")
	public String postSearch10(@RequestParam("info_number_10") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_11")
	public String postSearch11(@RequestParam("info_number_11") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_12")
	public String postSearch12(@RequestParam("info_number_12") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_13")
	public String postSearch13(@RequestParam("info_number_13") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_14")
	public String postSearch14(@RequestParam("info_number_14") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_15")
	public String postSearch15(@RequestParam("info_number_15") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_16")
	public String postSearch16(@RequestParam("info_number_16") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_17")
	public String postSearch17(@RequestParam("info_number_17") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_18")
	public String postSearch18(@RequestParam("info_number_18") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_19")
	public String postSearch19(@RequestParam("info_number_19") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST, params = "detail_button_20")
	public String postSearch20(@RequestParam("info_number_20") int number,
			@RequestParam("result_date_start") String result_date_start,
			@RequestParam("result_date_end") String result_date_end, @RequestParam("result_name") String result_name,
			@RequestParam("result_title") String result_title, Model model) {
		initialize(result_date_start, result_date_end, result_name, result_title,
				number, model);
		return "view/detail/detail";
	}

	private void initialize(String result_date_start, String result_date_end, String result_name, String result_title,
			int number, Model model) {
		this.result_date_start = result_date_start;
		this.result_date_end = result_date_end;
		this.result_name = result_name;
		this.result_title = result_title;
		interview = detailRepository.search(detailRepository.selectParseNumber(result_date_start, result_date_end,
				result_name, result_title, number));
		page = detailRepository.selectPage(number) + 1;
		page_max = detailRepository.selectLimitNumber();
		display(model);
	}

	private void display(Model model) {
		model.addAttribute("result_date_start", result_date_start);
		model.addAttribute("result_date_end", result_date_end);
		model.addAttribute("result_name", result_name);
		model.addAttribute("result_title", result_title);
		model.addAttribute("page_number", page + "/" + page_max);
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