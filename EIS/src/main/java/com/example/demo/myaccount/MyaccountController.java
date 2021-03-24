package com.example.demo.myaccount;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyaccountController {

	@GetMapping("/myaccount")
	public String getSearch(Model model) {
		return "view//myaccount/myaccount";
	}
	@PostMapping("/myaccount")
	public String postSearch(Model model) {
		return "redirect/myaccount";
	}
}
