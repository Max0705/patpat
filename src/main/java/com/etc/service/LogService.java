package com.etc.service;

import com.etc.dao.UserActivityMapper;
import com.etc.entity.UserActivity;
import com.etc.entity.UserActivityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

@Service
public class LogService {
    @Autowired
    UserActivityMapper userActivityMapper;

    /**
     * 行为：
     * 1:access
     * 2:follow
     * 3:unfollow
     * 4:comment
     */

    //增加记录
    public boolean addActivity(int userId,int appId,int actionType){
        Date date = new Date();
        UserActivity userActivity=new UserActivity();
        userActivity.setActivitytype(actionType);
        userActivity.setUserid(userId);
        userActivity.setAppid(appId);
        userActivity.setActivitydate(date);
        int i=userActivityMapper.insertSelective(userActivity);
        return i>0;
    }
    //按照用户id查询
    public List<UserActivity> getByUserId(int userId){
        UserActivityExample userActivityExample=new UserActivityExample();
        userActivityExample.createCriteria().andUseridEqualTo(userId);
        return userActivityMapper.selectByExample(userActivityExample);
    }
    //按照appId查询
    public List<UserActivity> getByAppId(int appId){
        UserActivityExample userActivityExample=new UserActivityExample();
        userActivityExample.createCriteria().andAppidEqualTo(appId);
        return userActivityMapper.selectByExample(userActivityExample);
    }
    //按用户Id和APPID查询
    public List<UserActivity> getByUserIdandAppId(int userId,int appId){
        UserActivityExample userActivityExample=new UserActivityExample();
        userActivityExample.createCriteria().andAppidEqualTo(appId).andUseridEqualTo(userId);
        return userActivityMapper.selectByExample(userActivityExample);
    }
}
