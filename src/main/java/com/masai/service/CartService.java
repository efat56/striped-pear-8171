package com.masai.service;

import java.util.List;

import com.masai.dto.ProductDTO;
import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;

public interface CartService {

    public Cart addProductToCart(Integer productId, int quantity,String key) throws CartException, LoginException, ProductException,CustomerException ;
	
	public List<ProductDTO> removeProductFromCart(Integer productId,String key) throws CartException, ProductException, LoginException  ;
	
	public List<ProductDTO> updateProductQuantity(Integer productId,Integer quantity,String key) throws CartException, LoginException, ProductException ;
	
	public Cart removeAllProducts(String key) throws CartException, LoginException ;
	
	public List<ProductDTO> viewAllProducts(String key)  throws CartException, LoginException;
	
}
