package com.bbs.mapper;
import java.util.List;

import com.bbs.pojo.User;

public interface UserMapper {
	    //���
	    User checkUser(User user);
		//��ѯ�����û�
		List<User> queryAllUser();
		//ͨ���û�ID���û�
	    User findUserByID(int id);
	    //ͨ�����ֲ��û�
	    User findUserByname(String name);
	    //�����û�
	    void addUser(User user);
	    //��������
	    void updateUserById(User user);
	    //ɾ���û�
	    void deleteUserByID(int id);
}
