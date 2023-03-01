package com.devansh.AssignmentSubmissionApp.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devansh.AssignmentSubmissionApp.dto.AssignmentResponseDto;
import com.devansh.AssignmentSubmissionApp.enums.AuthorityEnum;
import com.devansh.AssignmentSubmissionApp.model.Assignment;
import com.devansh.AssignmentSubmissionApp.model.User;
import com.devansh.AssignmentSubmissionApp.service.AssignmentService;
import com.devansh.AssignmentSubmissionApp.service.UserService;
import com.devansh.AssignmentSubmissionApp.utility.AuthorityUtil;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user){
		Assignment newAssignment = assignmentService.save(user);
		return ResponseEntity.ok(newAssignment);
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAssignments(@AuthenticationPrincipal User user){
		List<Assignment> assignment = assignmentService.findByUser(user);
		return ResponseEntity.ok(assignment);
	}
	
	@GetMapping("{assignmentId}")
	public ResponseEntity<?> getAssignments(@PathVariable("assignmentId") Long assignmentId, @AuthenticationPrincipal User user){
		Optional<Assignment> assignment = assignmentService.findById(assignmentId);
		return ResponseEntity.ok(new AssignmentResponseDto(assignment.orElse(null)));
	}
	
	@PutMapping("{assignmentId}")
	public ResponseEntity<?> updateAssignment(@PathVariable("assignmentId") Long assignmentId,
			@AuthenticationPrincipal User user,@RequestBody Assignment assignment){
		
		if(assignment.getCodeReviewer()!=null) {
			User codeReviewer = assignment.getCodeReviewer();
			codeReviewer = userService.findUserByUsername(codeReviewer.getUsername()).orElse(null);
		
			if(AuthorityUtil.hasRole(user, AuthorityEnum.ROLE_CODE_REVIEWER.name())) {
				assignment.setCodeReviewer(codeReviewer);
			}
		}
		
		Assignment updatedAssignment = assignmentService.updateAssignment(assignment) ;
		return ResponseEntity.ok(updatedAssignment);
	}

}
