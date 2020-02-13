package com.Fitbit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Fitbit.model.Goal;

@Controller
@SessionAttributes("goal")
public class goalController {

	@RequestMapping(value="/addGoal")
	public String addGoal(Model model)
	{
		Goal goal=new Goal();
		//goal.setMinutes(10);
		model.addAttribute("goal",goal);
		return "addGoal";
	}
	
	@RequestMapping(value="addGoal",method=RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addGoal";
		}
		
		System.out.println("minutes Updated:"+goal.getMinutes());
		return "redirect:addMinutes";
	}
}
