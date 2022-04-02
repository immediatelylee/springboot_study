package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Map;

@RestController // 해당 클래스는 REST API 처리를 하는 Controller
@RequestMapping("/api/get") // RequestMapping URI를 지정해주는 Annotation
public class GetApiController {

    @GetMapping("/hello")
    public String Hello(){
        return "get hello";
    }

    // http://localhost:9090/api/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){

        System.out.println("PathVariable :" + name);
        return name;

    }

    // http://localhost:9090/api/get/query-param?user=lee&email=lee@gamil.com&age=30
    @GetMapping("query-param")

    public String queryParam(@RequestParam Map<String,String> queryParam){
        // 데이터의 형태가 key-value조합이므로 map으로 받을 수있다.
        StringBuilder sb = new StringBuilder();
        // map은 return하면 값이 없을 것이기 때문에 stringbuffer에 담아서 출력한다.
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " +entry.getValue()+"\n"); // sb에 저장장

        });
        return sb.toString(); // sb에 저장한 내용 출력
    }

}
