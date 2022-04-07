package com.epam.dto;

public class AssignmentDto {

	private int assignmentId;
	
	private String assignmentName;

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	@Override
	public String toString() {
		return "AssignmentDto [assignmentId=" + assignmentId + ", assignmentName=" + assignmentName + "]";
	}
	
	
}
