package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.CourseDao;
import com.epam.dto.CourseDto;

@Service
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	
	public List<CourseDto> getAllCourses(){
		return courseDao.getCourses();
	}
	
	public CourseDto createCourse(CourseDto courseDto) {
		return courseDao.save(courseDto);
	}
	
	public CourseDto searchCourseById(int courseId) {
		return courseDao.getCourseById(courseId);
	}
}
