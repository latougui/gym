package com.latou.gym.web.admin;

import com.latou.gym.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api("管理页")
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;

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

}
