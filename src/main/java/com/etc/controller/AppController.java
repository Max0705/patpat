package com.etc.controller;

import com.etc.entity.App;
import com.etc.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AppController {
    @Autowired
    AppService appService;

    @ResponseStatus(value= HttpStatus.ACCEPTED)
    @RequestMapping(value = "/app/add",method = RequestMethod.POST)
    @ResponseBody
    public int addApp(@RequestBody App app){
        return appService.insertNewApp(app);
    }


    @ResponseStatus(value= HttpStatus.ACCEPTED)
    @RequestMapping(value = "/app/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteApp(@RequestParam Integer appid){
        return appService.deleteApp(appid);
    }


    @ResponseStatus(value= HttpStatus.ACCEPTED)
    @RequestMapping(value = "/app/update",method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateApp(@RequestBody App app){
        return appService.updataApp(app);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/app/select/id",method = RequestMethod.GET)
    @ResponseBody
    public App getAppById(@RequestParam Integer appid){
        return appService.selectAppById(appid);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/app/select/name",method = RequestMethod.GET)
    @ResponseBody
    public List<App> getAppByName(@RequestParam String name){
        return appService.selectAppByName(name);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/app/select/label",method = RequestMethod.GET)
    @ResponseBody
    public List<App> getAppByLabel(@RequestParam String label){
        return appService.selectAppByLabel(label);
    }


    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/app/select/type",method = RequestMethod.GET)
    @ResponseBody
    public List<App> getAppBytype(@RequestParam String type){
        return appService.selectAppByType(type);
    }
}
