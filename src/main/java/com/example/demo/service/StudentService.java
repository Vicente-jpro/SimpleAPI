package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Student;

public interface StudentService {
	void create(Student student);
	List<Student> readAll();
	Student getStudent(Long id);

}
