package com.arthur.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arthur.student.modal.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	 @Query("SELECT p FROM Student p WHERE p.name LIKE %?1%"
	            + " OR p.department LIKE %?1%"
	            + " OR p.updatedBy LIKE %?1%"
	           )
	    public List<Student> search(String keyword);
}
