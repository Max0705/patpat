package com.etc.service;

import com.etc.dao.CommentMapper;
import com.etc.entity.Comment;
import com.etc.entity.CommentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    //添加评论
    public boolean createNewComment(Comment comment){
        return commentMapper.insertSelective(comment)>0;
    }
    //删除评论
    public boolean deleteComment(Integer Id){
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andCommentidEqualTo(Id);
        return commentMapper.deleteByExample(commentExample)>0;
    }
    //查看app下的评论
    public List<Comment> selectCommentByAppId(Integer appId){
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andAppidEqualTo(appId).andLastidEqualTo(0);
        return commentMapper.selectByExample(commentExample);
    }
    //查看评论详细信息
    public Comment selectCommentById(Integer Id){
        return commentMapper.selectByPrimaryKey(Id);
    }
    //查看评论下的回复
    public List<Comment> selectCommentByLasttId(Integer last_Id){
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andLastidEqualTo(last_Id);
        return commentMapper.selectByExample(commentExample);
    }
    //给评论点赞
    public boolean addCommentScore(Integer id){
        Comment comment=commentMapper.selectByPrimaryKey(id);
        comment.setCommentlike(comment.getCommentlike()+1);
        return commentMapper.updateByPrimaryKeySelective(comment)>0;
    }
}
