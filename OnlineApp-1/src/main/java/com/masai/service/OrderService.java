package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.dto.OrderDTO;
import com.masai.exception.AddressException;
import com.masai.exception.CartException;

import com.masai.exception.LoginException;
import com.masai.exception.OrderException;
import com.masai.exception.ProductException;
import com.masai.model.Orders;

public interface OrderService {

	
	public Orders addOrder(OrderDTO order, String key) throws OrderException, CartException, LoginException,ProductException;
	public Orders updateOrder(OrderDTO order, String key,Integer orderId) throws OrderException, LoginException;
	public Orders removeOrder(Integer oriderId, String key) throws OrderException,LoginException;
	public Orders viewOrder(Integer orderId) throws OrderException;
	public List<Orders> viewAllOrdersByDate(String date) throws OrderException;
	public List<Orders> viewAllOrdersByLocation(String city) throws OrderException, AddressException;
	public List<Orders> viewAllOrdersByUserId(Integer userid) throws OrderException;
}
