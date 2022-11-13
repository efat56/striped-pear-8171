package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.OrderDTO;
import com.masai.exception.AddressException;
import com.masai.exception.CartException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderException;
import com.masai.exception.ProductException;
import com.masai.model.Orders;
import com.masai.service.OrderService;

@RestController
public class OrderController {
	
	
	@Autowired
	private OrderService oService;
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> registerOrder(@Valid @RequestBody OrderDTO order,@RequestParam String key) throws OrderException, CartException, LoginException, ProductException{
		
		Orders o=oService.addOrder(order, key);
		
		return new ResponseEntity<Orders>(o,HttpStatus.CREATED);
	}
	
	@PutMapping("/orders")
	public ResponseEntity<Orders> updateOrder(@Valid @RequestBody OrderDTO order,@RequestParam String key,@RequestParam Integer orderId) throws OrderException, LoginException{
		
		Orders o=oService.updateOrder(order, key,orderId);
		
		return new ResponseEntity<Orders>(o, HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Orders> removeOrder(@PathVariable("id") Integer id,@RequestParam String key) throws OrderException, LoginException{
		Orders o=oService.removeOrder(id, key);
		
		return new ResponseEntity<Orders>(o, HttpStatus.OK);
	}
	@GetMapping("/orders/{orderid}")
	public ResponseEntity<Orders> viewOrder(@PathVariable("orderid") Integer id) throws OrderException{
		
		Orders o=oService.viewOrder(id);
		
		return new ResponseEntity<Orders>(o, HttpStatus.OK);

	}

	@GetMapping("/getorders")
	public ResponseEntity<List<Orders>> viewAllOrder(@RequestParam String date) throws OrderException{
		
		List<Orders> olist=oService.viewAllOrdersByDate(date);
		
		return new ResponseEntity<List<Orders>>(olist, HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> viewAllOrders(@RequestParam String city) throws OrderException, AddressException{
		
		List<Orders> olist=oService.viewAllOrdersByLocation(city);
		
		return new ResponseEntity<List<Orders>>(olist, HttpStatus.OK);
	}
	
	@GetMapping("/listorders/{userid}")
	public ResponseEntity<List<Orders>> viewAllOrders(@PathVariable("userid") Integer userId) throws OrderException, AddressException{
		
		List<Orders> olist=oService.viewAllOrdersByUserId(userId);
		
		return new ResponseEntity<List<Orders>>(olist, HttpStatus.OK);
	}
}
