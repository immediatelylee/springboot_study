package com.godcoder.myhome.controller;

import com.godcoder.myhome.Validator.BoardValidator;
import com.godcoder.myhome.model.Board;
import com.godcoder.myhome.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardValidator boardValidator;

//    게시판을 호출하는데 db에서 정보를 불러오고 싶다 model사용
    @GetMapping("/list")
    public String list(Model model, Pageable pageable){
        Page<Board> boards = boardRepository.findAll(pageable);
//        boards.getTotalElements();
        int startPage = Math.max(0,boards.getPageable().getPageNumber() -4);
        int endPage = Math.min(boards.getTotalPages(),boards.getPageable().getPageNumber() +4);
        model.addAttribute("start",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("boards",boards);

        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("board",new Board());
        }else{
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board",new Board());
        }

        return "board/form";
    }
//    https://spring.io/guides/gs/validating-form-input/
    @PostMapping("/form")
    public String greetingSubmit(@Valid Board board, BindingResult bindingResult) {
        boardValidator.validate(board,bindingResult);
        if (bindingResult.hasErrors()) {
            return "board/form";
        }
        boardRepository.save(board);
        return "redirect:/board/list";
    }

//      spring guidence handling form submission
//      강의 - 값을 뿌려주고 list로 가야 하기 때문에 redirect를 써야한다


//        return "/board/list";
    }


