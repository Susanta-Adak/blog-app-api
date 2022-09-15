package com.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer ctegoryId;
	@NotEmpty
	@Size(min = 4, message = "Category Title not valid.")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min = 4, message = "Category Description not valid.")
	private String categoryDescription;
}
