package com.example.shoppingmall_portpolio.controller;

import com.example.shoppingmall_portpolio.service.CategoryService;
import com.example.shoppingmall_portpolio.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final CategoryService categoryService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model)



}
