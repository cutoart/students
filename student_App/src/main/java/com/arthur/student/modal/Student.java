package com.arthur.student.modal;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Student {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int Id ;
	private String name;
	private String department;
private String updatedBy;
	public Student() {
		
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate updatedOn;

	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", department=" + department + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + "]";
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Student( String name, String department, String updatedBy, LocalDate updatedOn) {
		super();
		
		this.name = name;
		this.department = department;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}
	
	
	
}
