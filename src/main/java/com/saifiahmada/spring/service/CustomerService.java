package com.saifiahmada.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Customer;
import com.saifiahmada.spring.domain.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void save(Customer customer){
		customerRepository.save(customer);
	}
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

}
