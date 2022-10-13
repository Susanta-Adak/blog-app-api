package com.blog.exceptions;

import lombok.Data;

@Data
public class AuthenticationException extends RuntimeException{
	private String username;
	private String password;
	public AuthenticationException(String username, String password) {
		super(String.format("Invalid password."));
		this.username = username;
		this.password = password;
	}
}
