package com.eastnarth.controller;

import com.eastnarth.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @Auther: zuojianhou
 * @Date: 2020/1/6
 * @Description:
 */
@RestController
@RequestMapping("/rest")
public class RestHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection findAll() {
        return restTemplate.getForEntity("http://localhost:8010/student/list", Collection.class).getBody();
    }

    @GetMapping("/list")
    public Collection getList() {
        return restTemplate.getForObject("http://localhost:8010/student/list", Collection.class);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        System.out.println(student.toString());
        restTemplate.postForEntity("http://localhost:8010/student/add", student, String.class);
    }

    @PostMapping("/save2")
    public void save2(Student student) {
        restTemplate.postForObject("http://localhost:8010/student/add", student, String.class);
    }

    @PutMapping("/update")
    public void update(Student student) {
        restTemplate.put("http://localhost:8010/student/update", student);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") long id) {
        restTemplate.delete("http://localhost:8010/student/delete?id={id}", id);
    }

}
