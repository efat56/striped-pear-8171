package com.masai.service;

import java.util.List;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.Address;

public interface AddressService {
	
	
	public Address addAddress(Address add,String key) throws AddressException,LoginException,CustomerException; 

	public Address updateAddress(Address add,String key) throws AddressException,LoginException;
	
	public Address removeAddress(Integer addressId,String key) throws AddressException,LoginException;
	
	public List<Address> viewAllAddress(String key) throws AddressException,LoginException;
	
	public List<Address> viewAllAddress() throws AddressException;
}
