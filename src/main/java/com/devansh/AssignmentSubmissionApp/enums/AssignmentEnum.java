package com.devansh.AssignmentSubmissionApp.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum AssignmentEnum {
	ASSIGNMENT_1(1,"name 1"),
	ASSIGNMENT_2(2,"name 1"),
	ASSIGNMENT_3(3,"name 1"),
	ASSIGNMENT_4(4,"name 1"),
	ASSIGNMENT_5(5,"name 1"),
	ASSIGNMENT_6(6,"name 1"),
	ASSIGNMENT_7(7,"name 1"),
	ASSIGNMENT_8(8,"name 1"),
	ASSIGNMENT_9(9,"name 1"),
	ASSIGNMENT_10(10,"name 1"),
	ASSIGNMENT_11(11,"name 1"),
	ASSIGNMENT_12(12,"name 1"),
	ASSIGNMENT_13(13,"name 1"),
	ASSIGNMENT_14(14,"name 1");
	
	private int assignmentNumber;
	private String assignmentName;
	 AssignmentEnum(int assignmentNumber,String assignmentName) {
		 this.assignmentNumber = assignmentNumber;
		 this.assignmentName=assignmentName;
	 }
	 
	public int getAssignmentNumber() {
		return assignmentNumber;
	}

	public String getAssignmentName() {
		return assignmentName;
	}
	
}
