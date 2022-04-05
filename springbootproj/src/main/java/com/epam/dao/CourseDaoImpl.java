package com.epam.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.dto.CourseDto;

@Repository
public class CourseDaoImpl implements CourseDao{

	
	List<CourseDto> courses = new ArrayList<>();
	
	@Override
	public List<CourseDto> getCourses() {
		
		CourseDto c1 = new CourseDto();
		c1.setCourseId(100);
		c1.setCourseName("Spring MVC");
		c1.setCourseDuration("16 hours");
		
		CourseDto c2 = new CourseDto();
		c2.setCourseId(101);
		c2.setCourseName("Spring");
		c2.setCourseDuration("8 hours");
		
		courses.add(c1);
		courses.add(c2);
		
		return courses;
	}

	@Override
	public CourseDto save(CourseDto courseDto) {
		courses.add(courseDto);
		return courseDto;
	}

}
