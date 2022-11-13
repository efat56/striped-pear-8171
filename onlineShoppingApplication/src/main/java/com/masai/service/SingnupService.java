package com.masai.service;

import com.masai.exception.SignupException;
import com.masai.model.AdminPannel;
import com.masai.model.Customer;

public interface SingnupService {
	
	public AdminPannel  signupAdmin(AdminPannel signUpAdmin)throws SignupException;
	public Customer signupCustomer(Customer signCus)throws SignupException;

}
