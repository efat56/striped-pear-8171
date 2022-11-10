package com.masai.dto;


import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	
	@Override
	public int hashCode() {
		return Objects.hash(Id, color, dimension, manufacturer, price, productId, productName, quantity);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(color, other.color)
				&& Objects.equals(dimension, other.dimension) && Objects.equals(manufacturer, other.manufacturer)
				&& Objects.equals(price, other.price) && Objects.equals(productId, other.productId)
				&& Objects.equals(productName, other.productName) && Objects.equals(quantity, other.quantity);
	}


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	private Integer productId;
	
	private String productName;
	
	private Double price;
	
	
	private String color;
	
	private String dimension;
	
	private String manufacturer;
	
	
	private Integer quantity;


	
}
