package com.masai.service;

import java.util.List;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	
	public Customer addCustomer(Customer cust) throws CustomerException,AddressException;
	
	public Customer updateCustomer(Customer cust,String key) throws CustomerException,AddressException;
	
	public Customer removeCustomer(Integer customerId,String key) throws CustomerException;
	
	public Customer viewCustomer(Integer customerId,String key) throws CustomerException;
	
	public List<Customer> ViewAllCustomer(String city) throws CustomerException,AddressException;

}
