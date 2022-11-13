package com.masai.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.ProductDTO;
import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	
	
	
	 //public Cart addProductToCart(Integer productId, int quantity,String key) throws CartException, LoginException, ProductException,CustomerException ;
//	@PutMapping("/cart/{proId}/{qua}/{key}")
//	public Cart addProductToCartHandler(@PathVariable("proId")Integer productId, @PathVariable("qua") Integer quantity, @PathVariable("key")String key) throws LoginException, CartException, ProductException, CustomerException{
//		
//		Cart cart = cartService.addProductToCart(productId, quantity,key);
//		
//	     return cart;
//		
//	}
		
//		public List<ProductDTO> removeProductFromCart(Integer productId,String key) throws CartException, ProductException, LoginException  ;
		
//		public List<ProductDTO> updateProductQuantity(Integer productId,Integer quantity,String key) throws CartException, LoginException, ProductException ;
		
//		public Cart removeAllProducts(String key) throws CartException, LoginException ;
		
//		public List<ProductDTO> viewAllProducts(String key)  throws CartException, LoginException;
	
	
	
	
	 @PostMapping("/add")
	    public ResponseEntity<Cart> addToCart(@RequestParam Integer productId ,@RequestParam Integer quantity, @RequestParam String key)
	    									  
	    									   throws CartException, LoginException, ProductException, CustomerException{
	    	

	        Cart cItem = cartService.addProductToCart(productId, quantity, key) ;

	        return new ResponseEntity<Cart>(cItem, HttpStatus.ACCEPTED);

}
}
