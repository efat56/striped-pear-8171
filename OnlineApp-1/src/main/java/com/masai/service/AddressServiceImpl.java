package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.Address;
import com.masai.model.CurrentUsersSession;
import com.masai.model.Customer;
import com.masai.repository.AddressDAO;
import com.masai.repository.CustomerDAO;
import com.masai.repository.SessionDAO;
@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDAO aDao;
	
	@Autowired
	private CustomerDAO cDao;
	
	@Autowired
	private SessionDAO sDao;
	@Override
	public Address addAddress(Address add,String key) throws AddressException,LoginException,CustomerException {
		
		
			CurrentUsersSession loginUser=sDao.findByUuid(key);
			if(loginUser==null) {
				throw new LoginException("please login");
			}else {
				Optional<Customer> c=cDao.findById(loginUser.getUserId());
				if(c.isPresent()) {
					c.get().getAddresses().add(add);
					Address a=aDao.save(add);
					if(a!=null) {
							a.setCustomer(c.get());
						return a;
					}else {
						throw new AddressException("Address not saved");
					}
				}else {
					throw new CustomerException("Customer not found");
				}
			}
	}

	@Override
	public Address updateAddress(Address add, String key) throws AddressException, LoginException {
		CurrentUsersSession loginUser=sDao.findByUuid(key);
		if(loginUser==null) {
			throw new LoginException("please login");
		}else {
			Optional<Address> a=aDao.findById(add.getAddressId());
			if(a.isPresent()) {
			Address addr=aDao.save(a.get());
			return addr;
			}else {
			throw new AddressException("Address not found");
			}

		}
		

	}
	@Override
	public Address removeAddress(Address add, String key) throws AddressException, LoginException {
		
		CurrentUsersSession loginUser=sDao.findByUuid(key);
		if(loginUser==null) {
			throw new LoginException("please login");
		}else {
			Optional<Address> a=aDao.findById(add.getAddressId());
			if(a.isPresent()) {
			Address addr=a.get();
			aDao.delete(addr);
			return addr;
			}else {
			throw new AddressException("Address not found");
			}
		}
	}
	@Override
	public List<Address> viewAllAddress(String key) throws AddressException, LoginException {
		
		CurrentUsersSession loginUser=sDao.findByUuid(key);
		if(loginUser==null) {
			throw new LoginException("please login");
		}else {
			Optional<Customer> cust=cDao.findById(loginUser.getUserId());
			if(cust.isPresent()) {
				List<Address> ad=cust.get().getAddresses();
				return ad;
			}else {
				throw new AddressException("Address not found"+key);
			}
		}
		
	}
	@Override
	public List<Address> viewAllAddress() throws AddressException {
		
		List<Address> alist=aDao.findAll();
		if(alist.size()==0) {
			throw new AddressException("Address not found");
		}
		
		
		return alist;
	}

}
