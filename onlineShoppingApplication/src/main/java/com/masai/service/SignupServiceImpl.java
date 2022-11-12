package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.exception.SignupException;
import com.masai.model.AdminPannel;
import com.masai.model.Customer;
import com.masai.repository.AdminRepo;
import com.masai.repository.CustomerRepo;

@Service
public class SignupServiceImpl implements SingnupService{
	@Autowired
	private CustomerRepo cusRepo;
	
	@Autowired
	private AdminRepo adRepo;
	
	@Override
	public AdminPannel signupAdmin(AdminPannel signUpAdmin) throws SignupException {
		AdminPannel ap = adRepo.findByFirstName(signUpAdmin.getFirstName());
		if(ap!=null) {
			throw new SignupException("Admin already Exist");
		}else {
			return  adRepo.save(signUpAdmin);
		}
	}

	@Override
	public Customer signupCustomer(Customer signCus) throws SignupException {
		Customer cus= cusRepo.findByfirstName(signCus.getFirstName());
		
		
		if(cus !=null) {
			throw new SignupException("Customer already exist....");
		}
		else {
			return cusRepo.save(signCus);
		}
		
	}
	

	

	

}
