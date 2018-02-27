package com.demo.graphql.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "usercompanies", catalog = "udyogii_db")
@JsonRootName(value = "companies")
@JsonPropertyOrder({ "companyname", "doj", "dor", "noticeperiod", "documents", "achievementdesr", "salary", "userregistration", "usercompid"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
public class Usercompanies implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1541967421216708358L;
	private Integer usercompid;
	private Userregistration userregistration;
	private String companyname;
	private String doj;
	private String dor;
	private String noticeperiod;
	private String documents;
	private String achievementdesr;
	private String salary;

	public Usercompanies() {
	}

	public Usercompanies(Userregistration userregistration, String companyname, String doj, String dor,
			String noticeperiod, String documents, String achievementdesr, String salary) {
		this.userregistration = userregistration;
		this.companyname = companyname;
		this.doj = doj;
		this.dor = dor;
		this.noticeperiod = noticeperiod;
		this.documents = documents;
		this.achievementdesr = achievementdesr;
		this.salary = salary;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "usercompid", unique = true, nullable = false)
	public Integer getUsercompid() {
		return this.usercompid;
	}

	public void setUsercompid(Integer usercompid) {
		this.usercompid = usercompid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	@JsonManagedReference
	public Userregistration getUserregistration() {
		return this.userregistration;
	}

	public void setUserregistration(Userregistration userregistration) {
		this.userregistration = userregistration;
	}

	@Column(name = "companyname", nullable = false, length = 500)
	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	@Column(name = "doj", length = 500)
	public String getDoj() {
		return this.doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	@Column(name = "dor", length = 500)
	public String getDor() {
		return this.dor;
	}

	public void setDor(String dor) {
		this.dor = dor;
	}

	@Column(name = "noticeperiod", length = 500)
	public String getNoticeperiod() {
		return this.noticeperiod;
	}

	public void setNoticeperiod(String noticeperiod) {
		this.noticeperiod = noticeperiod;
	}

	@Column(name = "documents", nullable = false, length = 500)
	public String getDocuments() {
		return this.documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	@Column(name = "achievementdesr", length = 500)
	public String getAchievementdesr() {
		return this.achievementdesr;
	}

	public void setAchievementdesr(String achievementdesr) {
		this.achievementdesr = achievementdesr;
	}

	@Column(name = "salary", length = 500)
	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
}
