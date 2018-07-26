package com.etc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
    @GetMapping({"/","index.html"})
    public String showHomePage(){
        //填入启动页
        return "index";
    }
    @RequestMapping({"/rankings","rankings.html"})
    public String showRankings(){
        return "rankings";
    }
    @RequestMapping({"/comment","rankings.html"})
    public String showComment(){
        return "comment";
    }
    @RequestMapping({"/contact","contact.html"})
    public String showContant(){
        return "contact";
    }
    @RequestMapping({"/app_recommend","app_recommend.html"})
    public String showRecommend(){
        return "app_recommend";
    }
    @RequestMapping({"/app_type","app_type.html"})
    public String showType(){
        return "app_type";
    }
    @RequestMapping({"/app_type_01","app_type_01.html"})
    public String appt(){
        return "app_type_01";
    }
    @RequestMapping("app_single.html")
    public String dsf(){
        return "app_single";
    }
    @RequestMapping("admin_app.html")
    public String sldjfk(){
        return "admin_app";
    }
}
