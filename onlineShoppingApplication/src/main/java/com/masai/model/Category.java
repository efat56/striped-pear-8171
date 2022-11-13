package com.masai.model;




import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

private Integer categoryId;
	
	@NotNull(message = "Category name can not be null.")
	@NotEmpty(message = "Category name can not be empty.")
	@NotBlank(message = "Category name can not be blank.")
	private String categoryName;

}
