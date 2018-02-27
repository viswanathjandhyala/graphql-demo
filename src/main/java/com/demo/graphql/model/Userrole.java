package com.demo.graphql.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "userrole", catalog = "udyogii_db")
@JsonRootName(value = "companies")
@JsonPropertyOrder({ "userroleid", "role"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
public class Userrole implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -128517017925347778L;
	private Integer userroleid;
	private String role;

	public Userrole() {
	}

	public Userrole(Integer userroleid) {
		this.userroleid = userroleid;
	}
	
	public Userrole(String role) {
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "userroleid", unique = true, nullable = false, updatable = false)
	public Integer getUserroleid() {
		return this.userroleid;
	}

	public void setUserroleid(Integer userroleid) {
		this.userroleid = userroleid;
	}

	@Column(name = "role", length = 100, nullable = false, updatable = false)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
