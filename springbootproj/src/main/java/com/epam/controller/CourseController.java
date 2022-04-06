package com.epam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.CourseDto;
import com.epam.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public ModelAndView loadCoursesPage(HttpServletRequest request) {

		List<CourseDto> courses = courseService.getAllCourses();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("courses", courses);
		
		modelAndView.setViewName("viewCourses");

		return modelAndView;

	}
	
	@GetMapping("loadaddcoursepage")
	public ModelAndView loadAddCoursePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("courseDto", new CourseDto());
		modelAndView.setViewName("addCourse");
		return modelAndView;
	}

	@PostMapping(value = "addcourse")
	public ModelAndView addCourse(@Valid @ModelAttribute CourseDto courseDto, BindingResult result,HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		if (result.hasErrors()) {
			modelAndView.setViewName("addCourse");
		} else {
			
			courseService.createCourse(courseDto);
			modelAndView.setViewName("success");
		}

		return modelAndView;
	}
	@GetMapping("/courses/{id}")
	public ModelAndView loadCourseBasedOnId(@PathVariable("id") int courseId) {
		
		CourseDto  courseDto  = courseService.searchCourseById(courseId);
		
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.addObject("course", courseDto);
		modelAndView.setViewName("viewCourse");
		return modelAndView;
	}
}
