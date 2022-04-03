package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }

    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user;
    }
}
