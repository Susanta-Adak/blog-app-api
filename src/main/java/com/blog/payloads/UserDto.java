package com.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	
	@NotEmpty
	@Size(min=4, max = 12, message = "Name not valid.")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	@Size(min = 8, message = "Password not valid.")
	@Pattern(regexp = "^(?=.*[\\w])(?=.*[\\W])[\\w\\W]{8,}$", message = "Password not match.")
	private String password;
	
	@NotEmpty
	private String about;
	
}
