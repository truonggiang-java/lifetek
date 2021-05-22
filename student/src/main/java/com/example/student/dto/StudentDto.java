package com.example.student.dto;



public class StudentDto {
	public String id;
	public String name;
	public Integer gender;
	public String classss;
	public String date;
	public String address;
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
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getClassss() {
		return classss;
	}
	public void setClassss(String classss) {
		this.classss = classss;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public StudentDto(String id, String name, Integer gender, String classss, String date, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.classss = classss;
		this.date = date;
		this.address = address;
	}
	public StudentDto() {
		super();
	}
	
	
	
	
	
	
	
}
