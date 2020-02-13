package com.latou.gym.web.admin;

import com.latou.gym.domain.Board;
import com.latou.gym.domain.Essay;
import com.latou.gym.service.BoardService;
import com.latou.gym.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/admin/essay")
public class EssayController {

    @Autowired
    EssayService essayService;
    @Autowired
    BoardService boardService;

    @GetMapping(value = {"/edit"})
    public String essayEdit(Model model){
        List<Essay> essays = essayService.findAllEssay();
        List<Board> boards = boardService.findAllBoard();
        Iterator it = boards.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        model.addAttribute("boards",boards);
        return "admin/essay_edit";
    }

}
