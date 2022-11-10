package com.masai.service;

import java.util.List;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.model.Address;

public interface AddressService {
	
	
	public Address addAddress(Address add)throws AddressException;
	public Address updateAddress(Address add)throws AddressException;
	public Address removeAddress(Address add)throws AddressException;
	public List<Address> viewAllAddress(Integer customerId)throws AddressException,CustomerException;
	public Address viewAddress(Address add)throws AddressException;

}
