package com.etc.controller;

import com.etc.entity.JsonResult;
import com.etc.entity.User;
import com.etc.enums.ErrorEnum;
import com.etc.exception.MyException;
import com.etc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
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
    @PutMapping("/user/{userName}/follow/{followUserName}")
    public JsonResult userFollow(@PathVariable String userName,@PathVariable String followUserName){
        if(userService.userFollowUser(userName,followUserName))return new JsonResult("关注成功");
        else return new JsonResult("关注失败");
    }
    //用户取关用户
    @DeleteMapping("/user/{userName}/disfollow/{followUserName}")
    public JsonResult userDisFollow(@PathVariable String userName,@PathVariable String followUserName){
        if(userService.userDisfollowUser(userName,followUserName))return new JsonResult("取关成功");
        else return new JsonResult("取关失败");
    }
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
