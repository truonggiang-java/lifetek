package com.example.student.dto;

public class StudentAllDto {
	private String id;
	private String name;
	private String birthDate;
	private String classId;
	private Integer gender;
	private String classs;
	private String department;
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public StudentAllDto(String id, String name, String birthDate, String classId, Integer gender, String classs,
			String department) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.classId = classId;
		this.gender = gender;
		this.classs = classs;
		this.department = department;
	}
	public StudentAllDto() {
		super();
	}
	
	
	
}
