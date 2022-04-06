package com.epam.dao;

import java.util.List;

import com.epam.dto.CourseDto;

public interface CourseDao {

	public List<CourseDto>  getCourses();
	
	public CourseDto save(CourseDto courseDto);
	
	public CourseDto getCourseById(int courseId);
}
