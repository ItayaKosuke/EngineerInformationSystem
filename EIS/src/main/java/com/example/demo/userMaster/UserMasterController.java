package com.example.demo.userMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserMasterController {

	private final int page_min = 1;
	private int page_max = 1;
	private int page = 1;
	private List<User> user;

	@Autowired
	private UserMasterRepository userMasterRepository;

	@GetMapping("/userMaster")
	public String getSelect(Model model) {
		refresh(model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "add_button")
	public String postInsert(@RequestParam("add_id") String id, Model model) {
		User user = new User(id);
		if (userMasterRepository.add(user)) {
			System.out.println("1件のデータが登録されました");
		} else {
			System.out.println("データの登録に失敗しました");
		}
		refresh(model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_1")
	public String postDelete_1(@RequestParam("edit_number_1") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_2")
	public String postDelete_2(@RequestParam("edit_number_2") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_3")
	public String postDelete_3(@RequestParam("edit_number_3") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_4")
	public String postDelete_4(@RequestParam("edit_number_4") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_5")
	public String postDelete_5(@RequestParam("edit_number_5") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_6")
	public String postDelete_6(@RequestParam("edit_number_6") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_7")
	public String postDelete_7(@RequestParam("edit_number_7") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_8")
	public String postDelete_8(@RequestParam("edit_number_8") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_9")
	public String postDelete_9(@RequestParam("edit_number_9") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "delete_button_10")
	public String postDelete_10(@RequestParam("edit_number_10") int number, Model model) {
		send(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "prev_button")
	public String previousButton(Model model) {
		if (page != page_min) {
			page--;
		}
		display(model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "next_button")
	public String nextButton(Model model) {
		if (page != page_max) {
			page++;
		}
		display(model);
		return "view/userMaster/userMaster";
	}

	//{(page - 1) * 10}　そのページで表示する最終データの番号
	private void display(Model model) {
		for (int i = 0; i < user.size() - (page - 1) * 10 && i < 10; i++) {
			String j = String.valueOf(i + 1);

			model.addAttribute("page_number", page + "/" + page_max);
			model.addAttribute("edit_id_" + j, user.get(i + (page - 1) * 10).getUserId());
			model.addAttribute("original_pass_" + j, user.get(i + (page - 1) * 10).getUserOriginalPassword());
			model.addAttribute("edit_number_" + j, user.get(i + (page - 1) * 10).getUserNumber());
		}
	}

	private void send(int number, Model model) {
		System.out.println(number);
		User user = new User(number);
		if (userMasterRepository.delete(user)) {
			System.out.println("1件のデータが削除されました");
		} else {
			System.out.println("データの削除に失敗しました");
		}
		refresh(model);
	}

	private void refresh(Model model) {
		user = userMasterRepository.select();
		page = 1;
		page_max = user.size() / 10 + 1;
		display(model);
	}
}
