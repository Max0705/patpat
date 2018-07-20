package com.etc.service;

import com.etc.dao.AdminMapper;
import com.etc.dao.UserMapper;
import com.etc.entity.Admin;
import com.etc.entity.AdminExample;
import com.etc.entity.User;
import com.etc.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    public boolean addUser(User user){
        int i=userMapper.insertSelective(user);
        return i>0;
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

    public User selectUserById(Integer Id){
        User user=new User();
        UserExample userExample=new UserExample();
        user=userMapper.selectByPrimaryKey(Id);
        return user;
    }

    //登录，返回-1为登录失败，0为管理员，1为普通用户
    public int login(String userName){
        AdminExample adminExample=new AdminExample();
        adminExample.createCriteria().andAdminnameEqualTo(userName);
        for(Admin admin:adminMapper.selectByExample(adminExample)){
            if(admin.getAdminname()!=null)return 0;
        }

        UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName);
        for(User user:userMapper.selectByExample(userExample)){
            if(user.getUsername()!=null) return 1;
        }
        return -1;
    }
}
