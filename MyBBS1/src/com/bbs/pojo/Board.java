package com.bbs.pojo;
/*create table board(
	 	bid int(10) not null ,
	 	bname varchar(20) not null,
	    primary key(bid),
	     create_time datetime not null
	 	)*/

import java.util.Date;

public class Board {
  /****Ìû×Ó°å¿é****/
	int bid;
	String bname;
	Date create_time;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Board [bid=" + bid + ", bname=" + bname + ", create_time=" + create_time + "]";
	}
	
}
