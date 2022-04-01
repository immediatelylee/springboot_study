package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController // 해당 클래스는 REST API 처리를 하는 Controller
@RequestMapping("/api/get") // RequestMapping URI를 지정해주는 Annotation
public class GetApiController {

    @GetMapping("/hello")
    public String Hello(){
        return "get hello";
    }

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){

        System.out.println("PathVariable :" + name);
        return name;

    }
}
