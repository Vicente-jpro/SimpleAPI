package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentServicedb;

@RestController
@RequestMapping(path="/student/")
public class EstudentController {

	@Autowired
	private StudentServicedb studentServicedb;
	
	@GetMapping("hello")
	public @ResponseBody String hello(){
		return "Hello String boot";
	}
	
	@PostMapping("add")
	@ResponseBody
	public String create(@RequestBody Student student ){
		studentServicedb.create( student ) ;
		return "Student saved";
	}
	
	@GetMapping("students")
	@ResponseBody
	public List<Student> read() {
		return studentServicedb.readAll();
	}
	
	// localhost:8000/student/1?id=idNumber
	@GetMapping("get")
	@ResponseBody
	public Student getStudent(@RequestParam("id") Long id){
		return this.studentServicedb.getStudent(id);
	}
	
	@DeleteMapping("delete")
	@ResponseBody
	public String Delete(@RequestParam("id") Long id){
		this.studentServicedb.delete(id);
		return "Student deleted";
	}
	
	
}
