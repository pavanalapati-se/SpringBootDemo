package com.epam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.CourseRepository;
import com.epam.dto.CourseDto;
import com.epam.entity.Course;
import com.epam.exception.CourseNotFoundException;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	private ModelMapper mapper;

	public List<CourseDto> getAllCourses() {
		return toListDto(courseRepository.findAll());
	}

	public CourseDto createCourse(CourseDto courseDto) {
		return toDto(courseRepository.save(toEntity(courseDto)));
	}

	public CourseDto updateCourse(CourseDto courseDto) {

		Course course = courseRepository.findById(courseDto.getCourseId()).orElseThrow(
				() -> new CourseNotFoundException("Course not found with Id : " + courseDto.getCourseId()));

		course.setCourseName(courseDto.getCourseName());
		course.setCourseDuration(courseDto.getCourseDuration());

		return toDto(courseRepository.save(course));
	}

	public void deleteCourse(int courseId) {

		Course course = courseRepository.findById(courseId).orElseThrow(
				() -> new CourseNotFoundException("Course not found with Id : " + courseId));
		courseRepository.delete(course);

	}

	public List<CourseDto> toListDto(List<Course> courses) {
		mapper = new ModelMapper();
		return courses.stream().map(course -> mapper.map(course, CourseDto.class)).collect(Collectors.toList());
	}

	public Course toEntity(CourseDto courseDto) {
		mapper = new ModelMapper();
		return mapper.map(courseDto, Course.class);
	}

	public CourseDto toDto(Course courseEntity) {
		mapper = new ModelMapper();
		return mapper.map(courseEntity, CourseDto.class);
	}

	public CourseDto searchCourse(int courseId) {

		return toDto(courseRepository.findById(courseId)
				.orElseThrow(() -> new CourseNotFoundException("Course not found With : " + courseId)));
	}

	public List<CourseDto> searchCourse(double courseDuration) {
		return toListDto(courseRepository.findByCourseDuration(courseDuration));
	}

}
