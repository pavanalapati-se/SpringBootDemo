package com.epam.dto;

public class AssignmentDto {

	private int assignmentId;

	private String assignmentDescription;

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getAssignmentDescription() {
		return assignmentDescription;
	}

	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}

	@Override
	public String toString() {
		return "AssignmentDto [assignmentId=" + assignmentId + ", assignmentDescription=" + assignmentDescription + "]";
	}

}
