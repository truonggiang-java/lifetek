package com.example.student.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClasssDto {
	public String id;

	public String name;
	
	public String course;

	public String department;

	public String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ClasssDto(String id, String name, String course, String department, String description) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.department = department;
		this.description = description;
	}
	public ClasssDto() {
		super();
	}
	
}
