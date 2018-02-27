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
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "personalinfo", catalog = "udyogii_db")
@JsonRootName(value = "personal")
@JsonPropertyOrder({ "languagesknown", "gender", "qualification", "pskill1", "pskill2", "pskill3", "pskill4", "pskill5", "pskill6", "pskill7", "pskill8", "pskill9", "pskill10", "additionalskills", 
	"dob", "documents", "preaddress", "pasaddress", "joblocation", "preferredlocation"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
public class Personalinfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1567543289977943095L;
	private Integer personalinfoid;
	private Userregistration userregistration;
	private String languagesknown;
	private String gender;
	private String qualification;
	private String dob;
	private String pskill1;
	private String pskill2;
	private String pskill3;
	private String pskill4;
	private String pskill5;
	private String pskill6;
	private String pskill7;
	private String pskill8;
	private String pskill9;
	private String pskill10;
	private String additionalskills;
	private String documents;
	private String preaddress;
	private String pasaddress;
	private String joblocation;
	private String preferredlocation;

	public Personalinfo() {
	}

	public Personalinfo(Userregistration userregistration, String languagesknown, String gender, String qualification,
			String dob, String pskill1, String pskill2, String pskill3, String pskill4, String pskill5, String pskill6,
			String pskill7, String pskill8, String pskill9, String pskill10, String additionalskills, String documents,
			String preaddress, String pasaddress, String joblocation, String preferredlocation) {
		this.userregistration = userregistration;
		this.languagesknown = languagesknown;
		this.gender = gender;
		this.qualification = qualification;
		this.dob = dob;
		this.pskill1 = pskill1;
		this.pskill2 = pskill2;
		this.pskill3 = pskill3;
		this.pskill4 = pskill4;
		this.pskill5 = pskill5;
		this.pskill6 = pskill6;
		this.pskill7 = pskill7;
		this.pskill8 = pskill8;
		this.pskill9 = pskill9;
		this.pskill10 = pskill10;
		this.additionalskills = additionalskills;
		this.documents = documents;
		this.preaddress = preaddress;
		this.pasaddress = pasaddress;
		this.joblocation = joblocation;
		this.preferredlocation = preferredlocation;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "personalinfoid", unique = true, nullable = false)
	public Integer getPersonalinfoid() {
		return this.personalinfoid;
	}

	public void setPersonalinfoid(Integer personalinfoid) {
		this.personalinfoid = personalinfoid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public Userregistration getUserregistration() {
		return this.userregistration;
	}

	public void setUserregistration(Userregistration userregistration) {
		this.userregistration = userregistration;
	}

	@Column(name = "languagesknown", nullable = false, length = 100)
	public String getLanguagesknown() {
		return this.languagesknown;
	}

	public void setLanguagesknown(String languagesknown) {
		this.languagesknown = languagesknown;
	}

	@Column(name = "gender", nullable = false, length = 100)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "qualification", nullable = false, length = 100)
	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Column(name = "dob", nullable = false, length = 100)
	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name = "pskill1", nullable = false, length = 100)
	public String getPskill1() {
		return this.pskill1;
	}

	public void setPskill1(String pskill1) {
		this.pskill1 = pskill1;
	}

	@Column(name = "pskill2", nullable = false, length = 100)
	public String getPskill2() {
		return this.pskill2;
	}

	public void setPskill2(String pskill2) {
		this.pskill2 = pskill2;
	}

	@Column(name = "pskill3", nullable = false, length = 100)
	public String getPskill3() {
		return this.pskill3;
	}

	public void setPskill3(String pskill3) {
		this.pskill3 = pskill3;
	}

	@Column(name = "pskill4", nullable = false, length = 100)
	public String getPskill4() {
		return this.pskill4;
	}

	public void setPskill4(String pskill4) {
		this.pskill4 = pskill4;
	}

	@Column(name = "pskill5", nullable = false, length = 100)
	public String getPskill5() {
		return this.pskill5;
	}

	public void setPskill5(String pskill5) {
		this.pskill5 = pskill5;
	}

	@Column(name = "pskill6", nullable = false, length = 100)
	public String getPskill6() {
		return this.pskill6;
	}

	public void setPskill6(String pskill6) {
		this.pskill6 = pskill6;
	}

	@Column(name = "pskill7", nullable = false, length = 100)
	public String getPskill7() {
		return this.pskill7;
	}

	public void setPskill7(String pskill7) {
		this.pskill7 = pskill7;
	}

	@Column(name = "pskill8", nullable = false, length = 100)
	public String getPskill8() {
		return this.pskill8;
	}

	public void setPskill8(String pskill8) {
		this.pskill8 = pskill8;
	}

	@Column(name = "pskill9", nullable = false, length = 100)
	public String getPskill9() {
		return this.pskill9;
	}

	public void setPskill9(String pskill9) {
		this.pskill9 = pskill9;
	}

	@Column(name = "pskill10", nullable = false, length = 100)
	public String getPskill10() {
		return this.pskill10;
	}

	public void setPskill10(String pskill10) {
		this.pskill10 = pskill10;
	}

	@Column(name = "additionalskills", nullable = false, length = 100)
	public String getAdditionalskills() {
		return this.additionalskills;
	}

	public void setAdditionalskills(String additionalskills) {
		this.additionalskills = additionalskills;
	}

	@Column(name = "documents", nullable = false, length = 500)
	public String getDocuments() {
		return this.documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	@Column(name = "preaddress", nullable = false, length = 500)
	public String getPreaddress() {
		return this.preaddress;
	}

	public void setPreaddress(String preaddress) {
		this.preaddress = preaddress;
	}

	@Column(name = "pasaddress", nullable = false, length = 500)
	public String getPasaddress() {
		return this.pasaddress;
	}

	public void setPasaddress(String pasaddress) {
		this.pasaddress = pasaddress;
	}

	@Column(name = "joblocation", nullable = false, length = 500)
	public String getJoblocation() {
		return this.joblocation;
	}

	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}

	@Column(name = "preferredlocation", nullable = false, length = 500)
	public String getPreferredlocation() {
		return this.preferredlocation;
	}

	public void setPreferredlocation(String preferredlocation) {
		this.preferredlocation = preferredlocation;
	}

}
