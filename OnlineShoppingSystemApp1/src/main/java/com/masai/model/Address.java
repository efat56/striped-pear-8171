package com.masai.model;


import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@Size(min = 3, message = "Street no. should min of 3 Characters")
	private String streetNo;
	
	private String buildingName;
	
	@NotNull(message = "City cannot be null.")
	private String city;
	
	@NotNull(message = "State cannot be null.")
	private String state;
	
	@NotNull(message = "Country cannot be null.")
	private String country;
	
	@Size(min = 6, max = 6, message = "Pincode Enter a valid Pincode ")
	private String pincode;

	@Override
	public int hashCode() {
		return Objects.hash(addressId, buildingName, city, country, pincode, state, streetNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(buildingName, other.buildingName)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(state, other.state)
				&& Objects.equals(streetNo, other.streetNo);
	}

	
	
	
}
