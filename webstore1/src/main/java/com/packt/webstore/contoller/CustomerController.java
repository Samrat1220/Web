package com.packt.webstore.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.repository.CustomerInterface;
import com.packt.webstore.service.CustomerService;

@ComponentScan(basePackages = {"com.packt.webstore.domain.repository.impl","com.packt.webstore.service.impl"})
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerInterface customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public String list(Model model)
	{
		model.addAttribute("customers", customerRepository.getAllCustomers());
		return "customers";
	}
}
