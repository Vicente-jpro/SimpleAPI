package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Student;
import com.example.demo.execeptions.StudentNotFoundExeception;
import com.example.demo.repository.StudentRepository;

import net.bytebuddy.asm.Advice.This;

@Service
public class StudentServicedb implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student create(Student student) {
		return this.studentRepository.save(student);
	}

	@Override
	public List<Student> readAll() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudent(Long id) {
	 return this.studentRepository.findById(id)
			 					  .orElseThrow( () -> new StudentNotFoundExeception("Student not found. This id = "+id+" do not exist"));
	}

	@Override
	public void delete(Long id) {
	  this.studentRepository.deleteById(id);
	}

	@Override
	public List<Student> search(String keyWord) {
		return this.studentRepository.searchByKeyWord(keyWord);
	}
	
	public void deleteAll() {
		this.studentRepository.deleteAll();
	}
	
	public Student findByName(String name) {
		return this.findByName(name);
	}

}
