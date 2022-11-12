package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.UserException;
import com.masai.login.CurrentUserSession;
import com.masai.model.AdminPannel;
import com.masai.model.Customer;
import com.masai.model.User;
import com.masai.repository.AdminRepo;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.CustomerRepo;
import com.masai.repository.ProductRepo;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;
	
	

	

	@Autowired
    private CurrentUserSectionService  currentUserSessionService;

	
	
	@Override
	public CurrentUserSession addUser(User user) throws UserException, CustomerException {
		
		
		
      Optional<Customer> opt = customerRepo.findByMobileNumber(user.getUserId()) ;
		
		if(opt.isEmpty()) {
			throw new CustomerException("User not found with Mobile number : "+user.getUserId());
		}
		
		Customer currentCustomer = opt.get();
		
		Integer customerId = currentCustomer.getCustomerId();
		
		Optional<CurrentUserSession> currentUserOptional = currentUserSessionRepo.findByCustomerId(customerId);
		
		if(currentUserOptional.isPresent()) {
			throw new UserException("User has already logged in with userId : " + user.getUserId());
		}
		if(currentCustomer.getMobileNumber().equals(user.getUserId()) && currentCustomer.getPassword().equals(user.getPassword())) {
			
			String key = RandomString.make(6) ;
			
			CurrentUserSession currentUserSession = new CurrentUserSession( customerId, key, LocalDateTime.now()) ;
			
			return  currentUserSessionRepo.save(currentUserSession) ;
			
			
		}
		else {
			throw new UserException("Invalid UserId OR Password");
		}
	}
	@Override
	public User removeUser(User user, String key) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User validateUser(User user, String key) throws UserException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String signOut(String key) throws UserException, LoginException {
		
//      CurrentUserSession uSession = currentUserSessionService.getCurrentUserSession(key);
//		
//		if(uSession != null) {
//			
//			currentUserSessionRepo.delete(uSession);
//
//			
//			return "successfully log out......";
//		}
//		else {
//			throw new UserException("failled logged out...");
//		}
		
		return null;
	}

	

}
