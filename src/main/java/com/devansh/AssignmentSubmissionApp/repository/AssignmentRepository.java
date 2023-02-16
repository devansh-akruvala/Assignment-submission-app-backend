package com.devansh.AssignmentSubmissionApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devansh.AssignmentSubmissionApp.model.Assignment;
import com.devansh.AssignmentSubmissionApp.model.User;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long>{
	List<Assignment> findByUser(User user);
}
