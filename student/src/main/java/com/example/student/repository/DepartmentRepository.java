package com.example.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.student.dto.DepartmentResponse;
import com.example.student.entity.Department;
import com.example.student.projection.DepartmentProjection;

public interface DepartmentRepository extends JpaRepository<Department, String> {
	@Query(value = "select * from Department d", nativeQuery = true)
	DepartmentProjection findByAdmin();

	@Query(value = "select d from Department d where d.id like:id")
	Department findOneId(@Param("id") String id);
	
	@Query(value = "select * from Department d", nativeQuery = true)
	List<Department> findAll();
	
	@Query(value ="select d.id as id from Department d inner join Classs c on d.id=c.department.id where d.id =:id")
	List<String> deleteDepartment(@Param("id") String id);
}
