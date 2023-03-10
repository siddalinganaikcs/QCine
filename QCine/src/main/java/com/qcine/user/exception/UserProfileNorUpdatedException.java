package com.qcine.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserProfileNorUpdatedException  extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private String resourceName;
	public UserProfileNorUpdatedException(String resourceName) {
		super("User Profile Not Updating pls try again");
		this.resourceName = resourceName;
	}
     
     
}
