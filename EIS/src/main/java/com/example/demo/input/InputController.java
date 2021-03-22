package com.example.demo.input;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.user.User;

@Controller
public class InputController {

	private List<User> speaker;
	private List<User> listener;

	@Autowired
	private InputRepository inputRepository;

	@GetMapping("/input")
	public String getSearch(Model model) {
		return "view/input/input";
	}

	@PostMapping("/input")
	public String postSearch(Model model) {
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "add_button")
	public String postInput(@RequestParam("speaker") String speaker,
			@RequestParam("listener") String listener,
			@RequestParam("date") String date,
			@RequestParam("method_pulldown") String method_pulldown,
			@RequestParam("type") String type,
			@RequestParam("title") String title,
			@RequestParam("contents") String contents,
			Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String author = auth.getName();
		if (inputRepository.add(speaker, listener, date, method_pulldown, type, title, contents, author)) {
			display(model);
		}
		return "view/input/input";
	}

	private void display(Model model) {
		model.addAttribute("add_err", "追加できませんでした。");
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "load_button")
	public String postSearch(@RequestParam("speaker_id") String speaker_id,
			@RequestParam("listener_id") String listener_id,
			Model model) {
		speaker = inputRepository.search(speaker_id);
		listener = inputRepository.search(listener_id);
		model.addAttribute("speaker", speaker.get(0).getUserName());
		model.addAttribute("listener", listener.get(0).getUserName());
		return "view/input/input";
	}
}
