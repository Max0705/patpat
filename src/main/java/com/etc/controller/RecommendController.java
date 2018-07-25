package com.etc.controller;

import com.etc.entity.App;
import com.etc.entity.JsonResult;
import com.etc.entity.User;
import com.etc.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
public class RecommendController {
    @Autowired
    private RecommendService recommendService;

    @GetMapping("/recommendApp/{uid}")
    public JsonResult<List<App>> getRecommendApp(@PathVariable int uid){
        return new JsonResult<List<App>>(recommendService.recommendApp(uid));
    }

    @GetMapping("/recommendUser/{uid}")
    public JsonResult<List<User>> getRecommendUser(@PathVariable int uid)throws UnsupportedEncodingException {
        return new JsonResult<List<User>>(recommendService.recommendUser(uid));
    }

}
