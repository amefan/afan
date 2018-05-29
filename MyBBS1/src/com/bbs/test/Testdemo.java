package com.bbs.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bbs.mapper.ArticlMapper;
import com.bbs.mapper.ReplyMapper;
import com.bbs.mapper.UserMapper;
import com.bbs.pojo.Articl;
import com.bbs.pojo.Reply;
import com.bbs.pojo.User;
import com.bbs.session.SessionFactory;





public class Testdemo {
	@Test
         public  void test() throws IOException {
        	 //TODO Auto-generated method stub
       	  //让Session 帮我生成实现类（给接口）
       	    SqlSession sqlSession=new SessionFactory().getSqlSession();
             UserMapper uMapper=sqlSession.getMapper(UserMapper.class);
             User user=new User();
             user.setUname("小明");
             user.setUpassword("qwer");
             //User i=uMapper.checkUser(user);
             //List<User> user=uMapper.queryAllUser();
            ArticlMapper aMapper=sqlSession.getMapper(ArticlMapper.class);
            Articl articl=new Articl();
            articl.setAid(1);
            articl.setReply_count(1);;
            aMapper.addReply(articl);
             sqlSession.commit();
             sqlSession.close();
            // System.out.println(i);
            /* Date date=new Date();
             SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
             System.out.println(df.format(date));  
             String time=df.format(date);
            User user=new User("老王","1111","","136489@qq.com",time);
            uMapper.addUser(user);
            sqlSession.commit();
            sqlSession.close();*/
            
		}
      
}
