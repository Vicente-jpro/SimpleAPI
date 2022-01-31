package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Student;

public interface StudentService {
	Student create(Student student);
	List<Student> readAll();
	Student getStudent(Long id);
	void delete(Long id);
	List<Student> search(String keyWord);

}
