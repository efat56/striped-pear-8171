package com.masai.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.model.Address;
@Service
public class AddressServiceImpl implements AddressService{

	@Override
	public Address addAddress(Address add, String key) throws AddressException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(Address add) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address removeAddress(Integer addressId) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> viewAllAddress() throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address viewAddress(Integer id) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

}
