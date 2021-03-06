package com.example.demo.userMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.user.User;

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
	public String postInsert(@RequestParam("add_id") String id, @RequestParam("add_name") String name,
			@RequestParam("add_callname") String callname, Model model) {
		User user = new User(id, name, callname);
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

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_1")
	public String postReset_1(@RequestParam("edit_number_1") int number, Model model) {
		reset(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_2")
	public String postReset_2(@RequestParam("edit_number_2") int number, Model model) {
		reset(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_3")
	public String postReset_3(@RequestParam("edit_number_3") int number, Model model) {
		reset(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_4")
	public String postReset_4(@RequestParam("edit_number_4") int number, Model model) {
		reset(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_5")
	public String postReset_5(@RequestParam("edit_number_5") int number, Model model) {
		reset(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_6")
	public String postReset_6(@RequestParam("edit_number_6") int number, Model model) {
		reset(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_7")
	public String postReset_7(@RequestParam("edit_number_7") int number, Model model) {
		reset(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_8")
	public String postReset_8(@RequestParam("edit_number_8") int number, Model model) {
		reset(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_9")
	public String postReset_9(@RequestParam("edit_number_9") int number, Model model) {
		reset(number, model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "reset_button_10")
	public String postReset_10(@RequestParam("edit_number_10") int number, Model model) {
		reset(number, model);
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

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "prev_jump_button")
	public String previousJumpButton(Model model) {
		if (page - 4 <= page_min) {
			page = page_min;
		} else {
			page = page - 5;
		}
		display(model);
		return "view/userMaster/userMaster";
	}

	@RequestMapping(value = "/userMaster", method = RequestMethod.POST, params = "next_jump_button")
	public String nextJumpButton(Model model) {
		if (page + 4 >= page_max) {
			page = page_max;
		} else {
			page = page + 5;
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
			model.addAttribute("user_name_" + j, user.get(i + (page - 1) * 10).getUserName());
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

	private void reset(int number, Model model) {
		System.out.println(number);
		User user = new User(number);
		if (userMasterRepository.passReset(user)) {
			System.out.println("パスワードがリセットされました。");
		} else {
			System.out.println("パスワードのリセットに失敗しました。");
		}
		refresh(model);
	}

	private void refresh(Model model) {
		user = userMasterRepository.select();
		page = 1;
		page_max = (user.size() - 1) / 10 + 1;
		display(model);
	}

	@GetMapping("/userRegister")
	public String getRegister(Model model) {
		refresh(model);
		return "view/userMaster/userRegister";
	}

	@RequestMapping(value = "/userRegister", method = RequestMethod.POST, params = "add_button")
	public String postInsert(@RequestParam("add_id_1") String id_1, @RequestParam("add_name_1") String name_1,
			@RequestParam("add_callname_1") String callname_1, @RequestParam("add_id_2") String id_2,
			@RequestParam("add_name_2") String name_2,
			@RequestParam("add_callname_2") String callname_2, @RequestParam("add_id_3") String id_3,
			@RequestParam("add_name_3") String name_3,
			@RequestParam("add_callname_3") String callname_3, @RequestParam("add_id_4") String id_4,
			@RequestParam("add_name_4") String name_4,
			@RequestParam("add_callname_4") String callname_4, @RequestParam("add_id_5") String id_5,
			@RequestParam("add_name_5") String name_5,
			@RequestParam("add_callname_5") String callname_5, @RequestParam("add_id_6") String id_6,
			@RequestParam("add_name_6") String name_6,
			@RequestParam("add_callname_6") String callname_6, @RequestParam("add_id_7") String id_7,
			@RequestParam("add_name_7") String name_7,
			@RequestParam("add_callname_7") String callname_7, @RequestParam("add_id_8") String id_8,
			@RequestParam("add_name_8") String name_8,
			@RequestParam("add_callname_8") String callname_8, @RequestParam("add_id_9") String id_9,
			@RequestParam("add_name_9") String name_9,
			@RequestParam("add_callname_9") String callname_9, @RequestParam("add_id_10") String id_10,
			@RequestParam("add_name_10") String name_10,
			@RequestParam("add_callname_10") String callname_10, Model model) {
		String[] id = { id_1, id_2, id_3, id_4, id_5, id_6, id_7, id_8, id_9, id_10 };
		String[] name = { name_1, name_2, name_3, name_4, name_5, name_6, name_7, name_8, name_9, name_10 };
		String[] callname = { callname_1, callname_2, callname_3, callname_4, callname_5, callname_6, callname_7,
				callname_8, callname_9, callname_10 };

		User[] user = new User[10];
		int count = 0;
		for (int i = 0; i < 10; i++) {
			user[i] = new User(id[i], name[i], callname[i]);
			if (userMasterRepository.add(user[i])) {
				count++;
			}
		}
		System.out.println(count + "件のデータが登録されました");
		System.out.println("また、" + (10 - count) + "件のデータの登録に失敗しました");
		return "view/userMaster/userRegister";
	}
}
