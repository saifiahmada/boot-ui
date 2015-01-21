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
public class IndexController {
	
	@Autowired
	private CustomerService customerService;
	
	@ModelAttribute("customer")
	public Customer getCustomer(){
		return new Customer();
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("customer", new Customer());
		model.addAttribute("message", null);
		model.addAttribute("customers", customerService.findAll());
		return "index";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("customer") Customer customer, Model model){
		try {
			customerService.save(customer);
			model.addAttribute("message", "Data Berhasil Disimpan !!!");
		} catch (Exception e) {
			model.addAttribute("message", "Error");
		}
		model.addAttribute("customers", customerService.findAll());
		return "index";
	}
	
	

}
