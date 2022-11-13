package com.masai.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomer(@Valid@RequestBody Customer cust) throws CustomerException, AddressException{
		
		Customer c=cService.addCustomer(cust);
		
		return new ResponseEntity<Customer>(c, HttpStatus.CREATED);
	}
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@Valid@RequestBody Customer cust,@RequestParam String key) throws CustomerException, AddressException{
		
		Customer c=cService.updateCustomer(cust,key);
		
		return new ResponseEntity<Customer>(c, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id") Integer id,@RequestParam String key) throws CustomerException
	{
		Customer c=cService.removeCustomer(id,key);
		
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<Customer> viewCustomer(@RequestParam Integer customerId,@RequestParam String key) throws CustomerException{
		
		Customer c=cService.viewCustomer(customerId,key);
		
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
		
	}
	@GetMapping("/customers/{city}")
	public ResponseEntity<List<Customer>> viewAllCustomer(@PathVariable("city") String city) throws CustomerException, AddressException{
		
		List<Customer> c=cService.ViewAllCustomer(city);
		
		return new ResponseEntity<List<Customer>>(c, HttpStatus.OK);
	}		
	
}
