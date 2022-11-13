package com.masai.service;

import java.util.List;

import com.masai.exception.ProductException;
import com.masai.model.Product;

public interface ProductService {
	
	
	public Product removeProduct(Integer pid)throws ProductException;
	public Product addProduct(Product product) throws ProductException;
	public Product updateProduct(Product product) throws ProductException;
	public Product viewProduct(Integer id) throws ProductException;
	public List<Product> viewProductByCategory(String cname) throws ProductException;
	
	public List<Product> viewAllProducts() throws ProductException;

}
