package com.masai.model;


import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
	
	@Size(min = 3, max = 15, message = "First Name should be min 3 and max 15 Characters!")
	private String firstName;
	
	@Size(min = 1, max = 15, message = "Last Name should be min 1 and max 15 Characters!")
	private String lastName;
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "c_address", joinColumns = @JoinColumn(name="customer_id", referencedColumnName = "customerId"))
	@Embedded
	private Address address;
	
	@Size(min = 10, max = 10, message = "Mobile Number should contain 10 digit only!")
	private String mobileNumber;
	
	
	@Size(min = 8, max = 16, message = "Password must contain min 8 and max 16 digits!")
	private String password;
	
	@Email(message = "Please enter a valid email...")
	private String email;
	
	@NotBlank(message = "role should not be blank...")
	@NotNull(message = "roll should not be blank...")
	@NotEmpty(message = "roll should not be blank...")
	private String role;
	
	

}
