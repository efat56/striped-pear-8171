package com.masai.service;

import java.util.List;

import com.masai.model.Address;

public interface AddressService {
	
	
	public Address addAddress(Address add);
	public Address updateAddress(Address add);
	public Address removeAddress(Address add);
	public List<Address> viewAllAddress(Integer customerId);
	public Address viewAddress(Address add);

}
