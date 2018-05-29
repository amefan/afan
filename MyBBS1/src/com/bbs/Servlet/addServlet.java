package com.bbs.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.bbs.mapper.ArticlMapper;
import com.bbs.pojo.Articl;
import com.bbs.session.SessionFactory;

/**
 * Servlet implementation class addSerclet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        
        SqlSession sqlSession=new SessionFactory().getSqlSession();
        ArticlMapper articlMapper=sqlSession.getMapper(ArticlMapper.class);
        Articl articl=new Articl();
        
        String type=request.getParameter("type");
        String s_aid=request.getParameter("aid");
        int aid=Integer.parseInt(s_aid);
        
        
        articl=articlMapper.findArticlByAid(aid);
        int like=articl.getLike_count();
        int scan=articl.getScan_count();
        System.out.println(type+","+aid);
        if(type.equals("like")){
        	articl.setScan_count(scan+1);
        	articl.setLike_count(like+1);
        	articlMapper.addLike(articl);
        	articlMapper.addScan(articl);
        }
        if(type.equals("scan")){
        	articl.setScan_count(scan+1);
        	articlMapper.addScan(articl);
        }
        if(type.equals("zan")){
            int count=like+1;
        	articl.setLike_count(like+1);
        	articlMapper.addLike(articl);
        	System.out.println(count);
        	response.getWriter().write("{\"count\":count}");
        
        	}
        sqlSession.commit();
        sqlSession.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
