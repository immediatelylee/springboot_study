package com.example.shoppingmall_portpolio.controller;

import com.example.shoppingmall_portpolio.service.CategoryService;
import com.example.shoppingmall_portpolio.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final CategoryService categoryService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model)
    {
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("prevPage",referer);
        model.addAtrribute("catMapList",categoryService.getCategoryList());

        return "user/login-register";
    }

    // 일반유저 회원가입
    @PostMapping("/member")
    public String registration(@ModelAttribute @Valid UserRequestDto userRequestDto, RedirectAttributes rttr) {
        userService.userRegistration(userRequestDto);

        rttr.addFlashAttribute("registerComplete", "회원가입이 완료되었습니다.");

        return "redirect:/login";
    }



}
