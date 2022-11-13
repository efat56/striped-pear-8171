package com.masai.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
    public Customer addCustomer(Customer cust) throws CustomerException ;
	
	public Customer updateCustomer(Customer cust, String key) throws CustomerException, LoginException;
	
	public Customer removeCustomer(Customer cust, String key) throws CustomerException, LoginException;
	
	public Customer viewCustomer(Integer customerId)  throws CustomerException;
	
	public List<Customer> viewAllCustomer(String location) throws CustomerException ;

}
