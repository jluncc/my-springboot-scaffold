package com.example.scaffold.service;

import com.example.scaffold.annotation.MethodCache;
import com.example.scaffold.annotation.ParamCache;
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

    @MethodCache(key = "stuAge", expire = 60)
    public List<Student> findStuByAge(@ParamCache Integer age) {
        if (null == age) return new ArrayList<>();
        return studentRepository.findStuByAge(age);
    }
}
