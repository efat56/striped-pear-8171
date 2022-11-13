package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.LoginDTO;
import com.masai.exception.LoginException;
import com.masai.model.CurrentUsersSession;
import com.masai.model.Customer;
import com.masai.repository.CustomerDAO;
import com.masai.repository.SessionDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDAO cDao;
	
	@Autowired
	private SessionDAO sDao;

	@Override
	public String logInAccount(LoginDTO login) throws LoginException {
		
		Optional<Customer> c=cDao.findByMobileNumber(login.getMobileNumber());
		
		if(c.isPresent()) {
			Optional<CurrentUsersSession> cu=sDao.findById(c.get().getCustomerId());
			if(cu.isPresent()) {
				throw new LoginException("User Already login");
			}else {
				if(c.get().getPassword().equals(login.getPassword())) {
				
				String key=RandomString.make(6);
				
				CurrentUsersSession currentuserSession= new CurrentUsersSession(c.get().getCustomerId(), key, LocalDateTime.now());
				
				CurrentUsersSession curr=sDao.save(currentuserSession);
					return curr.toString();
					
				}else {
				throw  new LoginException("please Enter valid password");
			}
			}
		}else {
			throw new LoginException("Enter the valid Mobile number");
		}


	}

	@Override
	public String logOutfromAccount(String key) throws LoginException {
		
		CurrentUsersSession session=sDao.findByUuid(key);

		if(session==null) {
			throw new LoginException("Enter the valid key");
		}else {
			sDao.delete(session);
			return "LogOut";
		}
	}
}
