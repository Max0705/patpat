package com.etc.service;

import com.etc.dao.UserFollowMapper;
import com.etc.entity.User;
import com.etc.entity.UserFollow;
import com.etc.entity.UserFollowExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFollowService {
    @Autowired
    UserService userService;
    @Autowired
    UserFollowMapper userFollowMapper;
    //关注用户
    public boolean userFollowUser(String followerName,String folledName){
        User follower=userService.selectUserByName(followerName);
        User folled=userService.selectUserByName(folledName);
        UserFollow userFollow=new UserFollow();
        userFollow.setUserid(follower.getUserid());
        userFollow.setFollowuserid(folled.getUserid());
        int i=userFollowMapper.insertSelective(userFollow);
        return i>0;
    }

    //取关用户
    public boolean userDisfollowUser(String followerName,String folledName){
        User follower=userService.selectUserByName(followerName);
        User folled=userService.selectUserByName(folledName);
        UserFollowExample userFollowExample=new UserFollowExample();
        userFollowExample.createCriteria().andFollowuseridEqualTo(folled.getUserid()).andUseridEqualTo(follower.getUserid());
        int i=userFollowMapper.deleteByExample(userFollowExample);
        return i>0;
    }
    //获取用户关注列表
    public List<UserFollow> getUserFollowList(String userName){
        List<UserFollow>list=new ArrayList<UserFollow>();
        UserFollowExample userFollowExample=new UserFollowExample();
        userFollowExample.createCriteria().andUseridEqualTo(userService.selectUserByName(userName).getUserid());
        list=userFollowMapper.selectByExample(userFollowExample);
        return list;
    }
    //获取粉丝列表
    public List<UserFollow> getFanList(String userName){
        List<UserFollow>list=new ArrayList<UserFollow>();
        UserFollowExample userFollowExample=new UserFollowExample();
        userFollowExample.createCriteria().andFollowuseridEqualTo(userService.selectUserByName(userName).getUserid());
        list=userFollowMapper.selectByExample(userFollowExample);
        return list;
    }
    //查看是否关注
    public boolean checkFollowUser(String userName,String followUserName){
        UserFollowExample userFollowExampl=new UserFollowExample();
        userFollowExampl.createCriteria().andUseridEqualTo(userService.selectUserByName(userName).getUserid())
                .andFollowuseridEqualTo(userService.selectUserByName(followUserName).getUserid());
        UserFollow userFollow=new UserFollow();
        if(userFollowMapper.selectByExample(userFollowExampl).isEmpty()) return false;
        else return true;
    }
}
