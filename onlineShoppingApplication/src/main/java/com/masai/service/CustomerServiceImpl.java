package com.masai.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.login.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.CustomerRepo;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CurrentUserSectionService currentUserSerSec;
	
	private CurrentUserSessionRepo curUserServiceRepo;

	@Override
	public Customer addCustomer(Customer cust) throws CustomerException {

		Optional<Customer> opt = customerRepo.findByMobileNumber(cust.getMobileNumber()) ;
		
		if(opt.isPresent()) {
			throw new CustomerException("Customer already Exist With this Mobile Number");
		}
		
		return customerRepo.save(cust);
	}

	@Override
	public Customer updateCustomer(Customer cust, String key) throws CustomerException, LoginException {
       Customer cDetails = currentUserSerSec.getCustomerDetails(key) ;
		
		if(cDetails == null) {
			throw new LoginException("Login first....not user found....");
		}else if( cust.getMobileNumber().toCharArray().length != 10 ){
			
			throw new CustomerException("Mobile Number can only 10 digit....");
		}
		
		if(cust.getCustomerId() == cDetails.getCustomerId()) {
			return customerRepo.save(cust) ;
		}
		else {
			throw new CustomerException("Can't change UserID!") ;
		}
	}

	@Override
	public Customer removeCustomer(Customer cust, String key) throws CustomerException, LoginException {

		Customer currentCustomer = currentUserSerSec.getCustomerDetails(key);
		
		if(currentCustomer != null) {
			
			if(cust.getCustomerId() == currentCustomer.getCustomerId()) {
				
				customerRepo.delete(cust);
				
				Optional<CurrentUserSession> opt = curUserServiceRepo.findByUuid(key) ;
				
				CurrentUserSession currentSession = opt.get();
				
				curUserServiceRepo.delete(currentSession);
				return cust;
				
				
			}
			else {
				throw new CustomerException("Invalid Customer ID") ;
			}
			
		}
		else {
			throw new CustomerException("Invalid UUID key");
		}
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		
		
		
       Optional<Customer> customer = customerRepo.findById(customerId);
		
		customer.orElseThrow(()-> new CustomerException("Customer doesn't found..."));
		
		return customer.get();
	}

	@Override
	public List<Customer> viewAllCustomer(String location) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
