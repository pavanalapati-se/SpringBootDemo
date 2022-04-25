package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.CourseDto;
import com.epam.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseRestController {

	@Autowired
	private CourseService courseService;

	@GetMapping()
	public ResponseEntity<List<CourseDto>> fetchCourses() {
		return ResponseEntity.ok().body(courseService.getAllCourses());
	}

	@PostMapping
	public ResponseEntity<CourseDto> insert(@RequestBody @Valid CourseDto courseDto,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.getId();
		return new ResponseEntity<CourseDto>(courseService.createCourse(courseDto), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<CourseDto> update(@RequestBody CourseDto courseDto) {
		return new ResponseEntity<CourseDto>(courseService.updateCourse(courseDto), HttpStatus.OK);
	}

	@GetMapping("/{courseid}")
	public ResponseEntity<CourseDto> fecth(@PathVariable("courseid") int courseId) {
		return new ResponseEntity<CourseDto>(courseService.searchCourse(courseId), HttpStatus.OK);
	}

	@DeleteMapping("/{courseid}")
	public ResponseEntity<String> delete(@PathVariable("courseid") int courseId) {
		courseService.deleteCourse(courseId);
		return new ResponseEntity<String>("Course Deleted Succesfully", HttpStatus.NO_CONTENT);
	}
}
