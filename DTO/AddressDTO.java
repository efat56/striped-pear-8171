package com.masai.DTO;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

	@Size(min = 3, max = 10, message = "Street no. should min of 3 and max of 10 Characters")
	private String streetNo;
	
	private String buildingName;
	
	@NotNull(message = "City cannot be null.")
	private String city;
	
	@NotNull(message = "State cannot be null.")
	private String state;
	
	@NotNull(message = "Country cannot be null.")
	private String country;
	
	@Size(min = 6, max = 6, message = "Enter a valid pincode only")
	private String pincode;

	
	
}
