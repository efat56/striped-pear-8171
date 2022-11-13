package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.SignupException;
import com.masai.model.AdminPannel;
import com.masai.model.Customer;
import com.masai.service.SingnupService;

@RestController
@RequestMapping("/signup")
public class SignUpController {
//
//	@Autowired
//	private SingnupService signser;
//	
//	@PostMapping("/Admin")
//	public ResponseEntity<AdminPannel> signUpAdminHandler(@RequestBody AdminPannel adPannel) throws SignupException{
//	    AdminPannel add=signser.signupAdmin(adPannel);
//	    
//	  return  new ResponseEntity<AdminPannel>(add,HttpStatus.ACCEPTED);
//	}
//	
//	@PostMapping("/Customer")
//	public ResponseEntity<Customer> signUpCustomerHandler(@RequestBody Customer customer) throws SignupException{
//	    Customer cus=signser.signupCustomer(customer);
//	    
//	  return  new ResponseEntity<Customer>(cus,HttpStatus.ACCEPTED);
//	}
//	
}
