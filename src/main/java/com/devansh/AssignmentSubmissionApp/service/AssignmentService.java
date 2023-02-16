package com.devansh.AssignmentSubmissionApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devansh.AssignmentSubmissionApp.model.Assignment;
import com.devansh.AssignmentSubmissionApp.model.User;
import com.devansh.AssignmentSubmissionApp.repository.AssignmentRepository;

@Service
public class AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;
	
	public Assignment save(User user) {
		Assignment assignment = new Assignment();
		assignment.setStatus("Needs to be submitted");
		assignment.setUser(user);
		return assignmentRepository.save(assignment);
	}
	
	public List<Assignment> findByUser(User user){
		return assignmentRepository.findByUser(user);
	}

	public Optional<Assignment> findById(Long assignmentId) {
		return assignmentRepository.findById(assignmentId);
	}

	public Assignment updateAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		return assignmentRepository.save(assignment);
	}
	
}
