package com.example.demo.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getSearch(Model model) {
		return "view/login/login";
	}
	@PostMapping("/login")
	public String postSearch(Model model) {
		return "redirect/search2";
	}
}
