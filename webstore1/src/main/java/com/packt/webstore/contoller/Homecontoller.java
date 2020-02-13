package com.packt.webstore.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontoller {

	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to webstore");
		model.addAttribute("tagline", "the one and only amazing webstore");
		return "welcome";
	}
}
