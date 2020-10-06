package com.arthur.student.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arthur.student.modal.Student;
import com.arthur.student.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController{
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/getAll")
	public String getAll(Model model, @Param("keyword")String keyword) {
		List<Student> students = studentService.getAll(keyword);
		model.addAttribute("students", students);
		 model.addAttribute("keyword", keyword);
		
		String username = "Admin";
		model.addAttribute("username", username);
		
		return "students";
	}
	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Student student) {
		studentService.update(student);
		return "redirect:/students/getAll";
	}
	
	@RequestMapping("/getOne") 
	@ResponseBody
	public Optional<Student> getOne(Integer Id)
	{
		return studentService.getOne(Id);
	}
	
	@PostMapping(value="/addNew")
	public String addNew(Student student) {
		studentService.addNew(student);
		return "redirect:/students/getAll";
	}
	
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer Id) {
		studentService.delete(Id);
		return "redirect:/students/getAll";
	}
}