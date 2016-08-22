package cn.com.service;

import java.util.Map;

import cn.com.pojo.*;

public interface ICommentService {
	public boolean addComment(Comment1 comment) ;
	public boolean deleteComment(Comment1 comment);
	public Comment1 getComment(Comment1 comment);
	public Map<Long, Comment1> getTheTowComment(Comment1 comment,int min,int max);
}
