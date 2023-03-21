package com.devansh.AssignmentSubmissionApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devansh.AssignmentSubmissionApp.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query("Select c from Comment c "
			+ "where c.assignment.id = :assignmentId")
	List<Comment> findByAssignmentId(Long assignmentId);

}
