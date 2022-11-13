package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.LoginDTO;
import com.masai.exception.LoginException;
import com.masai.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService lService;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO login) throws LoginException{
		
		String s=lService.logInAccount(login);
		
		return new ResponseEntity<String>(s, HttpStatus.CREATED);
	}
	@PostMapping("/logout")
	public ResponseEntity<String> logoutCustomer(@RequestParam String key) throws LoginException{
		
		String s=lService.logOutfromAccount(key);
		
		return new ResponseEntity<String>(s, HttpStatus.ACCEPTED);
	}
	
	
}
