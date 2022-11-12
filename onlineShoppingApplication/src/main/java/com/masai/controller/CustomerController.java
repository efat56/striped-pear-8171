package com.masai.controller;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException{

		Customer addedCustomer = customerService.addCustomer(customer);
		
		 return new ResponseEntity<Customer>(addedCustomer, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/customers/{key}")
	public ResponseEntity<Customer> updateCustomeHandler(@PathVariable("key")String key, @RequestBody Customer customer) throws LoginException, CustomerException{
		Customer updateCustomer = customerService.updateCustomer(customer,key);
		
	return new 	ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{cusId}")
	public ResponseEntity<Customer> viewCustomerHandler(@PathVariable("cusId")Integer customerId) throws CustomerException{
		
		Customer cus = customerService.viewCustomer(customerId);
		
		return new ResponseEntity<Customer>(cus,HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/customers/{key}")
	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable("key") String key,@RequestBody Customer customer) throws CustomerException, LoginException{
		
		Customer deletedCustomer = customerService.removeCustomer(customer, key);
		
		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
		
	}

}
