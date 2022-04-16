package com.example.thymeleaf_layout.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 경로를 지정하지 않으면 홈페이지가 호출될때 바로 index()가 호출된다.
    @GetMapping("/hello")
    public String index(){
        return "index";
    }
}
