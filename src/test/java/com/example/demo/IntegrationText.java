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
class IntegrationText {

	@Autowired
	private TextService textService;
	
	@Autowired
	private StudentServicedb studentServicedb;
	
	private Student student;
	
	@MockBean	
	private TextService textServiceMock;
	
	
	@Test
	public void itShoudDisplayAgreatMessage() {
		textService = new TextService();
		String result = textService.hello();
		Assertions.assertThat( result.equalsIgnoreCase("Hello Spring test") );
	}
	
	@Test
	@DisplayName("Get all students when there is")
	@Sql(statements = "INSERT INTO student (name, phone_number) values ('Vicente', '944889722')")
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
	}
	

	/*
	 * 
	 *
	 * 
	 * @Override public void delete(Long id) {
	 * this.studentRepository.deleteById(id); }
	 * 
	 * @Override public List<Student> search(String keyWord) { return
	 * this.studentRepository.searchByKeyWord(keyWord); }
	 * 
	 * public void deleteAll() { this.studentRepository.deleteAll(); }
	 */
	
	
}
