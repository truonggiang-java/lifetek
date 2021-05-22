package com.example.student.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "student")
public class Student extends BaseEntity {

	@Column(name = "NAME")
	private String name;

	@Column(name = "BIRTHDATE")
	private Date birthDate;

	@Column(name = "GENDER")
	private Integer gender;
	
	@Column(name = "CLASS_ID")
	private String classId;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "class_id", insertable = false, updatable = false)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"}) 
	private Classs classss;

	@Column(name = "ADDRESS")
	private String address;

	public Student(String name, Date birthDate, Integer gender,
			String classId, Classs classss, String address) {
		
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.classId = classId;
		this.classss = classss;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Classs getClassss() {
		return classss;
	}

	public void setClassss(Classs classss) {
		this.classss = classss;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student() {
		
	}

	
	

}
