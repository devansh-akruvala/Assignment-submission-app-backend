package com.devansh.AssignmentSubmissionApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devansh.AssignmentSubmissionApp.dto.CommentDto;
import com.devansh.AssignmentSubmissionApp.model.Comment;
import com.devansh.AssignmentSubmissionApp.model.User;
import com.devansh.AssignmentSubmissionApp.service.CommentSerivce;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private CommentSerivce commentService;
	
	@PostMapping("")
	public ResponseEntity<Comment> createComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal User user){
		Comment comment = commentService.save(commentDto,user);
		return ResponseEntity.ok(comment);
	}
	@PutMapping("")
	public ResponseEntity<Comment> editComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal User user){
		Comment comment = commentService.save(commentDto,user);
		return ResponseEntity.ok(comment);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Comment>> getCommentsByAssignment(@RequestParam Long assignmentId){
		List<Comment> comments = commentService.getCommentsByAssignmentId(assignmentId);
		return ResponseEntity.ok(comments);
	}
	
}
