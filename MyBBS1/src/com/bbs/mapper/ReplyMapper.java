package com.bbs.mapper;

import java.util.List;

import com.bbs.pojo.Reply;

public interface ReplyMapper {
	//ͨ�����Ӳ�����
	List<Reply> findReplyByAid(int aid);
	//�������
	void addReply(Reply reply);
	//ɾ������
	void deleteReplyById(int rid);

}
