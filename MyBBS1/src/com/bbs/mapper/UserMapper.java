package com.bbs.mapper;
import java.util.List;

import com.bbs.pojo.User;

public interface UserMapper {
	    //检查
	    User checkUser(User user);
		//查询所有用户
		List<User> queryAllUser();
		//通过用户ID查用户
	    User findUserByID(int id);
	    //通过名字查用户
	    User findUserByname(String name);
	    //增加用户
	    void addUser(User user);
	    //更新资料
	    void updateUserById(User user);
	    //删除用户
	    void deleteUserByID(int id);
}
