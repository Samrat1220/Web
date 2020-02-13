package com.login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.login.model.Login;
import com.login.service.LoginService;



@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/createLogin")
	public String createLogin(Model model)
	{
		Login login=new Login();
		//goal.setMinutes(10);
		model.addAttribute("login",login);
		return "loginpage";
	}
	
	@RequestMapping(value="createLogin",method=RequestMethod.POST)
	public @ResponseBody Login createLogin(@ModelAttribute("login")Login login) {
		return loginService.createLogin(login);
	}
}
