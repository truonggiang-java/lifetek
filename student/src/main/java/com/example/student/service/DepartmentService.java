package com.example.student.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.student.convertor.DepartmentConvertor;
import com.example.student.dto.DepartmentDto;
import com.example.student.dto.ServiceResponse;
import com.example.student.entity.Department;
import com.example.student.projection.DepartmentProjection;
import com.example.student.repository.DepartmentRepository;

@Service

public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentConvertor departmentConvertor;
	
	public List<Department> findAllDepartment(){
		return departmentRepository.findAll();
	}
	
	
	public ResponseEntity<Object> create(DepartmentDto departmentDto){
		try {
			Department department=departmentRepository.save(departmentConvertor.convertor(departmentDto, departmentDto.getId()));
			return new ResponseEntity<>("thêm mới thành công", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("thêm mới thất bại",HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<ServiceResponse> update(DepartmentDto departmentDto){
		ServiceResponse response=new ServiceResponse<>();
		try {
			departmentRepository.save(departmentConvertor.update(departmentDto));
			response.setData("cập nhật thành công phòng ban");
			response.setStatus("Success update department!!!");
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setStatus("error update department!!!");
			response.setData("Lỗi cập nhật phòng ban đề nghị gọi số 09853333");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	public Department findOneId(String id) {
		return departmentRepository.findOneId(id);
	}
	
	public ResponseEntity<ServiceResponse> deleteDepartment(String id){
		ServiceResponse response=new ServiceResponse();
		if(departmentRepository.deleteDepartment(id).size() > 0) {
			response.setStatus("Error !!!!");
			response.setData("Không xóa được khoa vì trong khoa vẫn còn lớp học");
		}
		else {
			departmentRepository.deleteById(id);
			response.setStatus("Success !!!!");
			response.setData("Xóa khoa thành công");
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
