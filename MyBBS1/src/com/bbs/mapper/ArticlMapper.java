package com.bbs.mapper;

import java.util.List;

import com.bbs.pojo.Articl;


public interface ArticlMapper {
	void addScan(Articl articl);
	void addLike(Articl articl);
	void addReply(Articl articl);
	//��ѯ������Ϣ
   List<Articl> queryAllArticl();
   //ͨ��aid��ѯ������Ϣ
   Articl findArticlByAid(int aid);
   //ͨ��uid��
   List<Articl> findArticlByUid(int uid);
   //ͨ��bid��
   List<Articl> findArticlBid(int bid);
   //����
   void addArticl(Articl articl);
   //����
   void updateArticl(Articl articl);
   //ɾ��
   void deleteArticl(int aid);
}
