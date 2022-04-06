package com.epam.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.epam.exception.CourseNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	
	@ExceptionHandler(value = CourseNotFoundException.class)
	public ModelAndView handleCourseNotFoundException(Exception exception) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",exception.getMessage());
		modelAndView.setViewName("error");
		
		return modelAndView;
	}
}
