package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Category;
@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>{

	public Category findByCategoryName(String categoryName);
}
