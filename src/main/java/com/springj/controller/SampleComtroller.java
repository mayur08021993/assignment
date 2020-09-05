package com.springj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springj.services.Student;
import com.springj.services.StudentService;

@RestController
@RequestMapping("/ping")
public class SampleComtroller {
	
	@Autowired
	StudentService service;
	
	@GetMapping(value="/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Student getInfo(@PathVariable("name")String name){
		return service.getInfo();
	}
	
	@PostMapping(value="/create",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Student create(@RequestBody Student student){
		System.out.println(student.getName());
		return student;
	}
}
