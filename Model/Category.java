package com.masai.Model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	
	private Integer categoryID;
	
	
	@NotNull(message = "Category name can not be Null")
	@NotNull(message = "Category name can not be blanck")
	@NotNull(message = "Category name can not be empty")
	private String categoryName;
	
	
}
