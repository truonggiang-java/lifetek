package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.convertor.StudentConvertor;
import com.example.student.dto.DepartmentDto;
import com.example.student.dto.ServiceResponse;
import com.example.student.dto.StudentDto;
import com.example.student.dto.StudentNumberDto;
import com.example.student.entity.Student;
import com.example.student.projection.StudentNumberProjection;
import com.example.student.projection.StudentProjection;

import com.example.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentConvertor studentConvertor;
	
	public ResponseEntity<Object> created(StudentDto studentDto){
		try {
			Student student=studentRepository.save(studentConvertor.convertor(studentDto, studentDto.getId()));
			return new ResponseEntity<>("Thêm mới học sinh thành công",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>("Có lỗi thêm sinh viên yêu cầu gọi ngay đến 09xxxxxx",HttpStatus.BAD_REQUEST);
		}
	}
	
	public List<Student> findAllStudent(){
		return studentRepository.findAllStudent();
	}
	
	public Student findOneId(String id) {
		return studentRepository.findById(id).get();
	}
	
	public ResponseEntity<ServiceResponse> update(StudentDto studentDto){
		ServiceResponse response=new ServiceResponse<>();
		try {
			studentRepository.save(studentConvertor.apply(studentDto));
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
	
	public ResponseEntity<ServiceResponse> deleteById(String id) {
		ServiceResponse response = new ServiceResponse();
		try {
			studentRepository.deleteById(id);
			response.setStatus("success");
            response.setData("Xóa thành công");
            return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
            response.setStatus("errors");
            response.setData("Có lỗi xảy ra");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	public List<StudentNumberDto> findNumberStudent(int fromAge,int toAge){
		return studentRepository.findNumberStudent(fromAge,toAge);
	}
	
	public List<Student> pageStudent(int pageNumber,int size){
		return studentRepository.pageStudent(pageNumber, size);
	}
	
}
