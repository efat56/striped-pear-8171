package com.masai.exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;





@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyError> getAddressException(AddressException ae,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(), ae.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyError> getCartException(CartException ae,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(), ae.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyError> getCategoryException(CategoryException ae,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(), ae.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyError> getCustomerException(CustomerException ae,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(), ae.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyError> getOrderException(OrderException ae,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(), ae.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyError> getProductException(ProductException ae,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(), ae.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyError> getLoginException(LoginException ae,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(), ae.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> mymnvfError(MethodArgumentNotValidException m){
		
		MyError mr=new MyError(LocalTime.now(), m.getMessage(), m.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> noException(NoHandlerFoundException noh,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(),noh.getMessage(),req.getDescription(false));

	return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);	
	}
}
