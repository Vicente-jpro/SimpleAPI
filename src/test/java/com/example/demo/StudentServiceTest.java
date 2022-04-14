package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import com.example.demo.domain.Student;
import com.example.demo.execeptions.StudentNotFoundExeception;
import com.example.demo.service.StudentServicedb;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	private TextService textService;
	
	@Autowired
	private StudentServicedb studentServicedb;
	
	private Student student;
	
	@Test
	public void itShoudDisplayAgreatMessage() {
		textService = new TextService();
		String result = textService.hello();
		Assertions.assertThat( result.equalsIgnoreCase("Hello Spring test") );
	}
	
	
	@Test
	@DisplayName("Get all students when there is")
	public void readAll() {
	
		List<Student> students = studentServicedb.readAll();
		assertEquals( students.isEmpty(), false );
		
	}
	
	
	@Test
	@DisplayName("Get student")
	public void getStudent() {
		student = studentServicedb.findLastStudent();
		
		Student st = studentServicedb.getStudent( (long) student.getId() );
		assertEquals( st.getName(), "Vicente" );
	}
	
	@Test
	@DisplayName("Delete student saved")
	public void delete() {
		student = studentServicedb.findLastStudent();
		
		studentServicedb.delete( (long) student.getId() );
		assertEquals( student.getId() > 0, student.getId() > 0 );
	}
		
	
}
