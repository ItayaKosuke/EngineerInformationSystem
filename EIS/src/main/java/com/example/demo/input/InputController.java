package com.example.demo.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InputController {

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
	public String postSearch(@RequestParam("speaker") String speaker,
							  @RequestParam("listener") String listener,
							  @RequestParam("date") String date,
							  @RequestParam("method_pulldown") String method_pulldown,
							  @RequestParam("type") String type,
							  @RequestParam("title") String title,
							  @RequestParam("contents") String contents,
							  Model model) {
		if(inputRepository.add(speaker, listener, date, method_pulldown, type, title, contents))
		{
			display(model);
		}
		return "view/input/input";
	}
	private void display(Model model) {
			model.addAttribute("add_err", "追加できませんでした。");
	}
}
