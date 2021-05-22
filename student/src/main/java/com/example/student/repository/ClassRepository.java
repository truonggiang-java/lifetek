package com.example.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.student.entity.Classs;
import com.example.student.entity.Department;

public interface ClassRepository extends JpaRepository<Classs, String> {
	@Query(value = "select c from Classs c")
	List<Classs> findAllId();

	@Query(value = "select c from Classs c where c.id like:id")
	Classs findOneId(@PathVariable("id") String id);

	@Query(value = "select c.id from Classs c inner join Student s on c.id = s.classss.id where c.id =:id")
	List<String> deleteStudent(@Param("id") String id);
}
