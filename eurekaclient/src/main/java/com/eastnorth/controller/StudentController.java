package com.eastnorth.controller;

import com.eastnorth.entity.Student;
import com.eastnorth.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Auther: zuojianhou
 * @Date: 2020/1/6
 * @Description:
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/list")
    public Collection getList() {
        return studentRepository.findAll();
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        System.out.println(student.toString());
        studentRepository.saveOrUpdate(student);
        return "success";
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        studentRepository.saveOrUpdate(student);
        return "success";
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam("id") long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/index")
    public String index() {
        return "当前端口:" + this.port;
    }
}
