package com.Fitbit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Fitbit.model.Exercise;

@Controller
public class MainController {

	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute ("exercise") Exercise exercise)
	{
		System.out.println("exercise :"+ exercise.getMinutes());
		return "addMinutes";
	}
}
