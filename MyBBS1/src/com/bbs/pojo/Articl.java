package com.bbs.pojo;
/*create table articl(
	 	aid int(11) not null auto_increment,
	 	bid int(10) not null,
	 	uname varchar(11) not null,
	 	reply_count int(11) DEFAULT '0',
	    like_count int(11) DEFAULT '0',
	    scan_count  int(11) DEFAULT '0',
	 	a_topic varchar(50) not null,
	 	a_body text not null,
	 	create_time datetime not null,
	 	primary key(aid)
	 	)
	 	*/

import java.util.Date;

public class Articl {
    /***帖子****/
	int aid;
	int bid;//板块ID
	int uid;//发帖人；
	int reply_count;//评论数
	int like_count;//赞
	int scan_count;//查看人数
	String a_topic;//帖子主题
	String a_body;//帖子内容
	String create_time;//发帖时间
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getUname() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public int getScan_count() {
		return scan_count;
	}
	public void setScan_count(int scan_count) {
		this.scan_count = scan_count;
	}
	public String getA_topic() {
		return a_topic;
	}
	public void setA_topic(String a_topic) {
		this.a_topic = a_topic;
	}
	public String getA_body() {
		return a_body;
	}
	public void setA_body(String a_body) {
		this.a_body = a_body;
	}
	public String getCreat_time() {
		return create_time;
	}
	public void setCreat_time(String creat_time) {
		this.create_time = creat_time;
	}
	@Override
	public String toString() {
		return "Articl [bid=" + bid + ", uid=" + uid + ", reply_count=" + reply_count + ", like_count=" + like_count
				+ ", scan_count=" + scan_count + ", a_topic=" + a_topic + ", a_body=" + a_body + ", creat_time="
				+ create_time + "]";
	}
	
}
