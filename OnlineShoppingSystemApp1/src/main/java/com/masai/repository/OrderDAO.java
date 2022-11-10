package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Order;
@Repository
public interface OrderDAO extends JpaRepository<Order, Integer>{

	public List<Order> findByOrderDate(LocalDate date);
	
}
