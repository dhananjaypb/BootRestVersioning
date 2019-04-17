package com.abp.h2.example.h2_example;

import com.abp.h2.example.h2_example.dao.StudentDaoImpl;
import com.abp.h2.example.h2_example.model.Student;
import hthurow.tomcatjndi.TomcatJNDI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class H2ExampleApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	StudentDaoImpl studentDao ;


	final String createTable = "CREATE TABLE student(std_ID INT PRIMARY KEY,std_NAME VARCHAR(255), std_Age INT);";
	final String insertValues = "INSERT INTO student VALUES(1, 'Hello',22)";


	@Before
	public void init(){
		jdbcTemplate.execute(createTable);
		jdbcTemplate.execute(insertValues);
		
	}

	@Test
	public void testGetStudent() {
		Student student = new Student(1,"Hello",22);
		List<Student> stdList = new ArrayList<Student>();
		stdList.add(student);
		assertEquals(stdList.getClass(), studentDao.getStudent().getClass());
		assertTrue(stdList.retainAll(studentDao.getStudent()));

	}

}

