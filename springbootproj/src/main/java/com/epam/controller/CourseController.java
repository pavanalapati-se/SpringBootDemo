package com.epam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.CourseDto;
import com.epam.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public ModelAndView loadCoursesPage() {

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
	public ModelAndView addCourse(@Valid @ModelAttribute CourseDto courseDto, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();

		if (result.hasErrors()) {
			modelAndView.setViewName("addCourse");
		} else {
			courseService.createCourse(courseDto);
			modelAndView.setViewName("success");
		}

		return modelAndView;
	}
}
