package com.bbs.session;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public  class  SessionFactory {
     public SqlSession getSqlSession() throws IOException {
    	        //���غ��������ļ�
        InputStream inputStream=Resources.getResourceAsStream("sqlMapConfig.xml");
        //�����ػ�����
         SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
         //�������ݿ�Ự
         SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession;	
	}
}
