package com.example.student.convertor;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.example.student.dto.ClasssDto;
import com.example.student.entity.Classs;
import com.example.student.entity.Department;

@Component
public class ClasssConvertor {
	public Classs convertor(ClasssDto classsDto,String id) {
		Classs classs=new Classs();
		if(id != null) {
			classs.setId(id);
		}
		else {
			classs.setId(null);
		}
		Department department=new Department();
		department.setId(classsDto.getDepartment());
		classs.setName(classsDto.getName());
		classs.setDescription(classsDto.getDescription());
		classs.setCourse(classsDto.getCourse());
		classs.setDepartment(department);
		classs.setTimeCreate(new Timestamp(System.currentTimeMillis()));
		classs.setTimeUpdate(new Timestamp(System.currentTimeMillis()));
		return classs;
	}
	
	public void update(ClasssDto classsDto,Classs classs) {
		if(classsDto.getCourse() != null) {
			classs.setCourse(classsDto.getCourse());
			classs.setTimeUpdate(new Timestamp(System.currentTimeMillis()));
		}
		if(classsDto.getDescription() != null) {
			classs.setDescription(classsDto.getDescription());
		}
		if(classsDto.getName() != null) {
			classs.setName(classsDto.getName());
			classs.setTimeUpdate(new Timestamp(System.currentTimeMillis()));
		}
		if(classsDto.getDepartment() != null) {
			Department department=new Department();
			department.setId(classsDto.getDepartment());
			classs.setDepartment(department);
		}
	}
}
