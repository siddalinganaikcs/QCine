package com.qcine.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ImageNotUploaded extends RuntimeException

 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	
	public ImageNotUploaded(String resourceName) {
		super(resourceName+" not uploaded pls try again");
		this.resourceName = resourceName;
	}
	
	

}
