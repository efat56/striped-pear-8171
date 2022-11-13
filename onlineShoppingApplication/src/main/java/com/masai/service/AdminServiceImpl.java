package com.masai.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.AdminPannel;
import com.masai.model.Product;
import com.masai.model.User;
import com.masai.repository.CustomerRepo;
import com.masai.repository.ProductRepo;



//@Service
//public class AdminServiceImpl implements  {
//	@Autowired
//	private ProductRepo proRepo;
////	
//	@Autowired
//	private CustomerRepo cusRepo;
//
//	@Override
//	public User removeUser(User user, String key) throws UserException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User validateUser(User user, String key) throws UserException, LoginException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

//	@Override
//	public AdminPannel createAdmin(AdminPannel adPannel){
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Product addProduct(Product product) throws ProductException {
//		Product pro = proRepo.save(product);
//		return pro;
//	}
//
//	@Override
//	public Product updateProduct(Product product) throws ProductException {
//		Optional<Product> opt =   proRepo.findById(product.getProductId());
//		if(opt.isPresent()) {
//			return proRepo.save(product);
//		}
//		else {
//			throw new ProductException("Invalid Product Details.......");
//		}
//	}
//
//	@Override
//	public Product deleteProduct(Integer pId) throws ProductException {
//		Product	existingProduct = proRepo.findById(pId).orElseThrow(()->new ProductException("Product does not exist with id :"+pId));
//		
//		proRepo.delete(existingProduct);
//		
//		return existingProduct ;
//	}

//}
