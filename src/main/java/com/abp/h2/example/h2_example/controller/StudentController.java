package com.abp.h2.example.h2_example.controller;

import com.abp.h2.example.h2_example.model.Student;
import com.abp.h2.example.h2_example.service.StudentServiceImpl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/student")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }
    @GetMapping(value = "/student",params = "v1")
    public List<Student> getStudentParamsVersioning(){
     return studentService.getStudent();
    }

    @PostMapping("/addStudent")
    public boolean addStudent(@RequestBody Student student){
        if(studentService.addStudent(student)!=null){
            return true;}
        return false;
    }

    @GetMapping(value = "/student",headers ="version=v1")
    public List<Student> getStudentHeaderVersioning(){
        return studentService.getStudent();
    }

    @GetMapping(value = "/student",produces = "application/json")
    public List<Student> getStudentMediaTypeVersioning(){
        return studentService.getStudent();
    }
}
