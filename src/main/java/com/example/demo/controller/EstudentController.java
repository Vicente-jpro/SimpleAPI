package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentServicedb;

@Controller
@RequestMapping(path="/student/")
public class EstudentController {

	@Autowired
	private StudentServicedb studentServicedb;
	
	@GetMapping("hello")
	public @ResponseBody String hello(){
		return "Hello String boot";
	}
	
	@PostMapping("add")
	public @ResponseBody String create(@RequestParam String name, @RequestParam String phoneNumber ){
		studentServicedb.create( new Student(name, phoneNumber) );
		return "Student saved";
	}
	
	@GetMapping("students")
	public @ResponseBody List<Student> read() {
		return studentServicedb.readAll();
	}
	
	@GetMapping("student")
	public @ResponseBody Student getStudent(@RequestParam Long id){
		return this.studentServicedb.getStudent(id);
	}
	
	
	@PatchMapping("update")
	public @ResponseBody String update(@RequestParam Long id, @RequestParam String name, @RequestParam String phoneNumber){
		return "";
	}
}
