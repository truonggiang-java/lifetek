package com.example.student.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="class")
public class Classs extends BaseEntity{
	@Column(name="name")
	private String name;
	
	@Column(name="course")
	private String course;
	
	@ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinColumn(name="department_id", insertable = false, updatable = false)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"}) 
	private Department department;
	
	@Column(name="department_id")
	private String departmentId;
	@Column(name="description")
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Classs(String name, String course,
			Department department, String departmentId, String description) {
		
		this.name = name;
		this.course = course;
		this.department = department;
		this.departmentId = departmentId;
		this.description = description;
	}
	public Classs() {
		
	}


}
