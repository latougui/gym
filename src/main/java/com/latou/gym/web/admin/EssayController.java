package com.latou.gym.web.admin;

import com.latou.gym.domain.Board;
import com.latou.gym.domain.Essay;
import com.latou.gym.service.BoardService;
import com.latou.gym.service.EssayService;
import com.latou.gym.util.APIResponse;
import org.codehaus.groovy.runtime.dgmimpl.arrays.ShortArrayPutAtMetaMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = {"/list"})
    public String essayList(Model model){
        List<Essay> essays = essayService.findAllEssay();
        List<Board> boards = boardService.findAllBoard();

        model.addAttribute("boards",boards);
        model.addAttribute("essays",essays);
        return "admin/essay_list";
    }

    @PostMapping(value = {"/publish"})
    @ResponseBody
    public APIResponse essayPublish(HttpServletRequest httpServletRequest){

        String id = httpServletRequest.getParameter("essayId");
        String essayTitle = httpServletRequest.getParameter("essayTitle");
        //System.out.println("essayBoardId:"+httpServletRequest.getParameter("essayBoardId"));
        long essayBoardId = Long.parseLong(httpServletRequest.getParameter("essayBoardId"));
        System.out.println("essayBoardId:"+essayBoardId);
        String essayContent = httpServletRequest.getParameter("essayContent");
        Essay essay = new Essay();

       // System.out.println(id+".....");
        if(!id.isEmpty()) {
           essay = essayService.findEssayById(Long.parseLong(id));
        }
        //System.out.println(essay);
        essay.setEssayTitle(essayTitle);
        essay.setEssayBoardId(essayBoardId);
        essay.setEssayContent(essayContent);

        System.out.println("conten:"+essayContent);

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        if(!id.isEmpty()){
            essay.setEssayUpdateTime(dateFormat.format(now));
            essayService.updateEssay(essay);
        }else {
            //System.out.println("else");
            essay.setEssayCreateTime(dateFormat.format(now));
            essay.setEssayUpdateTime(dateFormat.format(now));
           // System.out.println(essay);
            essayService.addEssay(essay);
        }
        return APIResponse.success();
    }

    @GetMapping(value = "/{id}")
    public String essayEditor(@PathVariable long id, Model model){
        Essay essay = essayService.findEssayById(id);
        List<Board> boards = boardService.findAllBoard();
        model.addAttribute("boards",boards);
        model.addAttribute("essay",essay);
        return "admin/essay_edit";
    }


    @GetMapping("/delete")
    @ResponseBody
    public APIResponse essayDelete(long essayId){
       // long id = Long.parseLong(essayId);
        essayService.deleteEssay(essayId);
        return APIResponse.success();
    }

}
