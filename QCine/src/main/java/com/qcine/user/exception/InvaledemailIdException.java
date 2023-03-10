package com.qcine.user.exception;

import lombok.Data;

@Data
public class InvaledemailIdException  extends RuntimeException
{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private String resourceName;

    public InvaledemailIdException(String resourceName) {
	    super(resourceName+" "+"Inavaled Email Id ");
	this.resourceName = resourceName;
}
	

	
}
