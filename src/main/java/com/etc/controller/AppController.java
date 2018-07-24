package com.etc.controller;

import com.etc.entity.App;
import com.etc.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/app/sort/download",method = RequestMethod.GET)
    @ResponseBody
    public List<App> sortAppByDownload(){
        List<App> apps=appService.selectAllApp();
        int[][] s=new int[apps.size()][2];
        for(int i=0;i<apps.size();i++) {
            s[i][0] = Integer.valueOf(apps.get(i).getAppdownloads())+(int)(apps.get(i).getAppscore()*10);
            s[i][1]=i;
        }
        sortByDownload(s,0,apps.size()-1);
        List<App> apps1=new ArrayList<>();
        for(int i=0;i<apps.size();i++)
            apps1.add(apps.get(s[apps.size()-i-1][1]));
        return apps1;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/app/sort/score",method = RequestMethod.GET)
    @ResponseBody
    public List<App> sortAppByScore(){
        List<App> apps=appService.selectAllApp();
        int[][] s=new int[apps.size()][2];
        for(int i=0;i<apps.size();i++) {
            int j=Integer.valueOf(apps.get(i).getAppdownloads());
            s[i][0] = (int)(apps.get(i).getAppscore()*10);
            while(j!=0){
                s[i][0]++;
                j/=10;
            }
            s[i][1]=i;
        }
        sortByDownload(s,0,apps.size()-1);
        List<App> apps1=new ArrayList<>();
        for(int i=0;i<apps.size();i++)
            apps1.add(apps.get(s[apps.size()-i-1][1]));
        return apps1;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/app/sort/type",method = RequestMethod.GET)
    @ResponseBody
    public List<App> sortAppByType(@RequestParam String type){
        List<App> apps=appService.selectAppByType(type);
        int[][] s=new int[apps.size()][2];
        for(int i=0;i<apps.size();i++) {
            int j=Integer.valueOf(apps.get(i).getAppdownloads());
            s[i][0] = (int)(apps.get(i).getAppscore()*10);
            while(j!=0){
                s[i][0]++;
                j/=10;
            }
            s[i][1]=i;
        }
        sortByDownload(s,0,apps.size()-1);
        List<App> apps1=new ArrayList<>();
        for(int i=0;i<apps.size();i++)
            apps1.add(apps.get(s[apps.size()-i-1][1]));
        return apps1;
    }


    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/app/sort/time",method = RequestMethod.GET)
    @ResponseBody
    public List<App> sortAppByTime(){
        List<App> apps=appService.selectAllApp();
        List<App> apps1=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        if(calendar.get(Calendar.MONTH)-2>=0)
            calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)-2,calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
        else
            calendar.set(calendar.get(Calendar.YEAR)-1,calendar.get(Calendar.MONTH)+10,calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
        Date date=calendar.getTime();
        for(int i=0;i<apps.size();i++){
            if(apps.get(i).getAppdate().after(date))apps1.add(apps.get(i));
        }

        int[][] s=new int[apps.size()][2];
        for(int i=0;i<apps1.size();i++) {
            s[i][0] = Integer.valueOf(apps1.get(i).getAppdownloads())+(int)(apps1.get(i).getAppscore()*10);
            s[i][1]=i;
        }
        sortByDownload(s,0,apps1.size()-1);
        List<App> apps2=new ArrayList<>();
        for(int i=0;i<apps1.size();i++)
            apps2.add(apps1.get(s[apps1.size()-i-1][1]));
        return apps2;

    }


    public void sortByDownload(int[][] apps,int start,int end){
        if(start<end){
            int q=sortDownloa(apps,start,end);
            sortByDownload(apps,start,q-1);
            sortByDownload(apps,q+1,end);
        }
    }
    public int sortDownloa(int[][] apps,int start, int end){
        int q=apps[start][0];
        int p=apps[start][1];
        while(start<end){
            while (start<end&&apps[end][0]>q)end--;
            apps[start][0]=apps[end][0];
            apps[start][1]=apps[end][1];
            while(start<end&&apps[start][0]<=q)start++;
            apps[end][0]=apps[start][0];
            apps[end][1]=apps[start][1];
        }
        apps[start][0]=q;
        apps[start][1]=p;
        return start;
    }
}
