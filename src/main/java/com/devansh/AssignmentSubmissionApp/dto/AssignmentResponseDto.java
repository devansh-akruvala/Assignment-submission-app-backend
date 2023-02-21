package com.devansh.AssignmentSubmissionApp.dto;

import com.devansh.AssignmentSubmissionApp.enums.AssignmentEnum;
import com.devansh.AssignmentSubmissionApp.enums.AssignmentStatusEnum;
import com.devansh.AssignmentSubmissionApp.model.Assignment;

public class AssignmentResponseDto {
	private Assignment assignment;
	private AssignmentEnum[] assignmentEnums = AssignmentEnum.values();
	private AssignmentStatusEnum[] assignmentStatusEnums = AssignmentStatusEnum.values();
	
	public AssignmentResponseDto(Assignment assignment) {
		super();
		this.assignment = assignment;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public AssignmentEnum[] getAssignmentEnums() {
		return assignmentEnums;
	}
//	public void setAssignmentEnums(AssignmentEnum[] assignmentEnums) {
//		this.assignmentEnums = assignmentEnums;
//	}

	public AssignmentStatusEnum[] getAssignmentStatusEnums() {
		return assignmentStatusEnums;
	}
	
	

}
