package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.exception.CartException;
import com.masai.exception.OrdersException;
import com.masai.model.Orders;
@Service
public class OrdersServiceImpl implements OrdersService {

	@Override
	public Orders addOrder(Orders order, String key) throws OrdersException, CartException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders updateOrder(Orders order, String key) throws OrdersException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders removeOrder(Integer oriderId, String key) throws OrdersException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrdersException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewAllOrdersByDate(LocalDate date) throws OrdersException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewAllOrdersByLocation(String city) throws OrdersException, AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewAllOrdersByUserId(String userid) throws OrdersException {
		// TODO Auto-generated method stub
		return null;
	}

}
