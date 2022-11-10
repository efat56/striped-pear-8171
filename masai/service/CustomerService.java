package com.masai.service;

import java.util.List;

import com.masai.model.Customer;

public interface CustomerService {
	
	
	public Customer addCustomer(Customer cust);
	public Customer updateCustomer(Customer cust);
	public Customer removeCustomer(Customer cust);
	public Customer viewCustomer(Customer cust);
	public List<Customer> viewAllCustomer(Customer cust);

}
