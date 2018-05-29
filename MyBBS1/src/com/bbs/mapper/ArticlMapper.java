package com.bbs.mapper;

import java.util.List;

import com.bbs.pojo.Articl;


public interface ArticlMapper {
	void addScan(Articl articl);
	void addLike(Articl articl);
	void addReply(Articl articl);
	//查询发帖信息
   List<Articl> queryAllArticl();
   //通过aid查询发帖信息
   Articl findArticlByAid(int aid);
   //通过uid查
   List<Articl> findArticlByUid(int uid);
   //通过bid查
   List<Articl> findArticlBid(int bid);
   //发帖
   void addArticl(Articl articl);
   //更新
   void updateArticl(Articl articl);
   //删帖
   void deleteArticl(int aid);
}
