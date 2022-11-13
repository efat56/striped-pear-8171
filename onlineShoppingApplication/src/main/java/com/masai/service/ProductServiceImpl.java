package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.repository.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo proRepo;

	@Override
	public List<Product> viewAllProducts() throws ProductException {
		List<Product> products=proRepo.findAll();
		if(products.size()>0) {
			return products;
		}
		else {
			throw new ProductException("Product is not Found.....");
		}
	}

	@Override
	public Product addProduct(Product product) throws ProductException {
        Product addedProduct=proRepo.save(product);
		
		return addedProduct;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		Optional<Product> opt =   proRepo.findById(product.getProductId());
		if(opt.isPresent()) {
			return proRepo.save(product);
		}
		else {
			throw new ProductException("Invalid Product Details");
		}
	}

	@Override
	public Product viewProduct(Integer id) throws ProductException {
		Optional<Product> opt =  proRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new ProductException("Product does not exist with id :"+id);
		}
	}

	@Override
	public List<Product> viewProductByCategory(String cname) throws ProductException {
		
        List<Product> products = proRepo.viewByCategoryName(cname);
		
		
		if(products.size()>0) {
			return products;
		}
		else {
			throw new ProductException("Product does not exist with Category Name :"+cname);
		}
	}

	@Override
	public Product removeProduct(Integer pid) throws ProductException {
		Product	existingProduct = proRepo.findById(pid).orElseThrow(()->new ProductException("Product does not exist with id :"+pid));
		
		proRepo.delete(existingProduct);
		
		return existingProduct ;
	}

}
