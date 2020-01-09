package com.eastnorth.controller;

import com.eastnorth.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @Auther: zuojianhou
 * @Date: 2020/1/9
 * @Description:
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        return restTemplate.getForObject("http://eastnorth/student/findAll", Collection.class);
    }

    @GetMapping("/index")
    public String index() {
        return restTemplate.getForObject("http://eastnorth/student/index", String.class);
    }
}
