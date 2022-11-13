package com.masai.service;

import com.masai.dto.LoginDTO;
import com.masai.exception.LoginException;

public interface LoginService {
	
	public String logInAccount(LoginDTO login) throws LoginException;
	
	public String logOutfromAccount(String key) throws LoginException;

}
