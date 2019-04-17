package com.abp.h2.example.h2_example.service;

import com.abp.h2.example.h2_example.dao.StudentDaoImpl;
import com.abp.h2.example.h2_example.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {

    StudentDaoImpl studentDao;

    public StudentServiceImpl(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getStudent(){
          return studentDao.getStudent();
        }

    public Student addStudent(Student student){
        return studentDao.addStudent(student);
    }

}
