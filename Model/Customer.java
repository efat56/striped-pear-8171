package com.masai.Model;


import java.util.Set;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Email;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@Size(min = 3, message = "First Name should be min 3  Characters!")
	private String firstName;
	
	@Size(min = 1,message = "Last Name should be min 1 Characters!")
	private String lastName;
	
	@Size(min = 10, max = 10, message = "Enter a valid Mobile Number!")
	private String mobileNumber;
	
	
	@Size(min = 8, max = 16, message = "Password must contain min 8 and max 16 digits!")
	private String customerpassword;
	
	@Email(message = "Please enter a valid email...")
	private String customeremail;
	
	@ElementCollection
	private Set<Address> address;

	
	
	
	
}
