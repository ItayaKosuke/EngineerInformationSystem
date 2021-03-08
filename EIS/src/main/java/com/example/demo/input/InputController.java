package com.example.demo.input;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InputController {

	@GetMapping("/input")
	public String getSearch(Model model) {
		return "view/input/input";
	}
	@PostMapping("/input")
	public String postSearch(Model model) {
		return "view/input/input";
	}
}
