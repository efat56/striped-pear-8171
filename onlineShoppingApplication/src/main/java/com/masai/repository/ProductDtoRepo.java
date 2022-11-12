package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.dto.ProductDTO;
@Repository
public interface ProductDtoRepo extends JpaRepository<ProductDTO, Integer> {

}
