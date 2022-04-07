package com.epam.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



public class CourseDto {

	
	private int courseId;
	
	@NotBlank(message = "Please enter Course Name")
	@Size(min=3, max=20, message = "Course name should be minimum 3 characters and maximum 20 characters")
	private String courseName;
	
	@NotBlank(message="Please enter Course Duration")
	private String courseDuration;
	
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

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
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
