package com.example.demo.changePassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordController {
	@Autowired
	private ChangePasswordRepository changePasswordRepository;

	@GetMapping("/changePassword")
	public String getSearch(Model model) {
		return "view/changePassword/changePassword";
	}
	@PostMapping("/changePassword")
	public String postSearch(Model model) {
		return "view/changePassword/changePassword";
	}
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, params = "update_button")
	public String postUpdate(@RequestParam("id") String id,
							  @RequestParam("current_pass") String current_pass,
							  @RequestParam("new_pass") String new_pass,
							  @RequestParam("check_pass") String check_pass,
							  Model model) {
		String login_pass=changePasswordRepository.selectPass(id);
		System.out.println(login_pass);
		System.out.println(current_pass);
		if(login_pass.equals(current_pass))
		{
			if(new_pass.equals(check_pass)){
				changePasswordRepository.update(id, new_pass);
			}else{
				model.addAttribute("pass_err","新パスワードが違います");
			}
		}else {
			model.addAttribute("pass_err","現在のパスワードが違います");
		}
		return "view/changePassword/changePassword";
	}
}
