package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.ProductDTO;
import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cService;
	

    @PostMapping("/carts")
    public ResponseEntity<Cart> addToCart(@RequestParam Integer productId , 
    									  @RequestParam Integer quantity,
    									  @RequestParam String key) throws CartException, LoginException, ProductException, CustomerException{

        Cart cartItem = cService.addProductToCart(productId, quantity, key) ;

        return new ResponseEntity<>(cartItem, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/carts")
    public ResponseEntity<List<ProductDTO>> getAllProductInCart(@RequestParam String key) throws CartException, LoginException {
    	
    	List<ProductDTO> list = cService.viewAllProducts(key) ;
    	
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/carts") 
    public ResponseEntity<List<ProductDTO>> removeAProductFromCart(@RequestParam Integer productId , 
    									      		   @RequestParam String key) throws CartException, ProductException, LoginException {
    	
    	List<ProductDTO> list =cService.removeProductFromCart(productId, key);
    	
    	return new ResponseEntity<>(list, HttpStatus.OK);
    	
    }
    
    @PutMapping("/carts") 
    public ResponseEntity<List<ProductDTO>> updateProductQuantity(
												    		  @RequestParam Integer productId , 
															  @RequestParam Integer quantity,
															  @RequestParam String key) throws CartException, LoginException, ProductException {
    
    	List<ProductDTO> list = cService.updateProductQuantity(productId, quantity, key);
    	
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/cart")
    public ResponseEntity<Cart> removeAllProducts(@RequestParam String key) throws CartException, LoginException {
    	Cart cart = cService.removeAllProducts(key);
    	
    	return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    

}
