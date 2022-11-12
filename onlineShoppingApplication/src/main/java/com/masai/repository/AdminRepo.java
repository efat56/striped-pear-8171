package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.AdminPannel;


@Repository
public interface AdminRepo extends JpaRepository<AdminPannel, Integer> {
	
	public AdminPannel findByFirstName(String name);

}
