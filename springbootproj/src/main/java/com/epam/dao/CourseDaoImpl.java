package com.epam.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.epam.dto.CourseDto;
import com.epam.exception.CourseNotFoundException;

@Repository
public class CourseDaoImpl implements CourseDao {

	static List<CourseDto> courses = new ArrayList<>();
	
	static {
		CourseDto c1 = new CourseDto();
		c1.setCourseId(1000);
		c1.setCourseName("Spring MVC");
		c1.setCourseDuration("16 hours");

		CourseDto c2 = new CourseDto();
		c2.setCourseId(1001);
		c2.setCourseName("Spring");
		c2.setCourseDuration("8 hours");

		courses.add(c1);
		courses.add(c2);
	}

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

	@Override
	public CourseDto getCourseById(int courseId) {

		Optional<CourseDto> optionalCourse = courses.stream().filter(course -> course.getCourseId() == courseId)
				.findAny();
		return optionalCourse.orElseThrow(() -> new CourseNotFoundException("Course is not available " + courseId));
	}

}
