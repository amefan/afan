package com.bbs.mapper;

import java.util.List;

import com.bbs.pojo.Reply;

public interface ReplyMapper {
	//通过帖子查评论
	List<Reply> findReplyByAid(int aid);
	//添加评论
	void addReply(Reply reply);
	//删除评论
	void deleteReplyById(int rid);

}
