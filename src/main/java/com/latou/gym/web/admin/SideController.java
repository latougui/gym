package com.latou.gym.web.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SideController {
    @GetMapping("side")
    public String sideList(){
        return "admin/side";
    }
}
