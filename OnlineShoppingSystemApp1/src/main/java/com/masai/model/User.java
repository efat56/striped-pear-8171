package com.masai.model;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	
	@NotNull(message = "User Id can't be null..And user Id is same as Customer Mobile Number")
	
	private String userId;
	
	@Size(min = 6,max = 12,message = "Password should contain minimum 6 and max 12 character")
	private String password;
	
	@NotNull(message = "Please, Enter your role!")
	
	private String role;
}
