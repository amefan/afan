package com.bbs.session;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public  class  SessionFactory {
     public SqlSession getSqlSession() throws IOException {
    	        //加载核心配置文件
        InputStream inputStream=Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建回话工厂
         SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
         //创建数据库会话
         SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession;	
	}
}
