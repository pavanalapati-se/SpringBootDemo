package com.epam.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID")
	private int courseId;

	@Column(name = "COURSE_NAME")
	private String courseName;

	@Column(name = "COURSE_DURATION")
	private double courseDuration;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name = "courseId_fk")
	private List<Assignment> assignments;
	
	private String instructorName;

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

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignment(List<Assignment> assignments) {
		assignments.forEach(assign -> assign.setCourse(this));
		this.assignments = assignments;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

//	@Override
//	public String toString() {
//		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
//				+ ", assignment=" + assignment + "]";
//	}
	
	

}
