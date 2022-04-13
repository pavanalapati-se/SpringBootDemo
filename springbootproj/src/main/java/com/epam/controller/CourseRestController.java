package com.epam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.CourseDto;
import com.epam.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseRestController {

//	@Autowired
//	private CourseService courseService;
//
//	@GetMapping
//	public List<CourseDto> findAllCourses() {
//		return courseService.getAllCourses();
//	}
//
//	@PostMapping
//	public ResponseEntity<CourseDto> insert(@RequestBody@Valid CourseDto courseDto) {
//		return new ResponseEntity<CourseDto>(courseService.createCourse(courseDto), HttpStatus.CREATED);
//	}
//
//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<CourseDto> get(@PathVariable("id") int courseId) {
//		return new ResponseEntity<CourseDto>(courseService.searchCourse(courseId), HttpStatus.OK);
//	}
	
	
}
