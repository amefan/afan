package com.bbs.pojo;

import java.util.Date;

/*create table user(
	       uid int(11) not null auto_increment,
	       uname varchar(20) not null,
	       upassword varchar(20) not null,
	       uheadimg varchar(40) ,
	       uemail varchar(30) not null,
	       create_time  datetime not null,
	       primary key (uid) 
	*/
public class User {
	/**用户信息**/
	int uid;
	String uname;//用户昵称
	String upassword;//密码
	String uheadimg ;//头像路径
	String uemail;//邮箱
	String create_time;//创号时间
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String uname, String upassword, String uheadimg, String uemail, String creat_time) {
		super();
		
		this.uname = uname;
		this.upassword = upassword;
		this.uheadimg = uheadimg;
		this.uemail = uemail;
		this.create_time = creat_time;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUheadimg() {
		return uheadimg;
	}
	public void setUheadimg(String uheadimg) {
		this.uheadimg = uheadimg;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String time) {
		this.create_time = time;
	}
	@Override
	public String toString() {
		return "User [id="+uid +",uname=" + uname + ", upassword=" + upassword + ", uheadimg=" + uheadimg + ", uemail=" + uemail
				+ ", creat_time=" + create_time + "]";
	}
	
	
}
