package com.example.student.convertor;


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.student.dto.DepartmentDto;
import com.example.student.entity.Department;
import com.example.student.repository.DepartmentRepository;

@Component
public class DepartmentConvertor {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	public Department convertor(DepartmentDto departmentDto,String id) {
		Department department=new Department();
		if(id != null) {
			department.setId(id);
		}
		else {
			department.setId(null);
		}
		
		department.setTimeCreate(new Timestamp(System.currentTimeMillis()));
		department.setName(departmentDto.getName());
		department.setDescription(departmentDto.getDescription());
		department.setTimeUpdate(new Timestamp(System.currentTimeMillis()));
		return department;
	}
	
	public Department update(DepartmentDto departmentDto) {
		Department department=departmentRepository.findById(departmentDto.getId()).get();
		department.setName(departmentDto.getName());
		department.setTimeUpdate(new Timestamp(System.currentTimeMillis()));
		department.setDescription(departmentDto.getDescription());
		return department;
		
	}
	
}
