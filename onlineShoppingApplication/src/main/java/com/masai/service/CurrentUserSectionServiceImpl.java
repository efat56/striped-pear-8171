package com.masai.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.login.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.CustomerRepo;
@Service
public class CurrentUserSectionServiceImpl implements CurrentUserSectionService {
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public CurrentUserSession getCurrentUserSession(String key) throws LoginException {
		
		
      Optional<CurrentUserSession> currentUser = currentUserSessionRepo.findByUuid(key);
		
		if(!currentUser.isPresent()) {
			throw new  LoginException("Usernot loggedIn......");
		}
		
		return currentUser.get();
	}

	@Override
	public Integer getCurrentUserCustomerId(String key) throws LoginException {
		
		
       Optional<CurrentUserSession> currUser = currentUserSessionRepo.findByUuid(key);
		
		if(!currUser.isPresent()) {
			throw new  LoginException("User  loggedIn....");
		}
		
		return currUser.get().getCustomerId();
	}

	@Override
	public Customer getCustomerDetails(String key) throws LoginException {
		
		
		
     Optional<CurrentUserSession> currUser = currentUserSessionRepo.findByUuid(key);
		
		if(!currUser.isPresent()) {
			throw new  LoginException("User has not logged in");
		}
		
		Integer customerId = currUser.get().getCustomerId();
		
		return customerRepo.findById(customerId).get();
	}

}
