package com.latou.gym.web.admin;

import com.latou.gym.domain.Essay;
import com.latou.gym.service.BoardService;
import com.latou.gym.service.EssayService;
import com.latou.gym.service.FoodService;
import com.latou.gym.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api("管理页")
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    EssayService essayService;
    @Autowired
    BoardService boardService;
    @Autowired
    FoodService foodService;

    @GetMapping(value = {"","/login"})
    public String login(){
        return "admin/login";
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录检测", notes="根据用户名、密码判断该用户是否存在")
    public String login(Model model, String username, String password){
        System.out.println(username+password);
        if(!"admin".equals(username)){
            model.addAttribute("error","无此用户！");
            return "admin/login";
        }

        if(!"123456".equals(password)){
            model.addAttribute("error","密码错误！");
            return "admin/login";
        }
        return "admin/index";
    }

    @GetMapping("/index")
    public String index(Model model){
        int essayCount = essayService.countEssay();
        int foodCount = foodService.countFood();
        int loveCount = essayService.countEssayLove();
        List<Essay> essays = essayService.findRecent();
        model.addAttribute("essayCount",essayCount);
        model.addAttribute("foodCount",foodCount);
        model.addAttribute("loveCount",loveCount);
        model.addAttribute("essays",essays);


        return "admin/index";
    }


}
