package com.saifiahmada.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saifiahmada.spring.domain.Customer;
import com.saifiahmada.spring.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@ModelAttribute("customer")
	public Customer getCustomer(){
		return new Customer();
	}
	
	@RequestMapping(value = "/form" , method= RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("customer") Customer customer){
		customerService.save(customer); 
		return "redirect:/customer/form.html";
	}
	
	@RequestMapping(value = "/list" , method= RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("customers", customerService.findAll());
		return "customer-list";
	}

}
