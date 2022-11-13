package com.masai.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminPannel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@Size(min = 3, max = 15, message = "First Name should be min 3 and max 15 Characters!")
	private String firstName;
	
	@Size(min = 1, max = 15, message = "Last Name should be min 1 and max 15 Characters!")
	private String lastName;
	
	
	@Size(min = 10, max = 10, message = "Mobile Number should contain 10 digit only!")
	private String mobileNumber;
	
	
	@Size(min = 8, max = 16, message = "Password must contain min 8 and max 16 digits!")
	private String password;
	
	@Email(message = "Please enter a valid email...")
	private String email;

}
