package com.bbs.pojo;

/*create table  admin(
		aname varchar(10) not null ,
		apassword varchar(15) not null,
		primary key (aname)
*/
public class Admin {
     /****π‹¿Ì‘±’À∫≈√‹¬Î***/
	String aname;
	String apassword;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	
}
