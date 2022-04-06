package com.epam.exception;

public class CourseNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4336701910590483004L;

	public CourseNotFoundException(String message) {
		super(message);
	}
}
