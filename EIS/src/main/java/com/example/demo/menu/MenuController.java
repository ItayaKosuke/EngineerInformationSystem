package com.example.demo.menu;

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
public class MenuController {

	private String user_id;
	private List<User> user_role;

	@Autowired
	private MenuRepository menuRepository;

	@GetMapping("/menu")
	public String getSearch(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		user_id = auth.getName();
		user_role = menuRepository.search(user_id);
		model.addAttribute("role", user_role);
		return "view/menu/menu";
	}

	@PostMapping("/menu")
	public String postSearch(Model model) {
		return "redirect/menu";
	}
}
