package com.example.demo.edit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interview.Interview;
import com.example.demo.user.User;

@Controller
public class EditController {

	private List<User> speaker;
	private String speaker_id;
	private List<Interview> interview;

	@Autowired
	private EditRepository editRepository;

	@GetMapping("/edit")
	public String getSearch(Model model) {
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "add_button")
	public String postedit(@RequestParam("speaker") String speaker,
			@RequestParam("listener") String listener,
			@RequestParam("date") String date,
			@RequestParam("method") String method,
			@RequestParam("type") String type,
			@RequestParam("title") String title,
			@RequestParam("contents") String contents,
			@RequestParam("speaker_id") String speaker_id,
			@RequestParam("listener_id") String listener_id,
			@RequestParam("number_label") String number_label,
			Model model) {
		if (editRepository.update(number_label, speaker, date, method, type, title, contents, speaker_id)) {
			System.out.println("1件のデータを更新しました");
		} else {
			System.out.println("更新に失敗しました");
		}
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "load_button")
	public String postSearch(@RequestParam("speaker_id") String speaker_id,
			Model model) {
		speaker = editRepository.search(speaker_id);
		this.speaker_id = speaker_id;
		model.addAttribute("speaker_id", this.speaker_id);
		model.addAttribute("speaker", speaker.get(0).getUserName());
		model.addAttribute("listener", interview.get(0).getInterviewListener());
		model.addAttribute("date", interview.get(0).getInterviewDate());
		model.addAttribute("type_label", interview.get(0).getInterviewType());
		model.addAttribute("method_label", interview.get(0).getInterviewStyle());
		model.addAttribute("title", interview.get(0).getInterviewTitle());
		model.addAttribute("contents", interview.get(0).getInterviewDetail());
		model.addAttribute("listener_id", interview.get(0).getInterviewListenerId());
		model.addAttribute("number_label", interview.get(0).getInterviewNumber());
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_1")
	public String postSearch1(@RequestParam("info_number_1") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_2")
	public String postSearch2(@RequestParam("info_number_2") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_3")
	public String postSearch3(@RequestParam("info_number_3") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_4")
	public String postSearch4(@RequestParam("info_number_4") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_5")
	public String postSearch5(@RequestParam("info_number_5") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_6")
	public String postSearch6(@RequestParam("info_number_6") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_7")
	public String postSearch7(@RequestParam("info_number_7") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_8")
	public String postSearch8(@RequestParam("info_number_8") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_9")
	public String postSearch9(@RequestParam("info_number_9") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_10")
	public String postSearch10(@RequestParam("info_number_10") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_11")
	public String postSearch11(@RequestParam("info_number_11") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_12")
	public String postSearch12(@RequestParam("info_number_12") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_13")
	public String postSearch13(@RequestParam("info_number_13") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_14")
	public String postSearch14(@RequestParam("info_number_14") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_15")
	public String postSearch15(@RequestParam("info_number_15") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_16")
	public String postSearch16(@RequestParam("info_number_16") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_17")
	public String postSearch17(@RequestParam("info_number_17") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_18")
	public String postSearch18(@RequestParam("info_number_18") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_19")
	public String postSearch19(@RequestParam("info_number_19") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit_button_20")
	public String postSearch20(@RequestParam("info_number_20") int number,
			Model model) {
		interview = editRepository.search(number);
		display(model);
		return "view/edit/edit";
	}

	private void display(Model model) {
		model.addAttribute("speaker", interview.get(0).getInterviewSpeaker());
		model.addAttribute("listener", interview.get(0).getInterviewListener());
		model.addAttribute("date", interview.get(0).getInterviewDate());
		model.addAttribute("type_label", interview.get(0).getInterviewType());
		model.addAttribute("method_label", interview.get(0).getInterviewStyle());
		model.addAttribute("title", interview.get(0).getInterviewTitle());
		model.addAttribute("contents", interview.get(0).getInterviewDetail());
		model.addAttribute("speaker_id", interview.get(0).getInterviewSpeakerId());
		model.addAttribute("listener_id", interview.get(0).getInterviewListenerId());
		model.addAttribute("number_label", interview.get(0).getInterviewNumber());
	}
}
