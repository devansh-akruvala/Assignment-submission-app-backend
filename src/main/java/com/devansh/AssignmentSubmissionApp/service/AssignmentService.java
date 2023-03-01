package com.devansh.AssignmentSubmissionApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devansh.AssignmentSubmissionApp.enums.AssignmentStatusEnum;
import com.devansh.AssignmentSubmissionApp.enums.AuthorityEnum;
import com.devansh.AssignmentSubmissionApp.model.Assignment;
import com.devansh.AssignmentSubmissionApp.model.User;
import com.devansh.AssignmentSubmissionApp.repository.AssignmentRepository;

@Service
public class AssignmentService {

	@Autowired
	private AssignmentRepository assignmentRepository;

	public Assignment save(User user) {
		Assignment assignment = new Assignment();
		assignment.setStatus(AssignmentStatusEnum.PENDING_SUBMISSION.getStatus());
		assignment.setUser(user);
		assignment.setNumber(findNextAssignmentTobeSubmitted(user));
		return assignmentRepository.save(assignment);
	}

	private Integer findNextAssignmentTobeSubmitted(User user) {
		List<Assignment> assignmentByUser = assignmentRepository.findByUser(user);
		if (assignmentByUser == null)
			return 1;
		Optional<Integer> findFirst = assignmentByUser.stream().sorted((a1, a2) -> {
			if (a1.getNumber() == null)
				return 1;
			if (a2.getNumber() == null)
				return 1;
			return a1.getNumber().compareTo(a2.getNumber());
		}).map(assignment -> {
			if (assignment.getNumber() == null)
				return 1;
			return assignment.getNumber() + 1;
		}).findFirst();

		return findFirst.orElse(1);
	}

	public List<Assignment> findByUser(User user) {
		// if user is code reviewer return all users(students) assignment
		boolean hasCodeReviewRole = user.getAuthorities().stream()
				.filter(auth -> AuthorityEnum.ROLE_CODE_REVIEWER.name().equals(auth.getAuthority())).count() > 0;
		if (hasCodeReviewRole) {
			return assignmentRepository.findbyCodeReviewer(user);
		} else {
			// if user has student role just retur its assignment
			return assignmentRepository.findByUser(user);
		}
	}

	public Optional<Assignment> findById(Long assignmentId) {
		return assignmentRepository.findById(assignmentId);
	}

	public Assignment updateAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		return assignmentRepository.save(assignment);
	}

}
