package com.devansh.AssignmentSubmissionApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devansh.AssignmentSubmissionApp.model.Assignment;
import com.devansh.AssignmentSubmissionApp.model.User;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long>{
	List<Assignment> findByUser(User user);

	@Query("select a from Assignment a "
			+ "where a.status='submitted' "
			+ "or a.codeReviewer = :codeReviewer")
	List<Assignment> findbyCodeReviewer(User codeReviewer);
}
