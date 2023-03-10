package com.qcine.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ImageFilleNotFoundException  extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String resourceName;
	public ImageFilleNotFoundException(String resourceName) {
		super(resourceName+" file not found ");
		this.resourceName = resourceName;
	}
    
}
