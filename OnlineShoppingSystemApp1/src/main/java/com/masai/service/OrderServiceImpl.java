package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.model.Order;
import com.masai.repository.OrderDAO;
@Service
public class OrderServiceImpl implements OrderService{

	private OrderDAO oDao;
	@Override
	public Order addOrder(Order order) throws OrderException {

		Order o=oDao.save(order);
		if(o==null) {
			throw new OrderException("Order not saved");
		}
		
		return o;
	}

	@Override
	public Order updateOrder(Order order) throws OrderException {
		
		Optional<Order> opt=oDao.findById(order.getOrderId());
		if(opt.isPresent()) {
			Order o=opt.get();
			o=order;
			return o;
		}else {
			throw new OrderException("Order is not found"+order.getOrderId());
		}

	}

	@Override
	public Order removeOrder(Order order) throws OrderException {
		Optional<Order> opt=oDao.findById(order.getOrderId());
		if(opt.isPresent()) {
			Order o=opt.get();
			oDao.delete(o);
			return o;
		}else {
			throw new OrderException("Order is not found"+order.getOrderId());
		}
	}

	@Override
	public Order viewOrder(Order order) throws OrderException {
		Optional<Order> opt=oDao.findById(order.getOrderId());
		if(opt.isPresent()) {
			Order o=opt.get();
			return o;
		}else {
			throw new OrderException("Order is not found"+order.getOrderId());
		}
	}

	@Override
	public List<Order> viewAllOrders(LocalDate date) throws OrderException {
		
		List<Order> orders=oDao.findByOrderDate(date);
		
		if(orders.size()==0) {
			throw new OrderException("Orders are not available"+date);
		}
		return orders;
	}

	@Override
	public List<Order> viewAllOrdersByLocation(String loc) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> viewAllOrdersByUserId(Integer userId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
