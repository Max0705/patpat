package com.etc.controller;

import com.etc.entity.*;
import com.etc.enums.ErrorEnum;
import com.etc.exception.MyException;
import com.etc.service.*;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController extends HttpServlet {
    @Autowired
    private UserService userService;
    @Autowired
    private AppFollowService appFollowService;
    @Autowired
    private AppService appService;
    @Autowired
    private UserFollowService userFollowService;
    @Autowired
    private GreatService greatService;
    @Autowired
    private LogService logService;

//    @RequestMapping(value = "/signin",method = RequestMethod.PUT)
////    @ResponseBody
    @PutMapping("/signin")
    public JsonResult signin(@RequestBody User user, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println(user.getUsername()+":"+user.getUserpwd());
//        System.out.println(userService.selectUserByName(user.getUsername()).getUserid());
        int i=userService.login(user.getUsername(),user.getUserpwd());
        if(i==0){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            //使用request对象的getSession()获取session，如果session不存在则创建一个
            HttpSession session = request.getSession();
            //将数据存储到session中
            session.setAttribute("username", user.getUsername());
            session.setAttribute("type","admin");
//            session.setAttribute("id",userService.selectUserByName(user.getUsername()).getUserid());
            return new JsonResult("管理员登录成功！"+session.getId());
        }
        else if (i==1){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            //使用request对象的getSession()获取session，如果session不存在则创建一个
            HttpSession session = request.getSession();
            //将数据存储到session中
            session.setAttribute("username", user.getUsername());
            session.setAttribute("type","user");
            session.setAttribute("id",userService.selectUserByName(user.getUsername()).getUserid());
            return new JsonResult("用户登录成功！"+session.getAttribute("type"));
        }
        else {
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("text/html;charset=UTF-8");
//            //使用request对象的getSession()获取session，如果session不存在则创建一个
//            HttpSession session = request.getSession();
//            //将数据存储到session中
//            session.setAttribute("username", null);
//            session.setAttribute("type",null);
//            session.setAttribute("id",null);
            return new JsonResult("登录失败！");
        }
    }

    @PostMapping("/signup")
    public JsonResult signup(@RequestBody User user){
        System.out.println(user.getUsername()+":"+user.getUserpwd());
        if (userService.selectUserByName(user.getUsername()).getUsername()!=null) {
            return new JsonResult("该用已存在，注册失败");
        }
            if (!userService.addUser(user)) {
                throw new MyException(ErrorEnum.ADD_ERROR);
            }

            return new JsonResult("注册成功");
    }

    @PutMapping("/user/updateUser")
    public JsonResult updateUser(@RequestBody User user){
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
    @DeleteMapping("/user/{userName}/unfollowUser/{followUserName}")
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
    public JsonResult userFollowApp(@PathVariable String userName, @PathVariable int appId){

        if(userService.userFollowApp(userName,appId)){
            logService.addActivity(userService.selectUserByName(userName).getUserid(),appId,2);
            return new JsonResult("App关注成功");
        }
        else return new JsonResult("App关注失败");
    }
    //用户取关应用
    @DeleteMapping("/user/{userName}/unfollowApp/{appId}")
    public JsonResult userDisfollowApp(@PathVariable String userName,@PathVariable int appId){
        if(userService.userDisfollowApp(userName,appId)){
            logService.addActivity(userService.selectUserByName(userName).getUserid(),appId,3);
            return new JsonResult("App取关成功");
        }
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
    //点赞
    @PutMapping("/user/{userId}/pressGreat/{commentId}")
    public JsonResult pressgreat(@PathVariable int userId,@PathVariable int commentId){
        if(!greatService.checkGreat(userId,commentId)){
            if(greatService.setGreat(userId,commentId))return new JsonResult("点赞成功");
            else return new JsonResult("点赞失败");
        }
        else {
            if(greatService.deleteGreat(userId,commentId))return new JsonResult("取消点赞成功");
            else return new JsonResult("取消点赞失败");
        }
    }
    //按用户获取记录
    @GetMapping("/user/getLog/{userId}")
    public JsonResult<UserActivity> getUserLog(@PathVariable int userId){
        return new JsonResult<UserActivity>(logService.getByUserId(userId));
    }
    //在跳转入应用主页面时调用,用于添加日志
    @PostMapping("/user/accessApp/log/{appId}")
    public JsonResult accessLog(@PathVariable int appId, HttpServletRequest request,HttpServletResponse response)
            {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
//        System.out.println(session.getId());
//        System.out.println(session.getAttribute("id"));
//        System.out.println(session.getAttribute("username"));
        if(session.getAttribute("id")!=null){
            logService.addActivity(Integer.parseInt(session.getAttribute("id").toString()),appId,4);
            return new JsonResult("已添加日志");
        }
        return new JsonResult("未添加日志");
    }
    //
    //测试
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return("hello world");
    }
    @GetMapping("/user/all")
    public JsonResult<User> getAllUser(){
        return new JsonResult<User>(userService.getall());
    }
    @PostMapping("/testlog")
    public JsonResult testAddLog(){
        return new JsonResult(logService.addActivity(1,1,1));
    }
}
