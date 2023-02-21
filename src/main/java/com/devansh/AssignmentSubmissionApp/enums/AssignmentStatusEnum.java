package com.devansh.AssignmentSubmissionApp.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum AssignmentStatusEnum {
	PENDING_SUBMISSION("Pending Submission",1),
	SUBMITTED("Submitted",2),
	IN_REVIEW("In Review",3),
	NEEDS_UPDATE("Needs Update",4),
	COMPLETED("Completed",5);

	private String status;
	private Integer step;
	
	AssignmentStatusEnum(String status,Integer step) {
		this.status = status;
		this.step=step;
	}

	public String getStatus() {
		return status;
	}
	public Integer getStep() {
		return step;
	}
	
	

}
