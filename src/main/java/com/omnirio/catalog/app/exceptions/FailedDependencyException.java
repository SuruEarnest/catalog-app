package com.omnirio.catalog.app.exceptions;

public class FailedDependencyException extends RuntimeException{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FailedDependencyException(String message) {
	        super(message);
	    }
}
