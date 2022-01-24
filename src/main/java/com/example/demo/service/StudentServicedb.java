package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;

import net.bytebuddy.asm.Advice.This;

@Service
public class StudentServicedb implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void create(Student student) {
		this.studentRepository.save(student);
	}

	@Override
	public List<Student> readAll() {
		
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudent(Long id) {
	
	 Optional<Student> student =  this.studentRepository.findById(id);
	 return student.get();
	 
	}

}
