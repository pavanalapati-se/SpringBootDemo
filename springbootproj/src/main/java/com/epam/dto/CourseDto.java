package com.epam.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class CourseDto {

	
	private int courseId;
	
	@NotBlank(message = "Please enter Course Name")
	@Size(min=3, max=20, message = "Course name should be minimum 3 characters and maximum 20 characters")
	private String courseName;
	
	@NotNull(message="Please enter Course Duration")
	private double courseDuration;
	
	private List<AssignmentDto> assignments;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(double courseDuration) {
		this.courseDuration = courseDuration;
	}

	public List<AssignmentDto> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<AssignmentDto> assignments) {
		this.assignments = assignments;
	}

	@Override
	public String toString() {
		return "CourseDto [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", assignments=" + assignments + "]";
	}
	
	
}
