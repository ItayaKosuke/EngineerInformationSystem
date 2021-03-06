package com.example.demo.changePassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordController {

	@Autowired
	private ChangePasswordRepository changePasswordRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/changePassword")
	public String getSearch(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String listener_id = auth.getName();
		model.addAttribute("listener_id", listener_id);
		return "view/changePassword/changePassword";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, params = "update_button")
	public String postUpdate(@RequestParam("current_pass") String current_pass,
			@RequestParam("new_pass") String new_pass,
			@RequestParam("check_pass") String check_pass,
			Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String login_pass = changePasswordRepository.selectPass(auth.getName());
		if (passwordEncoder.matches(current_pass, login_pass)) {
			if (new_pass.equals(check_pass)) {
				changePasswordRepository.update(auth.getName(), new_pass);
			} else {
				model.addAttribute("pass_err", "新パスワードが違います");
			}
		} else {
			model.addAttribute("pass_err", "現在のパスワードが違います");
		}
		return "view/changePassword/changePassword";
	}
}
