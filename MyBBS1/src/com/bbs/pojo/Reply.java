package com.bbs.pojo;
/*create table reply(
	  	rid int(10) not null,
	  	aid int(11) not null,
	  	uid varchar(11) not null,
	  	r_body varchar(200) not null,
	  	primary KEY(rid)
	  	)*/
public class Reply {
  /** ����*/
	int aid;//����������ID��
	int uid;//������ID
	String r_body; //��������
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getR_body() {
		return r_body;
	}
	public void setR_body(String r_body) {
		this.r_body = r_body;
	}
	@Override
	public String toString() {
		return "Reply [aid=" + aid + ", uname=" + uid + ", r_body=" + r_body + "]";
	}
	
}
