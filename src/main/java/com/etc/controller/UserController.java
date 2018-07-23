package com.etc.controller;

import com.etc.entity.*;
import com.etc.enums.ErrorEnum;
import com.etc.exception.MyException;
import com.etc.service.AppFollowService;
import com.etc.service.AppService;
import com.etc.service.UserFollowService;
import com.etc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AppFollowService appFollowService;
    @Autowired
    private AppService appService;
    @Autowired
    private UserFollowService userFollowService;

    @GetMapping("/signin")
    public JsonResult signin(String userName,String passWord){
        int i=userService.login(userName,passWord);
        if(i==0)return new JsonResult("管理员登录成功！");
        else if (i==1)return new JsonResult("用户登录成功！");
        else return new JsonResult("登录失败！");
    }

    @PostMapping("/signup")
    public JsonResult signup(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new MyException(ErrorEnum.CHECK_ERROR,bindingResult.getFieldError().getDefaultMessage());
        }
        if (userService.selectUserByName(user.getUsername())!=null) {
            return new JsonResult("该用已存在，注册失败");
        }
            if (!userService.addUser(user)) {
                throw new MyException(ErrorEnum.ADD_ERROR);
            }

            return new JsonResult("注册成功");
    }

    @PutMapping("/user/updateUser")
    public JsonResult updateUser(User user){
        if(userService.updateUserByName(user))return new JsonResult("修改成功");
        else return new JsonResult("修改失败");
    }
    //按照名字获取用户信息
    @GetMapping("/user/getUser/{userName}")
    public JsonResult<User> getUserInfo(@PathVariable String userName){
        return new JsonResult<User>(userService.selectUserByName(userName));
    }
    //用户关注用户
    @PostMapping("/user/{userName}/followUser/{followUserName}")
    public JsonResult userFollow(@PathVariable String userName,@PathVariable String followUserName){
        if(userFollowService.checkFollowUser(userName,followUserName))return new JsonResult("用户已关注");
        if(userService.userFollowUser(userName,followUserName))return new JsonResult("用户关注成功");
        else return new JsonResult("用户关注失败");
    }
    //判断是否已关注该用户
    @GetMapping("/user/{userName}/checkFollowUser/{followUserName}")
    public JsonResult checkFollowUsered(@PathVariable String userName,@PathVariable String followUserName){
        return new JsonResult(userFollowService.checkFollowUser(userName,followUserName));
    }
    //用户取关用户
    @DeleteMapping("/user/{userName}/disfollowUser/{followUserName}")
    public JsonResult userDisFollow(@PathVariable String userName,@PathVariable String followUserName){
        if(userService.userDisfollowUser(userName,followUserName))return new JsonResult("用户取关成功");
        else return new JsonResult("用户取关失败");
    }
    //获取用户关注用户列表
    @GetMapping("/user/{userName}/userFollowList")
    public JsonResult<User> getUserFollowUserList(@PathVariable String userName){
        List<User> userList=new ArrayList<User>();
        for(UserFollow userFollow:userFollowService.getUserFollowList(userName)){
            userList.add(userService.otherSelectUserById(userFollow.getFollowuserid()));
        }
        return new JsonResult<User>(userList);
    }
    //获取粉丝列表
    @GetMapping("/user/{userName}/fanList")
    public JsonResult<User> getFanList(@PathVariable String userName){
        List<User> userList=new ArrayList<User>();
        for(UserFollow userFollow:userFollowService.getFanList(userName)){
            userList.add(userService.otherSelectUserById(userFollow.getUserid()));
        }
        return new JsonResult<User>(userList);
    }
    //用户关注应用
    @PostMapping("/user/{userName}/followApp/{appId}")
    public JsonResult userFollowApp(@PathVariable String userName,@PathVariable int appId){
        if(userService.userFollowApp(userName,appId))return new JsonResult("App关注成功");
        else return new JsonResult("App关注失败");
    }
    //用户取关应用
    @DeleteMapping("/user/{userName}/disfollowApp/{appId}")
    public JsonResult userDisfollowApp(@PathVariable String userName,@PathVariable int appId){
        if(userService.userDisfollowApp(userName,appId))return new JsonResult("App取关成功");
        else return new JsonResult("App取关失败");
    }
    //获取用户关注App列表
    @GetMapping("/user/{userName}/appFollowList")
    public JsonResult<App> getUserFollowAppList(@PathVariable String userName){
        List<App> appList=new ArrayList<App>();
        for(AppFollow appFollow:appFollowService.getAppFollowList(userName)){
            appList.add(appService.selectAppById(appFollow.getFollowappid()));
        }
        return new JsonResult<App>(appList);
    }
    //删除用户
    @DeleteMapping("/user/{userid}")
    public JsonResult userDelete(@PathVariable Integer userid){
        if(userService.deleteUserById(userid)) return new JsonResult("删除成功");
        else return new JsonResult("删除失败");
    }
    //
    //测试
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return("hello world");
    }
    //删除用户

}
