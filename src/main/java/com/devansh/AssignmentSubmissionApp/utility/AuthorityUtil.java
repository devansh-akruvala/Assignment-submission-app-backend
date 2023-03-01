package com.devansh.AssignmentSubmissionApp.utility;

import com.devansh.AssignmentSubmissionApp.model.User;

public class AuthorityUtil {
	public static Boolean hasRole(User user, String role) {
		return user.getAuthorities().stream().filter(auth -> auth.getAuthority().equals(role)).count() > 0;
	}
}
