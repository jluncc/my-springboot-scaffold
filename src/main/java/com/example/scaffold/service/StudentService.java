package com.example.scaffold.service;

import com.example.scaffold.model.jpa.Student;
import com.example.scaffold.repository.testDB.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinglun on 2020-06-01
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findStuByAge(Integer age) {
        if (null == age) return new ArrayList<>();
        return studentRepository.findStuByAge(age);
    }
}
