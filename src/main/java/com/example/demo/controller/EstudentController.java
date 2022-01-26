package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Student> create(@RequestBody Student student ){
		studentServicedb.create( student ) ;
		return new ResponseEntity<Student>(student, HttpStatus.OK) ;
	}
	
	@GetMapping("students")
	@ResponseBody
	public ResponseEntity<List<Student>> read() {
		return new ResponseEntity<List<Student>>(studentServicedb.readAll(), HttpStatus.OK) ;
	}
	
	// localhost:8000/student/get
	@GetMapping("get")
	@ResponseBody
	public ResponseEntity<Student> getStudent(@RequestParam("id") Long id){
		return new ResponseEntity<Student>( this.studentServicedb.getStudent(id), HttpStatus.OK);
	}
	
	@DeleteMapping("delete")
	@ResponseBody
	public ResponseEntity<?> Delete(@RequestParam("id") Long id){
		this.studentServicedb.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("search")
	@ResponseBody
	public ResponseEntity<List<Student>> search(@RequestParam("keyWord") String keyWord ) {
		return new ResponseEntity<List<Student>>(this.studentServicedb.search(keyWord), HttpStatus.OK) ;
	}
	
}
