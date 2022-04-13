package com.epam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.epam.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public List<Course> findByCourseDuration(double courseDuration);

	// @Query("select c from Course c where c.assignments.assignmentDescription =
	// ?1")
	// public List<Course> findCourses(String assginementDescription);

	@Query("select c from Course c where c.assignments = :assignmentDesc")
	public List<Course> findCourses(@Param("assignmentDesc") String assginmentDescription);

	@Query("select c from Course c where c.courseDuration = :cDuration1 and c.courseDuration = :cDuration2")
	public List<Course> findCourses(@Param("cDuration1") double courseDurtation1,
			@Param("cDuration2") double courseDuration2);
	
	@Modifying
	@Query("delete from Course c where c.courseName = ?1")
	public List<Course> delete(String courseName);
}
