package com.example.student.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.convertor.StudentConvertor;
import com.example.student.dto.ServiceResponse;
import com.example.student.dto.StudentDto;
import com.example.student.dto.StudentNumberDto;
import com.example.student.entity.Classs;
import com.example.student.entity.Student;
import com.example.student.projection.StudentNumberProjection;
import com.example.student.projection.StudentProjection;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/student")
	private ResponseEntity<Object> created(@RequestBody StudentDto studentDto,Errors error){
		if(error.hasErrors()) {
			return new ResponseEntity<>(error.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList()),HttpStatus.BAD_REQUEST);
		}
		return studentService.created(studentDto);
	}
	@GetMapping("/student")
	private List<Student> findAllStudentPage(@RequestParam(value = "page",required = false,defaultValue = "0") int page,@RequestParam(value="size",required=false,defaultValue="3")  int size){
		return studentService.pageStudent(page,size);
	}
	
	@GetMapping("/student/all")
	private List<Student> findAllStudent(){
		return studentService.findAllStudent();
	}
	@GetMapping("/student/{id}")
	private Student findOneId(@RequestBody StudentDto studentDto,@PathVariable("id") String id) {
		return studentService.findOneId(id);
	}
	
	@GetMapping("/student/number")
	private List<StudentNumberDto> findNumberStudent(@RequestParam(value = "fromAge",required = false,defaultValue = "0") int fromAge,@RequestParam(value="toAge",required=false,defaultValue="25")  int toAge){
		return studentService.findNumberStudent(fromAge,toAge);
	}
	
	@PutMapping("/student/{id}")
	private ResponseEntity<ServiceResponse> update(@RequestBody StudentDto studentDto,@PathVariable("id") String id) {
		studentDto.setId(id);
		return studentService.update(studentDto);
	}
	
	@DeleteMapping(value = "student/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable("id") String id){
        return studentService.deleteById(id);
    }
}
