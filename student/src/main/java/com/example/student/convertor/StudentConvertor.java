package com.example.student.convertor;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.student.dto.StudentDto;
import com.example.student.entity.Classs;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;

@Component
public class StudentConvertor {

	@Autowired
	private StudentRepository studentRepository;
	private DateFormat formart;

	public StudentConvertor(DateFormat formart) {
		this.formart = formart;
	}

	public Student convertor(StudentDto studentDto, String id) {
		Student student = new Student();

		if (id != null) {
			student.setId(id);
		} else {
			student.setId(null);
		}
		Classs classs = new Classs();
		classs.setId(studentDto.getClassss());
		student.setName(studentDto.getName());
		student.setGender(studentDto.getGender());
		student.setClassss(classs);
		try {
			student.setBirthDate(formart.parse(studentDto.getDate()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		student.setAddress(studentDto.getAddress());
		student.setTimeCreate(new Timestamp(System.currentTimeMillis()));
		student.setTimeUpdate(new Timestamp(System.currentTimeMillis()));
		return student;
	}

	public Student apply(StudentDto studentDto){
		Student student = studentRepository.findById(studentDto.getId()).get();
		student.setName(studentDto.getName());
		student.setTimeUpdate(new Timestamp(System.currentTimeMillis()));
		student.setAddress(studentDto.getAddress());
		try {
			student.setBirthDate(formart.parse(studentDto.getDate()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		student.setGender(studentDto.getGender());
		student.setClassId(studentDto.getClassss());
		return student;
	}
}
