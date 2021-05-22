package com.example.student.controller.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.student.convertor.DepartmentConvertor;
import com.example.student.dto.DepartmentDto;
import com.example.student.dto.ServiceResponse;
import com.example.student.entity.Department;
import com.example.student.projection.DepartmentProjection;
import com.example.student.repository.DepartmentRepository;
import com.example.student.service.DepartmentService;

@RestController
@RequestMapping(value = "/api/v1")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired 
	private DepartmentConvertor departmentConvertor;
	@PostMapping(value = "/department")
	public ResponseEntity<Object> created(@RequestBody DepartmentDto departmentDto, Errors error) {
		if (error.hasErrors()) {
			return new ResponseEntity<>(error.getAllErrors().stream()
					.map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList()),
					HttpStatus.BAD_REQUEST);
		}
		return departmentService.create(departmentDto);
	}
	
	

	@PutMapping(value = "/department/{id}")
	public ResponseEntity<ServiceResponse> updated(@RequestBody DepartmentDto departmentDto,@PathVariable("id") String id){
		departmentDto.setId(id);
		return departmentService.update(departmentDto);
	}

	@GetMapping("/department")
	public List<Department> findAll() {
		return departmentService.findAllDepartment();
	}
	
	@GetMapping("/department/{id}")
	public Department findOneId(@PathVariable("id") String id) {
		return departmentService.findOneId(id);
	}
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<ServiceResponse> deleteDepartment(@PathVariable("id") String id){
		return departmentService.deleteDepartment(id);
	}
}
