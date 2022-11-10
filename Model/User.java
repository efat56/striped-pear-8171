package com.masai.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	
	@NotNull(message = "User Id can't be null...")
	@NotBlank(message = "User Id cannot be blank.")
	@NotEmpty(message = "User Id cannot be empty.")
	private String userId;
	
	
	private String password;
	
	@NotNull(message = "Please, Enter your role!")
	@NotBlank(message = "Please, Enter your role!")
	@NotEmpty(message = "Please, Enter your role!")
	private String role;
}
