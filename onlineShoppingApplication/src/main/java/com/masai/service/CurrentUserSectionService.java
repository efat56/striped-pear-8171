package com.masai.service;


import javax.security.auth.login.LoginException;

import com.masai.login.CurrentUserSession;
import com.masai.model.Customer;

public interface CurrentUserSectionService {
	
   public CurrentUserSession getCurrentUserSession(String key) throws LoginException;
	
	public Integer getCurrentUserCustomerId(String key) throws LoginException;
	
	public Customer getCustomerDetails(String key) throws LoginException;

}
