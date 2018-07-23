package com.etc.service;

import com.etc.dao.AdminMapper;
import com.etc.dao.AppFollowMapper;
import com.etc.dao.UserFollowMapper;
import com.etc.dao.UserMapper;
import com.etc.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AppFollowMapper appFollowMapper;
    @Autowired
    private UserFollowMapper userFollowMapper;
    @Autowired
    private AppService appService;

    //在使用前需检测有无重名
    public boolean addUser(User user) {
        int i = userMapper.insertSelective(user);
        return i > 0;
    }

    public boolean updateUserById(User user){
        int i=userMapper.updateByPrimaryKeySelective(user);
        return i>0;
    }

    public boolean updateUserByEmail(User user){
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUseremailEqualTo(user.getUseremail());
        int i=userMapper.updateByExampleSelective(user,userExample);
        return i>0;
    }

    public boolean updateUserByName(User user){
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        int i=userMapper.updateByExampleSelective(user,userExample);
        return i>0;
    }

    public User selectUserByName(String name){
        User user=new User();
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(name);
        for(User u:userMapper.selectByExample(userExample)){
            user=u;
        }
        return user;
    }

    //不显示密码
    public User otherSelectUserByName(String name){
        User user=new User();
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(name);
        for(User u:userMapper.selectByExample(userExample)){
            user=u;
        }
        user.setUserpwd("保密");
        return user;
    }

    public User selectUserById(Integer Id){
        User user=new User();
        UserExample userExample=new UserExample();
        user=userMapper.selectByPrimaryKey(Id);
        return user;
    }

    //不显示密码
    public User otherSelectUserById(Integer Id){
        User user=new User();
        UserExample userExample=new UserExample();
        user=userMapper.selectByPrimaryKey(Id);
        user.setUserpwd("保密");
        return user;
    }

    //登录，返回-1为登录失败，0为管理员，1为普通用户
    public int login(String userName,String passWord){
        AdminExample adminExample=new AdminExample();
        adminExample.createCriteria().andAdminnameEqualTo(userName);
        for(Admin admin:adminMapper.selectByExample(adminExample)){
            if(admin.getAdminname()!=null&&passWord.equals(admin.getAdminpwd()))return 0;
        }

        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName);
        for(User user:userMapper.selectByExample(userExample)){
            if(user.getUsername()!=null&&passWord.equals(user.getUserpwd())) return 1;
        }
        return -1;
    }

    //关注应用
    public boolean userFollowApp(String userName,int AppId){
        User user=selectUserByName(userName);
        App app=appService.selectAppById(AppId);
        AppFollow appFollow=new AppFollow();
        appFollow.setFollowappid(app.getAppid());
        appFollow.setUserid(user.getUserid());
        int i=appFollowMapper.insertSelective(appFollow);
        return i>0;
    }

    //取消关注
    public boolean userDisfollowApp(String userName,int AppId){
        User user=selectUserByName(userName);
        App app=appService.selectAppById(AppId);
        AppFollowExample appFollowExample=new AppFollowExample();
        appFollowExample.createCriteria().andFollowappidEqualTo(app.getAppid()).andUseridEqualTo(user.getUserid());
        int i=appFollowMapper.deleteByExample(appFollowExample);
        return i>0;
    }

    //关注用户
    public boolean userFollowUser(String followerName,String folledName){
        User follower=selectUserByName(followerName);
        User folled=selectUserByName(folledName);
        UserFollow userFollow=new UserFollow();
        userFollow.setUserid(follower.getUserid());
        userFollow.setFollowuserid(folled.getUserid());
        int i=userFollowMapper.insertSelective(userFollow);
        return i>0;
    }

    //取关用户
    public boolean userDisfollowUser(String followerName,String folledName){
        User follower=selectUserByName(followerName);
        User folled=selectUserByName(folledName);
        UserFollowExample userFollowExample=new UserFollowExample();
        userFollowExample.createCriteria().andFollowuseridEqualTo(folled.getUserid()).andUseridEqualTo(follower.getUserid());
        int i=userFollowMapper.deleteByExample(userFollowExample);
        return i>0;
    }

    //删除用户信息
    public boolean deleteUserById(Integer Id){
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUseridEqualTo(Id);
        return userMapper.deleteByExample(userExample)>0;
    }
}
