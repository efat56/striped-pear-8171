package com.masai.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.AdminPannel;
import com.masai.model.Product;
import com.masai.model.User;

public interface AdminService {
	
	
	public AdminPannel createAdmin(AdminPannel adPannel);
	
//	public User removeUser(User user,String key) throws UserException ;
//	public User validateUser(User user,String key) throws UserException, LoginException ;
//	public Product addProduct (Product product)throws ProductException;
//	public Product updateProduct (Product product)throws ProductException;
//	public Product deleteProduct (Integer pId)throws ProductException;
//	

}
