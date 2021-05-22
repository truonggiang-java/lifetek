package com.example.student.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.student.dto.StudentAllDto;
import com.example.student.dto.StudentNumberDto;
import com.example.student.entity.Student;
import com.example.student.projection.StudentNumberProjection;
import com.example.student.projection.StudentProjection;

public interface StudentRepository extends JpaRepository<Student, String> {

	@Query(value = "select s from Student s")
	List<Student> findAllStudent();
	
	

	@Query(value = "select * from Student s order by time_create offset (:pageNumber - 1)*:size ROWS FETCH NEXT :size ROWS ONLY", nativeQuery = true)
	List<Student> pageStudent(@Param("pageNumber") int pageNumber, @Param("size") int size);

	@Query(value = "select new com.example.student.dto.StudentNumberDto(count(s.classId),c.name, d.name) from Student s"
			+" inner join Classs c on s.classId=c.id inner join"
			+ " Department d on d.id=c.departmentId"
			+ " where round(to_number("
			+ ""
			+ "(sysdate,s.birthDate)/12),0)"
			+ " BETWEEN :fromAge and :toAge group by s.classId,c.name,d.name")
	List<StudentNumberDto> findNumberStudent(@Param("fromAge") int fromAge, @Param("toAge") int toAge);
}
