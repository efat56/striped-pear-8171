package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.ProductDTO;
import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.ProductException;
import com.masai.login.CurrentUserSession;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Product;
import com.masai.repository.CartRepo;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.CustomerRepo;
import com.masai.repository.ProductDtoRepo;
import com.masai.repository.ProductRepo;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CustomerRepo cust;
	
	@Autowired
	private ProductRepo prdrepo;
	
	@Autowired
	private ProductDtoRepo prddto;

	@Autowired
	private CurrentUserSessionRepo curUserSecRepo;
	@Autowired
	private CartRepo cartRepo;

	@Override
	public Cart addProductToCart(Integer productId, int quantity, String key)
			throws CartException, LoginException, ProductException,CustomerException {
		
		
       Optional<CurrentUserSession> optCurUser = curUserSecRepo.findByUuid(key);
		
		if(optCurUser == null) {
			throw new LoginException("please login first");
		}
		
		Optional<Customer> cus = cust.findById(optCurUser.get().getCurrentSessionId());
		Customer currentcutomer=cus.get();
		Optional<Product> optproduct=prdrepo.findById(productId);
		if(optproduct.isEmpty()) {
			throw new ProductException("Product if not found");
		}
      Product currentproduct=optproduct.get();
      if(currentproduct.getQuantity()<quantity) {
    	  throw new ProductException("Product quantity not available");
      }
		Cart customercart=cartRepo.findByCustomer(currentcutomer);
		if(customercart==null) {
			customercart=new Cart();
			customercart.setCustomer(currentcutomer);
			List<ProductDTO> list=customercart.getProducts();
			ProductDTO productdto=new ProductDTO(productId,currentproduct.getProductName(), currentproduct.getPrice(),currentproduct.getColor(),currentproduct.getDimension(), currentproduct.getManufacturer(), quantity);
		currentproduct.setQuantity(currentproduct.getQuantity()-quantity);
		list.add(productdto);
		cartRepo.save(customercart);
		prdrepo.save(currentproduct);
		return customercart;
		}
		
		else {
			List<ProductDTO> list=customercart.getProducts();
			ProductDTO productdto=new ProductDTO(productId,currentproduct.getProductName(),currentproduct.getPrice(), currentproduct.getColor(),currentproduct.getDimension(),currentproduct.getManufacturer(),quantity);
		currentproduct.setQuantity(currentproduct.getQuantity()-quantity);
		list.add(productdto);
		cartRepo.save(customercart);
		prdrepo.save(currentproduct);
		return customercart;
		
		}

		
	
	}

	@Override
	public List<ProductDTO> removeProductFromCart(Integer productId, String key)
			throws CartException, ProductException, LoginException {
		Optional<CurrentUserSession> optCurUser = curUserSecRepo.findByUuid(key);
		if(optCurUser.isEmpty()) {
			throw new LoginException("please login");
		}
		Optional<Customer> cus = cust.findById(optCurUser.get().getCurrentSessionId());
		Customer currentcutomer=cus.get();
	Optional<Product> optproduct=prdrepo.findById(productId);
	if(optproduct.isEmpty()) {
		throw new ProductException("product is not available");
	}
	Product currentproduct=optproduct.get();
	Cart customerCart=cartRepo.findByCustomer(currentcutomer);
	if(customerCart!=null) {
		List<ProductDTO> list=customerCart.getProducts();
		boolean flag=false;
		for(int i=0;i<list.size();i++) {
			ProductDTO productdto=list.get(i);
			if(productdto.getProductId()==productId) {
				prddto.deleteById(productId);
				flag=true;
				currentproduct.setQuantity(currentproduct.getQuantity()+productdto.getQuantity());
				prdrepo.save(currentproduct);
				list.remove(i);
				break;
			}
		}
		if(!flag) {
			throw new ProductException("there is no prduct with"+productId);
			
		}
		customerCart.setProducts(list);
		cartRepo.save(customerCart);
		return list;
	}
	else {
		throw new ProductException("Cart is Empty");
	}

	}

	@Override
	public List<ProductDTO> updateProductQuantity(Integer productId, Integer quantity, String key)
			throws CartException, LoginException, ProductException {
		Optional<CurrentUserSession> optCurUser = curUserSecRepo.findByUuid(key);
		if(optCurUser.isEmpty()) 
		{
			throw new LoginException("please login");
		}
		Optional<Customer> cus = cust.findById(optCurUser.get().getCurrentSessionId());
		Customer currentcutomer=cus.get();
	Optional<Product> optproduct=prdrepo.findById(productId);
	if(optproduct.isEmpty())
	{
		throw new ProductException("product is not available");
	}
	Product currentproduct=optproduct.get();
	if(currentproduct.getQuantity() < quantity) 
	{
		throw new ProductException("Product Out of stock") ;
	}
	
	Cart customerCart = cartRepo.findByCustomer(currentcutomer);
	if(customerCart!=null) 
	{
		List<ProductDTO> list=customerCart.getProducts();
		boolean flag=false;
		for(ProductDTO productdto:list)
		{
			if(productdto.getProductId()==productId)
			{
				flag=true;
				currentproduct.setQuantity(productdto.getQuantity()+ quantity);
				prdrepo.save(currentproduct);
				prddto.save(productdto);
				break;
			}
		}
	
		if(!flag) {
			throw new ProductException("You have no product with productid"+productId);
		}
	       return list;
	}
	       
	       
	       else {
		throw new ProductException("You have no product in cart");
	}
	}

	@Override
	public Cart removeAllProducts(String key) throws CartException, LoginException {
		Optional<CurrentUserSession> optCurUser = curUserSecRepo.findByUuid(key);
		if(optCurUser.isEmpty()) 
		{
			throw new LoginException("please login");
		}
		Optional<Customer> cus = cust.findById(optCurUser.get().getCurrentSessionId());
		Customer currentcutomer=cus.get();
		Cart customerCart = cartRepo.findByCustomer(currentcutomer);
		List<ProductDTO> list=customerCart.getProducts();
		if(list.size()>0) {
			for(ProductDTO productdto:list) {
				Optional<Product> opt=prdrepo.findById(productdto.getProductId());
				Product currentproduct=opt.get();
				currentproduct.setQuantity(currentproduct.getQuantity()+productdto.getQuantity());
				prddto.delete(productdto);
				prdrepo.save(currentproduct);
			}
		}
		customerCart.setProducts(new ArrayList());
		return cartRepo.save(customerCart);
	}

	@Override
	public List<ProductDTO> viewAllProducts(String key) throws CartException, LoginException {
		Optional<CurrentUserSession> optCurUser = curUserSecRepo.findByUuid(key);
		if(optCurUser.isEmpty()) 
		{
			throw new LoginException("please login");
		}
		Optional<Customer> cus = cust.findById(optCurUser.get().getCurrentSessionId());
		Customer currentcutomer=cus.get();
		Cart customercart=cartRepo.findByCustomer(currentcutomer);
		if(currentcutomer==null) {
			throw new CartException("cart is empty");
		}
		return customercart.getProducts();
	}

	}

	


	

