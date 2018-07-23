package com.etc.controller;

import com.etc.entity.AppLabel;
import com.etc.service.AppLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppLabelController {
    @Autowired
    AppLabelService appLabelService;

    @ResponseStatus(value= HttpStatus.ACCEPTED)
    @RequestMapping(value = "/appLabel/add",method = RequestMethod.POST)
    @ResponseBody
    public boolean addAppLabel(@RequestBody AppLabel appLabel){
        return appLabelService.insertAppLabel(appLabel);
    }

    @ResponseStatus(value= HttpStatus.ACCEPTED)
    @RequestMapping(value = "/appLabel/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteAppLabel(@RequestParam Integer labelId){
        return appLabelService.deleteAppLabel(labelId);
    }

    @ResponseStatus(value= HttpStatus.ACCEPTED)
    @RequestMapping(value = "/appLabel/update",method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateAppLabel(@RequestBody AppLabel appLabel){
        return appLabelService.updataAppLable(appLabel);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/appLabel/select",method = RequestMethod.GET)
    @ResponseBody
    public List<AppLabel> selectAppLabel(@RequestParam Integer appid){
        return appLabelService.selectAppLabel(appid);
    }
}
