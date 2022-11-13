package com.masai.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.ProductDTO;
import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.CurrentUsersSession;
import com.masai.model.Customer;
import com.masai.model.Product;
import com.masai.repository.CartDAO;
import com.masai.repository.CustomerDAO;
import com.masai.repository.ProductDAO;
import com.masai.repository.ProductDTODAO;
import com.masai.repository.SessionDAO;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO caDao;
	@Autowired
	private SessionDAO sDao;
	@Autowired
	private ProductDAO pDao;
	@Autowired
	private CustomerDAO cDao;
	@Autowired
	private ProductDTODAO proDao;

	
	@Override
	public Cart addProductToCart(Integer productId, int quantity, String key)
			throws CartException, LoginException, ProductException,CustomerException {
		System.out.println("swapnil");
		CurrentUsersSession optCurUser = sDao.findByUuid(key);
		if(optCurUser == null) {
			throw new LoginException("please login first");
		}
		
		Optional<Customer>  cus=cDao.findById(optCurUser.getUserId());
		if(cus.isPresent()) {
			Customer currentcutomer=cus.get();
			Optional<Product> optproduct=pDao.findById(productId);
			if(optproduct.isEmpty()) {
				throw new ProductException("Product if not found");
			}
	      Product currentproduct=optproduct.get();
	      if(currentproduct.getQuantity()<quantity) {
	    	  throw new ProductException("Product quantity not available");
	      }
			Cart customercart=caDao.findByCustomer(currentcutomer);
			if(customercart==null) {
				customercart=new Cart();
				customercart.setCustomer(currentcutomer);
				List<ProductDTO> list=customercart.getProducts();
				ProductDTO productdto=new ProductDTO(productId,currentproduct.getProductName(), currentproduct.getPrice(),currentproduct.getColor(),currentproduct.getDimension(), currentproduct.getManufacturer(), quantity);
			currentproduct.setQuantity(currentproduct.getQuantity()-quantity);
			list.add(productdto);
			pDao.save(currentproduct);
			caDao.save(customercart);
			return customercart;
			}
			else {
				List<ProductDTO> list=customercart.getProducts();
				ProductDTO productdto=new ProductDTO(productId,currentproduct.getProductName(),currentproduct.getPrice(), currentproduct.getColor(),currentproduct.getDimension(),currentproduct.getManufacturer(),quantity);
			currentproduct.setQuantity(currentproduct.getQuantity()-quantity);
			list.add(productdto);
			caDao.save(customercart);
			pDao.save(currentproduct);
			return customercart;
			
			}
		}else {
			throw new CustomerException("customer not found"+optCurUser.getUserId());
		}
		
		

	}

	@Override
	public List<ProductDTO> removeProductFromCart(Integer productId, String key)
			throws CartException, ProductException, LoginException {

		CurrentUsersSession optCurUser = sDao.findByUuid(key);
		if(optCurUser==null) {
			throw new LoginException("please login");
		}
		Optional<Customer> cus = cDao.findById(optCurUser.getUserId());
		Customer currentcutomer=cus.get();
	Optional<Product> optproduct=pDao.findById(productId);
	if(optproduct.isEmpty()) {
		throw new ProductException("product is not available");
	}
	Product currentproduct=optproduct.get();
	Cart customerCart=caDao.findByCustomer(currentcutomer);
	if(customerCart!=null) {
		List<ProductDTO> list=customerCart.getProducts();
		boolean flag=false;
		for(int i=0;i<list.size();i++) {
			ProductDTO productdto=list.get(i);
			if(productdto.getProductId()==productId) {
				pDao.deleteById(productId);
				flag=true;
				currentproduct.setQuantity(currentproduct.getQuantity()+productdto.getQuantity());
				pDao.save(currentproduct);
				list.remove(i);
				break;
			}
		}
		if(!flag) {
			throw new ProductException("there is no prduct with"+productId);
			
		}
		customerCart.setProducts(list);
		caDao.save(customerCart);
		return list;
	}
	else {
		throw new ProductException("Cart is Empty");
	}
	
		
	}

	@Override
	public List<ProductDTO> updateProductQuantity(Integer productId, Integer quantity, String key)
			throws CartException, LoginException, ProductException {

		CurrentUsersSession optCurUser =sDao.findByUuid(key);
		if(optCurUser==null) 
		{
			throw new LoginException("please login");
		}
		Optional<Customer> cus = cDao.findById(optCurUser.getUserId());
		Customer currentcutomer=cus.get();
	Optional<Product> optproduct=pDao.findById(productId);
	if(optproduct.isEmpty())
	{
		throw new ProductException("product is not available");
	}
	Product currentproduct=optproduct.get();
	if(currentproduct.getQuantity() < quantity) 
	{
		throw new ProductException("Product Out of stock") ;
	}
	
	Cart customerCart = caDao.findByCustomer(currentcutomer);
	if(customerCart!=null) 
	{
		List<ProductDTO> list=customerCart.getProducts();
		boolean flag=false;
		List<ProductDTO> updateList=new ArrayList<>();
		for(ProductDTO productdto:list)
		{
			if(productdto.getProductId()==productId)
			{
				flag=true;
				currentproduct.setQuantity(currentproduct.getQuantity()-quantity);
				pDao.save(currentproduct);
				productdto.setQuantity(productdto.getQuantity()+ quantity);
				ProductDTO pr=proDao.save(productdto);
				updateList.add(pr);
				break;
			}
		}
	
		if(!flag) {
			throw new ProductException("You have no product with productid"+productId);
		}
	       return updateList;
	}
	       
	       
	       else {
		throw new ProductException("You have no product in cart");
	}
	
	}

	@Override
	public Cart removeAllProducts(String key) throws CartException, LoginException {
		CurrentUsersSession optCurUser = sDao.findByUuid(key);
		if(optCurUser==null) 
		{
			throw new LoginException("please login");
		}
		Optional<Customer> cus = cDao.findById(optCurUser.getUserId());
		Customer currentcutomer=cus.get();
		Cart customerCart = caDao.findByCustomer(currentcutomer);
		List<ProductDTO> list=customerCart.getProducts();
		if(list.size()>0) {
			for(ProductDTO productdto:list) {
				Optional<Product> opt=pDao.findById(productdto.getProductId());
				Product currentproduct=opt.get();
				currentproduct.setQuantity(currentproduct.getQuantity()+productdto.getQuantity());
				proDao.delete(productdto);
				pDao.save(currentproduct);
			}
		}
		customerCart.setProducts(new ArrayList<>());
		return caDao.save(customerCart);
		
	}

	@Override
	public List<ProductDTO> viewAllProducts(String key) throws CartException, LoginException {

		CurrentUsersSession optCurUser = sDao.findByUuid(key);
		if(optCurUser==null) 
		{
			throw new LoginException("please login");
		}
		Optional<Customer> cus = cDao.findById(optCurUser.getUserId());
		Customer currentcutomer=cus.get();
		Cart customercart=caDao.findByCustomer(currentcutomer);
		if(currentcutomer==null) {
			throw new CartException("cart is empty");
		}
		return customercart.getProducts();
	
	}

}
