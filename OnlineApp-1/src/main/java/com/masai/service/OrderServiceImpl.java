package com.masai.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.AddressDTO;
import com.masai.dto.OrderDTO;
import com.masai.dto.ProductDTO;
import com.masai.exception.AddressException;
import com.masai.exception.CartException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderException;
import com.masai.exception.ProductException;
import com.masai.model.Address;
import com.masai.model.Cart;
import com.masai.model.CurrentUsersSession;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.repository.AddressDAO;
import com.masai.repository.CartDAO;
import com.masai.repository.CustomerDAO;
import com.masai.repository.OrderDAO;
import com.masai.repository.SessionDAO;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO oDao;
	
	@Autowired
	private SessionDAO sDao;
	
	@Autowired
	private CustomerDAO cDao;
	
	@Autowired
	private CartDAO caDao;
	
	@Autowired
	private AddressDAO aDao;

	@Override
	public Orders addOrder(OrderDTO order, String key) throws OrderException, CartException, LoginException,ProductException {
		
		CurrentUsersSession optcurrentuser=sDao.findByUuid(key);
		
		if(optcurrentuser!=null)
		{
              Integer customerId =optcurrentuser.getUserId();
			 
			 Optional<Customer> ourCustomer = cDao.findById(customerId);
			 
			 List<Address> ad = ourCustomer.get().getAddresses();
			 
			 Address addr=ad.get(0);
			 Orders currOrder = new Orders();
			 
			 currOrder.setOrderDate(order.getOrderDate());
			 AddressDTO adto=new AddressDTO(addr.getStreetNo(), addr.getHouseNumber(), addr.getCity(), addr.getState(), addr.getCountry(), addr.getPincode());
			currOrder.setOrderAddress(adto);
			 
			 currOrder.setCustomer(ourCustomer.get());
			 currOrder.setOrderStatus("Order confirmed");
			 
			 
			 Cart ca=caDao.findByCustomer(ourCustomer.get());
			 
			 List<ProductDTO> products=ca.getProducts();
			 if(products.size()==0) {
				 throw new ProductException("Products not prsent");
			 }
			 
			 
			 List<ProductDTO> productList = new ArrayList<>();

			 Double total = 0.0 ;
			 
			 for(ProductDTO proDto : products) {
				 
				 productList.add(proDto);
				 
				 total += (proDto.getPrice() * proDto.getQuantity()) ;
				 
			 }
			 
			 currOrder.setTotal(total);	
			 currOrder.setProductList(productList); 
			 
			 Cart customerCart = caDao.findByCustomer(ourCustomer.get()) ;
			 
			 customerCart.setProducts(new ArrayList<>());
			 
			 caDao.save(customerCart);
			 
			 return oDao.save(currOrder);
			 
		 }
		 else {
			 throw new LoginException("Login first");
		 }
		
		
	}

	@Override
	public Orders updateOrder(OrderDTO order, String key,Integer orderId) throws OrderException, LoginException {

		CurrentUsersSession optcurrentuser=sDao.findByUuid(key);
		if(optcurrentuser==null) {
			throw new LoginException("User not found "+key);
		}else {
			Optional<Orders> o=oDao.findById(orderId);
			if(o.isPresent()) {
				o.get().setOrderDate(order.getOrderDate());
				Orders ord=o.get();
				Orders or=oDao.save(ord);
				return or;
			}else {
				throw new OrderException("Order not found");
			}
			
		}
	}

	@Override
	public Orders removeOrder(Integer oriderId, String key) throws OrderException,LoginException {
		
		CurrentUsersSession optcurrentuser=sDao.findByUuid(key);
		if(optcurrentuser==null) {
			throw new LoginException("User not found "+key);
		}else {
		
		Orders existingorder=oDao.findById(oriderId).orElseThrow(()-> new OrderException("Order does not exist with this id"));
		oDao.delete(existingorder);
		return existingorder;
		}
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {

		Optional<Orders> optorder=oDao.findById(orderId);
		
		if(optorder.isEmpty())
		{
			throw new OrderException("No order found with this Id");
		}
		
		
		Orders order=optorder.get();
		return order;
		
	}

	@Override
	public List<Orders> viewAllOrdersByDate(String date) throws OrderException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		

		  //convert String to LocalDate
		  LocalDate localDate = LocalDate.parse(date, formatter);
		
		List<Orders> orders= oDao.findByOrderDate(localDate);
		
		if(orders.size()>0) {
			
			return orders;
		}
		else {
			throw new OrderException("Order doesn't exist on this date.");
		}
	}

	@Override
	public List<Orders> viewAllOrdersByLocation(String city) throws OrderException, AddressException {

		
		List<Orders> olist=oDao.getOrderByCity(city);
		
		if(olist.size()==0) {
			throw new AddressException("Order not found"+city);
		}else {
			
			return olist;
		}
		
		
	}

	@Override
	public List<Orders> viewAllOrdersByUserId(Integer userid) throws OrderException {

		List<Orders> olist=oDao.getOrdersByuserId(userid);
		
		if(olist.size()==0) {
		
			throw new OrderException("User not found"+userid);
		}
		return olist;
	}

	
	
	
}
