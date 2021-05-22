package com.example.student.controller.api;

import java.util.List;
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

import com.example.student.convertor.ClasssConvertor;
import com.example.student.dto.ClasssDto;
import com.example.student.dto.ServiceResponse;
import com.example.student.entity.Classs;
import com.example.student.entity.Department;
import com.example.student.repository.ClassRepository;
import com.example.student.service.ClassService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api/v1")
public class ClassController {
	@Autowired
	private ClassService classService;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private ClasssConvertor classsConvertor;
	
	@GetMapping("/class")
	public List<Classs> findAllId(){
		return classService.findAllId();
	}
	
	@PostMapping("/class")
	public ResponseEntity<Object> create(@RequestBody ClasssDto classsDto,Errors error){
		if(error.hasErrors()) {
			return new ResponseEntity<>(error.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList()),HttpStatus.BAD_REQUEST);
		}
		return classService.created(classsDto);
	}
	
	@GetMapping("/class/{id}")
	public Classs findOneId(@PathVariable("id") String id) {
		return classService.findOneId(id);
	}
	
	
	
	
	@PutMapping("/class/{id}")
	public Classs update(@RequestBody ClasssDto classsDto,@PathVariable("id")String id) throws JsonMappingException, JsonProcessingException {

		Classs classs= classRepository.findOneId(id);
		classsConvertor.update(classsDto, classs);
		classRepository.save(classs);
		return classRepository.findOneId(id);
	}
	
	@DeleteMapping("/class/{id}")
	public ResponseEntity<ServiceResponse> delete(@PathVariable("id") String id){
		return classService.deleteById(id);
	}
}
