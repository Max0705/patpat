package com.etc.service;

import com.etc.dao.AppMapper;
import com.etc.dao.AprioriresultMapper;
import com.etc.dao.UserMapper;
import com.etc.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Component

public class RecommendService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AprioriresultMapper aprioriresultMapper;
    @Autowired
    private AppMapper appMapper;

    //推荐app
    public List<App> recommendApp(int uid){
        //根据apriori结果表和用户hobby生成推荐的hobby
        String userHobby=userMapper.selectByPrimaryKey(uid).getUserhobby();//查询用户hobby
        List<String> userHobbies= Arrays.asList(userHobby.split(","));//用户hobby列表
        List<Aprioriresult> recommendHobby=new ArrayList<Aprioriresult>();//包含用户hobby的AprioriResult集合

        AprioriresultExample aprioriresultExample=new AprioriresultExample();
        for(String str:userHobbies){
            aprioriresultExample.createCriteria().andFrequentLike("%"+str+"%");
            List<Aprioriresult> temp=aprioriresultMapper.selectByExample(aprioriresultExample);
            for(Aprioriresult ar:temp){
                recommendHobby.add(ar);
            }
        }

        List<String> recommendHobbies=new ArrayList<String>();//用来存储推荐的hobby

        //去除重复的hobby
        for(Aprioriresult ar:recommendHobby){
            String[] temp=ar.getFrequent().split(",");
            for(String str:temp){
                if(!recommendHobbies.contains(str)||userHobbies.contains(str))//去除重复的和用户已有的hobby
                    recommendHobbies.add(str);
            }
        }

        //添加推荐的app
        List<App> recommendApp=new ArrayList<App>();
        AppExample appExample=new AppExample();
        for(String str:recommendHobbies){
            appExample.clear();
            appExample.createCriteria().andApptypeLike("%"+str+"%");
            List<App> temp=appMapper.selectByExample(appExample);
            if(temp.size()<5){
                for(App app:temp){
                    if (!recommendApp.contains(app))
                        recommendApp.add(app);
                }
            }
            else{
                for(int i=0;i<5;i++){//每个类别推荐5个app
                    if (!recommendApp.contains(temp.get(i)))
                        recommendApp.add(temp.get(i));

                }
            }
        }

        return recommendApp;
    }

    //推荐用户
    public List<User> recommendUser(int uid)throws UnsupportedEncodingException {
        String userHobby=userMapper.selectByPrimaryKey(uid).getUserhobby();//查询用户hobby
        String[] userHobbies=userHobby.split(",");//用户hobby列表
        List<User> recommendUser=new ArrayList<User>();


        //查询hobby相近的用户
        UserExample userExample=new UserExample();
        for(String str:userHobbies){
            userExample.createCriteria().andUserhobbyLike("%"+str+"%");
            List<User> temp=userMapper.selectByExample(userExample);
            for(User user:temp){
                recommendUser.add(user);
            }
        }

        //推荐用户列表
        List<User> recommendUsers=new ArrayList<User>();
        for(User user:recommendUser){
            if(!recommendUsers.contains(user)&&user.getUserid()!=uid&&recommendUsers.size()<20)//去除重复用户
                recommendUsers.add(user);
        }

        return recommendUsers;
    }





}
