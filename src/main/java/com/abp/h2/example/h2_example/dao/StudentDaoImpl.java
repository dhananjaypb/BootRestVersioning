package com.abp.h2.example.h2_example.dao;

import com.abp.h2.example.h2_example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getStudent() {
        return jdbcTemplate.query("select * from Student", new BeanPropertyRowMapper<Student>(Student.class));
    }

    public Student addStudent(Student student) {
        jdbcTemplate.execute("CREATE TABLE student(std_ID INT PRIMARY KEY,std_NAME VARCHAR(255), std_Age INT);");
        jdbcTemplate.update("insert into student values(?,?,?)",student.getStdId(),student.getStdName(),student.getStdAge());
        return student;
    }
}
