package com.example.demo.myaccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.user.User;

@Controller
public class MyaccountController {

	private List<User> listener;
	private String listener_id;

	@Autowired
	private MyaccountRepository myaccountRepository;

	@GetMapping("/myaccount")
	public String getSearch(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		listener_id = auth.getName();
		listener = myaccountRepository.search(listener_id);
		model.addAttribute("listener", listener.get(0).getUserName());
		return "view//myaccount/myaccount";
	}
	@PostMapping("/myaccount")
	public String postSearch(Model model) {
		return "redirect/myaccount";
	}
}
