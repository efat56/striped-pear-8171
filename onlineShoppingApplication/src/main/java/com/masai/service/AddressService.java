package com.masai.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.exception.AddressException;
import com.masai.model.Address;

public interface AddressService {
	
	public Address addAddress(Address add, String key)throws AddressException, LoginException;
	
	public Address updateAddress(Address add)throws AddressException;
	
	public Address removeAddress(Integer addressId)throws AddressException;
	
	public List<Address> viewAllAddress()throws AddressException;
	
	public Address viewAddress(Integer id)throws AddressException;

}
