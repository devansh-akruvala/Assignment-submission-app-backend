package com.devansh.AssignmentSubmissionApp.model;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate cohortStartDate;
	private String userName;
	private String pasword;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getCohortStartDate() {
		return cohortStartDate;
	}
	public void setCohortStartDate(LocalDate cohortStartDate) {
		this.cohortStartDate = cohortStartDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	
}
