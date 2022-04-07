package com.example.aop.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public void get(@PathVariable Long id, @RequestParam String name){
        System.out.println("get method");
        System.out.println("get method"+id);
        System.out.println("get method"+name);
    }

    public void post(){}
}
