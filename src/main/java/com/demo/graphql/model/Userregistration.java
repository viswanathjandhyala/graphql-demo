package com.demo.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "userregistration", catalog = "udyogii_db", uniqueConstraints = {
		@UniqueConstraint(columnNames = "emailid"), @UniqueConstraint(columnNames = "phonenumber") })
@JsonRootName(value = "user")
@JsonPropertyOrder({ "username", "userverified", "password", "firstname", "lastname", "emailid", "emailverified", "phonenumber", "numberverified", "profileimage", "userrole"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
public class Userregistration implements java.io.Serializable {

	/**
	 * 
	 */
	static final long serialVersionUID = -7249446923248137063L;
	private String username;
	private Userrole userrole;
	private boolean userverified;
	private String password;
	private String firstname;
	private String lastname;
	private String emailid;
	private boolean emailverified;
	private String phonenumber;
	private boolean numberverified;
	private String profileimage;

	public Userregistration() {
	}
	
	public Userregistration(String username) {
		this.username = username;
	}

	public Userregistration(String username, Userrole userrole, boolean userverified, String password, String firstname,
			String lastname, String emailid, boolean emailverified, String phonenumber, boolean numberverified) {
		this.username = username;
		this.userrole = userrole;
		this.userverified = userverified;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.emailverified = emailverified;
		this.phonenumber = phonenumber;
		this.numberverified = numberverified;
	}

	@Id

	@Column(name = "username", unique = true, nullable = false, length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid", nullable = false, updatable = false)
	public Userrole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}

	@Column(name = "userverified", nullable = false)
	public boolean isUserverified() {
		return this.userverified;
	}

	public void setUserverified(boolean userverified) {
		this.userverified = userverified;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstname", nullable = false, length = 100)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", nullable = false, length = 100)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "emailid", unique = true, nullable = false, length = 100)
	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "emailverified", nullable = false)
	public boolean isEmailverified() {
		return this.emailverified;
	}

	public void setEmailverified(boolean emailverified) {
		this.emailverified = emailverified;
	}

	@Column(name = "phonenumber", unique = true, nullable = false, length = 10)
	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Column(name = "numberverified", nullable = false)
	public boolean isNumberverified() {
		return this.numberverified;
	}

	public void setNumberverified(boolean numberverified) {
		this.numberverified = numberverified;
	}

	@Column(name = "profileimage", length = 500)
	public String getProfileimage() {
		return this.profileimage;
	}

	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
}
