package com.springj.services;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public Student getInfo() {
		Student student = new Student("Mayur","Hatte");
		return student;
		
	}
}
