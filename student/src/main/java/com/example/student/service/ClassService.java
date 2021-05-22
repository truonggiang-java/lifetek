package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.convertor.ClasssConvertor;
import com.example.student.dto.ClasssDto;
import com.example.student.dto.ServiceResponse;
import com.example.student.entity.Classs;
import com.example.student.repository.ClassRepository;




@Service
public class ClassService {
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private ClasssConvertor classsConvertor;
	
	public List<Classs> findAllId(){
		return classRepository.findAllId();
	}
	
	public ResponseEntity<Object> created(ClasssDto classsDto){
		try {
			Classs classs=classRepository.save(classsConvertor.convertor(classsDto, classsDto.getId()));
			return new ResponseEntity<>(classsDto,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>("Có lỗi thêm mới lớp xảy ra", HttpStatus.BAD_REQUEST);
		}
	}
	
	public Classs findOneId(String id) {
		return classRepository.findOneId(id);
	}
	
	public ResponseEntity<ServiceResponse> deleteById(String id){
		ServiceResponse serviceResponse=new ServiceResponse<>();
		if(classRepository.deleteStudent(id).size() > 0) {
			serviceResponse.setStatus("Error !!!!");
			serviceResponse.setData("Học sinh trong lớp không đc xóa");
			
		}else {
			classRepository.deleteById(id);
			serviceResponse.setData("Xóa thành công");
			serviceResponse.setStatus("success");
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
}
