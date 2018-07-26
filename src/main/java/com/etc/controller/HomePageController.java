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
    @RequestMapping("/rankings")
    public String showRankings(){
        return "rankings";
    }
    @RequestMapping("/comment")
    public String showComment(){
        return "comment";
    }
    @RequestMapping("/contact")
    public String showContant(){
        return "contact";
    }
    @RequestMapping("/app_recommend")
    public String showRecommend(){
        return "app_recommend";
    }
    @RequestMapping("/app_type")
    public String showType(){
        return "app_type";
    }

}
