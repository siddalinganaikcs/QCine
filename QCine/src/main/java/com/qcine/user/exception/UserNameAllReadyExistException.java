package com.qcine.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@ResponseStatus(value=HttpStatus.ALREADY_REPORTED)
@Data
public class UserNameAllReadyExistException  extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
      private String resourceName;
      private String fieldName;
      private Object  fieldValue;
	public UserNameAllReadyExistException(String resourceName, String fieldName, Object fieldValue) {
		super(resourceName+" " +" Is All Ready Exist/Invaled user " );
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
      
      
}
