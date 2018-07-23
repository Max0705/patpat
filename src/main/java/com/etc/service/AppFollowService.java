package com.etc.service;

import com.etc.dao.AppFollowMapper;
import com.etc.entity.App;
import com.etc.entity.AppFollow;
import com.etc.entity.AppFollowExample;
import com.etc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppFollowService {
    @Autowired
    UserService userService;
    @Autowired
    AppService appService;
    @Autowired
    AppFollowMapper appFollowMapper;
    //关注应用
    public boolean userFollowApp(String userName,int AppId){
        User user=userService.selectUserByName(userName);
        App app=appService.selectAppById(AppId);
        AppFollow appFollow=new AppFollow();
        appFollow.setFollowappid(app.getAppid());
        appFollow.setUserid(user.getUserid());
        int i=appFollowMapper.insertSelective(appFollow);
        return i>0;
    }

    //取消关注
    public boolean userDisfollowApp(String userName,int AppId){
        User user=userService.selectUserByName(userName);
        App app=appService.selectAppById(AppId);
        AppFollowExample appFollowExample=new AppFollowExample();
        appFollowExample.createCriteria().andFollowappidEqualTo(app.getAppid()).andUseridEqualTo(user.getUserid());
        int i=appFollowMapper.deleteByExample(appFollowExample);
        return i>0;
    }
    //查询用户关注应用列表
    public List<AppFollow> getAppFollowList(String userName){
        User user=userService.selectUserByName(userName);
        List<AppFollow> appFollowList=new ArrayList<AppFollow>();
        AppFollowExample appFollowExample=new AppFollowExample();
        appFollowExample.createCriteria().andUseridEqualTo(user.getUserid());
        appFollowList=appFollowMapper.selectByExample(appFollowExample);
        return appFollowList;
    }
}
