package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.OrderException;
import com.masai.model.Order;

public interface OrderService {
	
	
	public Order addOrder(Order order)throws OrderException;
	public Order updateOrder(Order order)throws OrderException;
	public Order removeOrder(Order order)throws OrderException;
	public Order viewOrder(Order order)throws OrderException;
	public List<Order> viewAllOrders(LocalDate date)throws OrderException;
	public List<Order> viewAllOrdersByLocation(String loc)throws OrderException;
	public List<Order> viewAllOrdersByUserId(Integer userId)throws OrderException;
	
	

}
