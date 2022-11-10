package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.model.Address;
import com.masai.repository.AddressDAO;
@Service
public class AddressServiceImpl  implements AddressService{

	
	private AddressDAO aDao;
	
	@Override
	public Address addAddress(Address add) throws AddressException {
		
		Address address=aDao.save(add);
		
		if(address==null) {
			throw new AddressException("Address is not saved");
		}
		return address;
	}

	@Override
	public Address updateAddress(Address add) throws AddressException {
		
		Optional<Address> a=aDao.findById(add.getAddressId());
		if(a.isPresent()) {
			Address address=a.get();
			address=add;
			return address;
		}else {
			throw new AddressException("Addrsss not found"+add.getAddressId());
		}
		
	}

	@Override
	public Address removeAddress(Address add) throws AddressException {
		Optional<Address> a=aDao.findById(add.getAddressId());
		if(a.isPresent()) {
			Address address=a.get();
			address=add;
			aDao.delete(address);
			return address;
		}else {
			throw new AddressException("Addrsss not found"+add.getAddressId());
		}
		
		
		
		
	}

	@Override
	public List<Address> viewAllAddress(Integer customerId) throws AddressException, CustomerException {
		
		
		
		
		
		return null;
	}

	@Override
	public Address viewAddress(Address add) throws AddressException {
		Optional<Address> a=aDao.findById(add.getAddressId());
		if(a.isPresent()) {
			Address address=a.get();
			return address;
		}else {
			throw new AddressException("Addrsss not found"+add.getAddressId());
		}
	}

	

}
