package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	
	public Customer addCustomer(Customer cust)throws CustomerException;
	public Customer updateCustomer(Customer cust)throws CustomerException;
	public Customer removeCustomer(Customer cust)throws CustomerException;
	public Customer viewCustomer(Customer cust)throws CustomerException;
	public List<Customer> viewAllCustomer(String location)throws CustomerException;

}
