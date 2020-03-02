package com.latou.gym.web.ui;

import com.latou.gym.domain.Board;
import com.latou.gym.domain.Essay;
import com.latou.gym.service.BoardService;
import com.latou.gym.service.EssayService;
import com.latou.gym.util.Commons;
import com.youbenzi.mdtool.tool.MDTool;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@Controller
public class homeController {
    @Autowired
    EssayService essayService;

    @Autowired
    BoardService boardService;

    @GetMapping(value = "/")
    public String index(Model model){
        List<Essay> essays1 = essayService.findRecentEssay(1);
        List<Essay> essays2 = essayService.findRecentEssay(2);
        List<Essay> essays3 = essayService.findRecentEssay(3);
        List<Essay> essays4 = essayService.findRecentEssay(4);
        List<Essay> essays5 = essayService.findRecentEssay(5);
        Iterator it = essays1.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        model.addAttribute("essay1",essays1);
        model.addAttribute("essay2",essays2);
        model.addAttribute("essay3",essays3);
        model.addAttribute("essay4",essays4);
        model.addAttribute("essay5",essays5);
        String  active = "home";
        model.addAttribute("active",active);

        return "ui/home";
    }

    @GetMapping(value = "/detail")
    public String detail(HttpServletRequest request,Model model){
        String id= request.getParameter("essayId");
        long essayId = Long.parseLong(id);
        Essay essayDetail = essayService.findEssayById(essayId);
        // essayDetail.setEssayContent(MDTool.markdown2Html(essayDetail.getEssayContent()));
        // System.out.println("qu出来:"+essayDetail.getEssayContent());

        essayDetail.setEssayContent(Commons.article(essayDetail.getEssayContent()));
        model.addAttribute("essayDetail",essayDetail);
        //System.out.println(essayDetail.getEssayContent());
        //System.out.println(essayDetail.getEssayTitle());
        return "ui/detail";
    }

    @GetMapping(value = "/list/{essayBoardId}")
    public String boardList(Model model, @PathVariable long essayBoardId){

        List<Essay> essays = essayService.findAllEssayByBoard(essayBoardId);
       /* Iterator it = essays.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/



       Board board = boardService.findBoardByBoardId(essayBoardId);
       model.addAttribute("essays",essays);
       model.addAttribute("board",board);
       model.addAttribute("active",board.getBoardName());
        return "ui/board_list";
    }

}
