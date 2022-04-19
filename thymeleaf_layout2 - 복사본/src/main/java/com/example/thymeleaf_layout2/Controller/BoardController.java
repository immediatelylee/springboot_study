package com.example.thymeleaf_layout2.Controller;

import com.example.thymeleaf_layout2.model.Board;
import com.example.thymeleaf_layout2.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boards = boardRepository.findAll();
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
    @PostMapping("/form")
    public String greetingSubmit(@ModelAttribute Board board) {
        boardRepository.save(board);
//      spring guidence handling form submission
//      강의 - 값을 뿌려주고 list로 가야 하기 때문에 redirect를 써야한다
        return "redirect:/board/list";
//        return "/board/list";
    }

}
