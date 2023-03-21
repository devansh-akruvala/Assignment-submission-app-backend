package com.devansh.AssignmentSubmissionApp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devansh.AssignmentSubmissionApp.dto.CommentDto;
import com.devansh.AssignmentSubmissionApp.model.Assignment;
import com.devansh.AssignmentSubmissionApp.model.Comment;
import com.devansh.AssignmentSubmissionApp.model.User;
import com.devansh.AssignmentSubmissionApp.repository.AssignmentRepository;
import com.devansh.AssignmentSubmissionApp.repository.CommentRepository;

@Service
public class CommentSerivce {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	
	public Comment save(CommentDto commentDto,User user) {
		Comment comment  = new Comment();
		Assignment assignment = assignmentRepository.findById(commentDto.getAssignmentId()).orElse(null);
		
		comment.setId(commentDto.getId());
		comment.setAssignment(assignment);
		comment.setText(commentDto.getText());
		comment.setCreatedBy(user);
		if(comment.getId()==null)
			comment.setCreatedDate(LocalDateTime.now());
		return commentRepository.save(comment);
		
	}


	public List<Comment> getCommentsByAssignmentId(Long assignmentId) {
		List<Comment> comments = commentRepository.findByAssignmentId(assignmentId);
		return comments;
	}
	
}
