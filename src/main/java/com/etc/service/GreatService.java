package com.etc.service;

import com.etc.dao.CommentMapper;
import com.etc.dao.GreatMapper;
import com.etc.entity.Comment;
import com.etc.entity.Great;
import com.etc.entity.GreatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreatService {
    @Autowired
    GreatMapper greatMapper;
    @Autowired
    CommentMapper commentMapper;

    //点赞
    public boolean setGreat(int userId,int commentId){
        Great great=new Great();
        great.setUserid(userId);
        great.setCommentid(commentId);
        Comment comment=new Comment();
        comment=commentMapper.selectByPrimaryKey(commentId);
        comment.setCommentlike(comment.getCommentlike()+1);
        commentMapper.updateByPrimaryKey(comment);
        int i=greatMapper.insertSelective(great);
        return i>0;
    }

    public boolean deleteGreat(int userId,int commentId){
        GreatExample greatExample=new GreatExample();
        greatExample.createCriteria().andCommentidEqualTo(commentId).andUseridEqualTo(userId);
        Comment comment=new Comment();
        comment=commentMapper.selectByPrimaryKey(commentId);
        comment.setCommentlike(comment.getCommentlike()-1);
        commentMapper.updateByPrimaryKey(comment);
        int i=greatMapper.deleteByExample(greatExample);
        return i>0;
    }

    public boolean checkGreat(int userId,int commentId){
        GreatExample greatExample=new GreatExample();
        greatExample.createCriteria().andCommentidEqualTo(commentId).andUseridEqualTo(userId);
        System.out.println(greatMapper.selectByExample(greatExample));
        System.out.println(greatMapper.selectByExample(greatExample).isEmpty());
        if(greatMapper.selectByExample(greatExample).isEmpty())return false;
        else return true;
    }
}
