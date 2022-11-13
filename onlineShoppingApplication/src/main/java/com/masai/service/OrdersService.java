package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.exception.AddressException;
import com.masai.exception.CartException;
import com.masai.exception.OrdersException;
import com.masai.model.Orders;

public interface OrdersService {
	
	public Orders addOrder(Orders order, String key) throws OrdersException, CartException, LoginException;
	public Orders updateOrder(Orders order, String key) throws OrdersException, LoginException;
	public Orders removeOrder(Integer oriderId, String key) throws OrdersException;
	public Orders viewOrder(Integer orderId) throws OrdersException;
	public List<Orders> viewAllOrdersByDate(LocalDate date) throws OrdersException;
	public List<Orders> viewAllOrdersByLocation(String city) throws OrdersException, AddressException;
	public List<Orders> viewAllOrdersByUserId(String userid) throws OrdersException;

}
