package com.etc.controller;

import com.etc.entity.Comment;
import com.etc.service.CommentService;
import com.etc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private LogService logService;

    @ResponseStatus(value= HttpStatus.ACCEPTED)
    @RequestMapping(value = "/comment/addNew",method = RequestMethod.POST)
    @ResponseBody
    public boolean addComment(@RequestBody Comment comment){
        comment.setLastid(0);
        logService.addActivity(comment.getUserid(),comment.getAppid(),4);
        return commentService.createNewComment(comment);
    }

    @ResponseStatus(value= HttpStatus.ACCEPTED)
    @RequestMapping(value = "/comment/addAnswer",method = RequestMethod.POST)
    @ResponseBody
    public boolean insertComment(@RequestBody Comment comment){
        return commentService.insertComment(comment);
    }

    @ResponseStatus(value= HttpStatus.ACCEPTED)
    @RequestMapping(value = "/comment/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteComment(@RequestParam Integer id){
        return commentService.deleteComment(id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/comment/app",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getCommentByAppId(@RequestParam Integer appid){
        List<Comment> comments=commentService.selectCommentByAppId(appid);
        List<Comment> commentsList=new ArrayList<>();
        for(int i=0;i<comments.size();i++){
            if(comments.get(i).getLastid()==0)commentsList.add(comments.get(i));
        }
        return commentsList;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/comment/Id",method = RequestMethod.GET)
    @ResponseBody
    public Comment getCommentById(@RequestParam Integer id){
        return commentService.selectCommentById(id);
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/comment/LastId",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getCommentByLastId(@RequestParam Integer lastid){
        return commentService.selectCommentByLasttId(lastid);
    }
}
