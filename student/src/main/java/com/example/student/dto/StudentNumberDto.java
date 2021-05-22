package com.example.student.dto;

public class StudentNumberDto {
	private long count;
	private String nameClass;
	private String nameDepartment;
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getNameClass() {
		return nameClass;
	}
	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}
	public String getNameDepartment() {
		return nameDepartment;
	}
	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}
	public StudentNumberDto(long count, String nameClass, String nameDepartment) {
		super();
		this.count = count;
		this.nameClass = nameClass;
		this.nameDepartment = nameDepartment;
	}
	public StudentNumberDto() {
		super();
	}
	
	
}
