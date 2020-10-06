package com.arthur.student.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.arthur.student.modal.Student;
import com.arthur.student.repository.StudentRepository;

@Service
public class StudentService {
@Autowired
private StudentRepository studentRepository;

public List<Student> getAll(String keyword){
	 if (keyword != null) {
		 return studentRepository.search(keyword);
	 }
	return (List<Student>) studentRepository.findAll();
		 }


public Optional<Student> getOne(Integer Id){
	return studentRepository.findById(Id);
}

public void addNew(Student student){
	 studentRepository.save(student);
}

public void update(Student student){
	 studentRepository.save(student);
}

public void delete(Integer Id){
	 studentRepository.deleteById(Id);
}
}
