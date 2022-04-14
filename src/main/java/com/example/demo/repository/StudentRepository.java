package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	@Query( value = "SELECT s FROM Student s where s.name like %?1% order by id")
	List<Student> searchByKeyWord(String keyWord);
	
	@Query( value = "SELECT * FROM student WHERE id=(SELECT max(id) FROM student)", nativeQuery = true)
	Student findLastStudent();
}
