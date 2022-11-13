package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repository.CategoryDAO;
import com.masai.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO pDao;
	
	@Autowired
	private CategoryDAO cDao;
	@Override
	public Product addProduct(Product product) throws ProductException {
		
		Product p=pDao.save(product);
		if(p==null) {
			throw new ProductException("Product not saved "+product.getProductName());
		}else {
			return p;
		}
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {

		Optional<Product> p=pDao.findById(product.getProductId());
		if(p.isPresent()) {
			Product pro=pDao.save(product);
			return pro;
		}else {
			throw new ProductException("product not found "+product.getProductId());
		}
		
	}

	@Override
	public Product viewProduct(Integer productId) throws ProductException {
		Optional<Product> p=pDao.findById(productId);
		if(p.isPresent()) {
			
			return p.get();
		}else {
			throw new ProductException("product not found "+productId );
		}
	}

	@Override
	public Product removeProduct(Integer productId) throws ProductException {
		
		Optional<Product> p=pDao.findById(productId);
		if(p.isPresent()) {
			Product pro=p.get();
			pDao.delete(pro);
			return pro;
		}else {
			throw new ProductException("product not found "+productId );
		}
	}

	@Override
	public List<Product> viewProductByCategory(String cName) throws CategoryException, ProductException {

		Category c=cDao.findByCategoryName(cName);
		
		if(c!=null) {
			List<Product> p=pDao.findByCategory(c);
			if(p.size()==0) {
				throw new ProductException("product not found "+cName);
			}
			return p;
		}else {
			throw new CategoryException("product not found "+cName);
		}

		
		
		
	}

	@Override
	public List<Product> viewAllProduct() throws ProductException {
		
		List<Product> plist=pDao.findAll();
		if(plist.size()==0) {
			throw new ProductException("product not found");
		}
		return plist;
	}

}
