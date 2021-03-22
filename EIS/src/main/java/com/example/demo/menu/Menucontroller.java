package com.example.demo.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Menucontroller {

	@GetMapping("/menu")
	public String getSearch(Model model) {
		return "view/menu/menu";
	}
	@PostMapping("/menu")
	public String postSearch(Model model) {
		return "redirect/menu";
	}
}
