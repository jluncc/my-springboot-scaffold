package com.example.scaffold.controller;

import com.example.scaffold.model.jpa.Student;
import com.example.scaffold.service.MyTestService;
import com.example.scaffold.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试用的接口
 *
 * Created by jinglun on 2020-04-12
 */
@RestController
@RequestMapping("/api/v1/check")
public class CheckController {
    @Resource
    private StudentService studentService;
    @Resource
    private MyTestService myTestService;

    @ApiOperation("[测试]根据年龄获取学生信息")
    @GetMapping("/find/student")
    public String findStudentByAge(Integer age) {
        List<Student> studentList = studentService.findStuByAge(age);
        return String.valueOf(studentList.size());
    }

    @ApiOperation("[测试]测试异步方法")
    @GetMapping("/async/test")
    public String asyncTest() {
        myTestService.testAsyncMethod();
        return "success";
    }

}
