package com.epam.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.epam.dto.ExceptionResponse;
import com.epam.exception.CourseNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	
	@ExceptionHandler(value = CourseNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleCourseNotFoundException(CourseNotFoundException exception,WebRequest request) {
		
		ExceptionResponse exRes = new ExceptionResponse();
		exRes.setError(exception.getMessage());
		exRes.setStatus(HttpStatus.BAD_REQUEST.name());
		exRes.setTimestamp(LocalDate.now().toString());
		exRes.setPath(request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exRes,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,WebRequest request){
		
		List<String> errors = new ArrayList<>();
		
		exception.getBindingResult().getAllErrors().forEach(error -> {
			errors.add(error.getDefaultMessage());
		});
		
		ExceptionResponse exRes = new ExceptionResponse();
		exRes.setError(errors.toString());
		exRes.setStatus(HttpStatus.BAD_REQUEST.name());
		exRes.setTimestamp(LocalDate.now().toString());
		exRes.setPath(request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exRes,HttpStatus.BAD_REQUEST);
	}
}
