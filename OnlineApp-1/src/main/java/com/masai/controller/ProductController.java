package com.masai.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CategoryException;
import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService pService;
	@PostMapping("/products")
	public ResponseEntity<Product> registerProduct(@Valid @RequestBody Product pro) throws ProductException{
		
		Product p=pService.addProduct(pro);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product pro) throws ProductException{
		
		Product p=pService.updateProduct(pro);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
		
	}

	@DeleteMapping("/products")
	public ResponseEntity<Product> removeProduct(@RequestParam Integer productId) throws ProductException{
		
		Product p=pService.removeProduct(productId);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	@GetMapping("/getproduct")
	public ResponseEntity<Product> viewProduct(@RequestParam Integer productId) throws ProductException{
		
		Product p=pService.viewProduct(productId);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	@GetMapping("/products")
	public ResponseEntity<List<Product>> viewAllProduct() throws ProductException{
		
		List<Product> plist=pService.viewAllProduct();
		
		return new ResponseEntity<List<Product>>(plist, HttpStatus.OK);
	}
	@GetMapping("/products/{category}")
	public ResponseEntity<List<Product>> viewByCategory(@PathVariable("category") String category) throws CategoryException, ProductException{
		
		
		List<Product> plist=pService.viewProductByCategory(category);
		return new ResponseEntity<List<Product>>(plist, HttpStatus.OK);
	}
}
