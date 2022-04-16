package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Student;
import com.example.demo.execeptions.StudentNotFoundExeception;
import com.example.demo.service.StudentServicedb;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
	
	@Autowired
	private StudentServicedb studentServicedb;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Student student;
	
	
	@Test
	@DisplayName("Get all students when there is")
	@Sql(statements = "INSERT INTO student (name, phone_number) values ('Vicente', '944889722')")
	public void readAll() throws URISyntaxException {
		ResponseEntity<Student> students = testRestTemplate.getForEntity(new URI("/students"), Student.class);
		assertEquals( students.hasBody() , true );
		assertEquals( students.getStatusCode() , HttpStatus.OK );
	}
	
	
	@Test
	@DisplayName("Get student")
	public void getStudent() throws URISyntaxException {
		student = studentServicedb.findLastStudent();	
		System.err.println(student);
		ResponseEntity<Student> st = testRestTemplate.getForEntity(new URI("get/"+student.getId()), Student.class);
		assertEquals( st.getBody().getName() , "Vicente" );
	}
	
	@Test
	@DisplayName("Delete student saved")
	public void delete() throws URISyntaxException {
		student = studentServicedb.findLastStudent();	
		System.err.println(student);
		ResponseEntity<Student> st = testRestTemplate.getForEntity(new URI("delete/"+student.getId()), Student.class);
		assertEquals( st.getBody().getName() , "Vicente" );
	}
		
	
}
