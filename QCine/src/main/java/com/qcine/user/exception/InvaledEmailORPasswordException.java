package com.qcine.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@Data
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InvaledEmailORPasswordException extends RuntimeException
{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldNmae;
	private Object fieldValue;
	public InvaledEmailORPasswordException(String resourceName, String fieldNmae, Object fieldValue) {
		super(resourceName+"Inavaled Email or Password");
		this.resourceName = resourceName;
		this.fieldNmae = fieldNmae;
		this.fieldValue = fieldValue;
	}
	
	
	

}
