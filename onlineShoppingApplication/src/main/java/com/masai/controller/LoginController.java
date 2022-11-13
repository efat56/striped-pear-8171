package com.masai.controller;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.UserException;
import com.masai.login.CurrentUserSession;
import com.masai.model.User;
import com.masai.service.LoginService;

@RestController
@RequestMapping("/users")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> addUserHandler(@Valid @RequestBody User user) throws UserException, CustomerException {

		CurrentUserSession currSession = loginService.addUser(user);
				
		return new ResponseEntity<CurrentUserSession>(currSession,HttpStatus.CREATED) ;
	}
	
	//public String signOut(String key) throws UserException, LoginException ;
	
//	@DeleteMapping("/logout")
//	public ResponseEntity<String> logoutUserHandler(@RequestParam String key) throws UserException, LoginException {
//
//		String str = loginService.signOut(key);
//		
//		return new ResponseEntity<String>(str,HttpStatus.OK) ;
//		
//	}

}
