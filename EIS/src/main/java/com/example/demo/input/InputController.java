package com.example.demo.input;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interview.Interview;
import com.example.demo.user.User;

@Controller
public class InputController {

	private List<User> speaker;
	private List<User> listener;
	private String speaker_id;
	private String listener_id;
	private List<Interview> interview;

	@Autowired
	private InputRepository inputRepository;

	@GetMapping("/input")
	public String getSearch(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		listener_id = auth.getName();
		listener = inputRepository.search(listener_id);
		model.addAttribute("listener_id", listener_id);
		model.addAttribute("listener", listener.get(0).getUserName());
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "add_button")
	public String postInput(@RequestParam("speaker") String speaker,
			@RequestParam("listener") String listener,
			@RequestParam("date") String date,
			@RequestParam("method") String method,
			@RequestParam("type") String type,
			@RequestParam("title") String title,
			@RequestParam("contents") String contents,
			@RequestParam("speaker_id") String speaker_id,
			@RequestParam("listener_id") String listener_id,
			@RequestParam("number_label") String number_label,
			Model model) {
		if (inputRepository.add(speaker, listener, date, method, type, title, contents, speaker_id, listener_id)) {
			System.out.println("1件のデータを登録しました");
		} else {
			System.out.println("登録に失敗しました");
		}
		if (number_label.toString() != "") {
			int number = Integer.parseInt(number_label);
			inputRepository.delete(number);
		}
		model.addAttribute("listener_id", listener_id);
		model.addAttribute("listener", listener);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "temporary_button")
	public String postTemporary(@RequestParam("speaker") String speaker,
			@RequestParam("listener") String listener,
			@RequestParam("date") String date,
			@RequestParam("method") String method,
			@RequestParam("type") String type,
			@RequestParam("title") String title,
			@RequestParam("contents") String contents,
			@RequestParam("speaker_id") String speaker_id,
			@RequestParam("listener_id") String listener_id,
			@RequestParam("number_label") String number_label,
			Model model) {
		if (inputRepository.temporary(speaker, listener, date, method, type, title, contents, speaker_id,
				listener_id)) {
			System.out.println("1件のデータを一時保存しました");
		} else {
			System.out.println("一時保存に失敗しました");
			error(model);
		}
		if (number_label.toString() != "") {
			int number = Integer.parseInt(number_label);
			inputRepository.delete(number);
		}
		model.addAttribute("listener_id", listener_id);
		model.addAttribute("listener", listener);
		return "view/input/input";
	}

	private void error(Model model) {
		model.addAttribute("add_err", "追加できませんでした。");
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "load_button")
	public String postSearch(@RequestParam("speaker_id") String speaker_id,
			Model model) {
		speaker = inputRepository.search(speaker_id);
		this.speaker_id = speaker_id;
		model.addAttribute("speaker_id", this.speaker_id);
		model.addAttribute("speaker", speaker.get(0).getUserName());
		model.addAttribute("listener_id", listener_id);
		model.addAttribute("listener", listener.get(0).getUserName());
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_1")
	public String postSearch1(@RequestParam("info_number_1") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_2")
	public String postSearch2(@RequestParam("info_number_2") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_3")
	public String postSearch3(@RequestParam("info_number_3") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_4")
	public String postSearch4(@RequestParam("info_number_4") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_5")
	public String postSearch5(@RequestParam("info_number_5") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_6")
	public String postSearch6(@RequestParam("info_number_6") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_7")
	public String postSearch7(@RequestParam("info_number_7") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_8")
	public String postSearch8(@RequestParam("info_number_8") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_9")
	public String postSearch9(@RequestParam("info_number_9") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_10")
	public String postSearch10(@RequestParam("info_number_10") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_11")
	public String postSearch11(@RequestParam("info_number_11") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_12")
	public String postSearch12(@RequestParam("info_number_12") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_13")
	public String postSearch13(@RequestParam("info_number_13") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_14")
	public String postSearch14(@RequestParam("info_number_14") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_15")
	public String postSearch15(@RequestParam("info_number_15") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_16")
	public String postSearch16(@RequestParam("info_number_16") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_17")
	public String postSearch17(@RequestParam("info_number_17") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_18")
	public String postSearch18(@RequestParam("info_number_18") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_19")
	public String postSearch19(@RequestParam("info_number_19") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "input_button_20")
	public String postSearch20(@RequestParam("info_number_20") int number,
			Model model) {
		interview = inputRepository.search(number);
		display(model);
		return "view/input/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_1")
	public String postDelete_1(@RequestParam("info_number_1") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_2")
	public String postDelete_2(@RequestParam("info_number_2") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_3")
	public String postDelete_3(@RequestParam("info_number_3") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_4")
	public String postDelete_4(@RequestParam("info_number_4") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_5")
	public String postDelete_5(@RequestParam("info_number_5") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_6")
	public String postDelete_6(@RequestParam("info_number_6") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_7")
	public String postDelete_7(@RequestParam("info_number_7") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_8")
	public String postDelete_8(@RequestParam("info_number_8") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_9")
	public String postDelete_9(@RequestParam("info_number_9") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_10")
	public String postDelete_10(@RequestParam("info_number_10") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_11")
	public String postDelete_11(@RequestParam("info_number_11") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_12")
	public String postDelete_12(@RequestParam("info_number_12") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_13")
	public String postDelete_13(@RequestParam("info_number_13") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_14")
	public String postDelete_14(@RequestParam("info_number_14") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_15")
	public String postDelete_15(@RequestParam("info_number_15") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_16")
	public String postDelete_16(@RequestParam("info_number_16") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_17")
	public String postDelete_17(@RequestParam("info_number_17") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_18")
	public String postDelete_18(@RequestParam("info_number_18") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_19")
	public String postDelete_19(@RequestParam("info_number_19") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST, params = "delete_button_20")
	public String postDelete_20(@RequestParam("info_number_20") int number, Model model) {
		send(number, model);
		return "view/temporary/temporary";
	}

	private void send(int number, Model model) {
		System.out.println(number);
		User user = new User(number);
		if (inputRepository.delete(user)) {
			System.out.println("1件のデータが削除されました");
		} else {
			System.out.println("データの削除に失敗しました");
		}
	}

	private void display(Model model) {
		model.addAttribute("speaker", interview.get(0).getInterviewSpeaker());
		model.addAttribute("listener", interview.get(0).getInterviewListener());
		model.addAttribute("date", interview.get(0).getInterviewDate());
		model.addAttribute("type_label", interview.get(0).getInterviewType());
		model.addAttribute("method_label", interview.get(0).getInterviewStyle());
		model.addAttribute("title", interview.get(0).getInterviewTitle());
		model.addAttribute("contents", interview.get(0).getInterviewDetail());
		model.addAttribute("speaker_id", interview.get(0).getInterviewSpeakerId());
		model.addAttribute("listener_id", interview.get(0).getInterviewListenerId());
		model.addAttribute("number_label", interview.get(0).getInterviewNumber());
	}
}
