package com.masai.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.exception.CustomerException;
import com.masai.model.Address;
import com.masai.model.CurrentUsersSession;
import com.masai.model.Customer;
import com.masai.repository.AddressDAO;
import com.masai.repository.CustomerDAO;
import com.masai.repository.SessionDAO;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO cDao;
	
	@Autowired
	private AddressDAO aDao;
	
	@Autowired
	private SessionDAO sDao;
	

	
	
	@Override
	public Customer addCustomer(Customer cust) throws CustomerException,AddressException {
		
		Optional<Customer> c=cDao.findByMobileNumber(cust.getMobileNumber());
		if(c.isPresent()) {
			throw new CustomerException("Mobile number already exit");
		}else {
			List<Address> addresses=cust.getAddresses();
				for(Address address:addresses) {
					Address ad=aDao.save(address);
					ad.setCustomer(cust);
				}
			}
			Customer cu=cDao.save(cust);
			return cu;
		}
	@Override
	public Customer updateCustomer(Customer cust,String key) throws CustomerException, AddressException {
		
		CurrentUsersSession loginUser=sDao.findByUuid(key);
		if(loginUser==null) {
			throw new CustomerException("please Enter valid key");
		}
		
		
		if(cust.getCustomerId()==loginUser.getUserId()) {
			for(Address a:cust.getAddresses()) {
				a.setCustomer(cust);
				Address ad=aDao.save(a);
			}
			return cDao.save(cust);
			
		}
		throw new CustomerException("User not found");
	}
	@Override
	public Customer removeCustomer(Integer customerId,String key) throws CustomerException {

		CurrentUsersSession loginUser=sDao.findByUuid(key);
		if(loginUser==null) {
			throw new CustomerException("please Enter valid key");
		}
		
		
		if(customerId==loginUser.getUserId()) {
			
			Optional<Customer> c=cDao.findById(customerId);
			
			cDao.delete(c.get());
			
			return c.get();
		}
		throw new CustomerException("User not found");
	
	}
	@Override
	public Customer viewCustomer(Integer customerId,String key) throws CustomerException {
		CurrentUsersSession loginUser=sDao.findByUuid(key);
		if(loginUser==null) {
			throw new CustomerException("please Enter valid key");
		}
//		
		
		if(customerId==loginUser.getUserId()) {
			
			Optional<Customer> c=cDao.findById(customerId);
			
			return c.get();
		}
		throw new CustomerException("User not found"+customerId);
		
	}
	@Override
	public List<Customer> ViewAllCustomer(String city) throws CustomerException, AddressException {
	
		List<Address> alist=aDao.getAllCustomer(city);

		if(alist.size()==0) {
			throw new AddressException("Customers not found "+city);
		}
		List<Customer> cList=new ArrayList<>();
		for(Address a:alist) {
			cList.add(a.getCustomer());
		}
		return cList;
	}
	

}
