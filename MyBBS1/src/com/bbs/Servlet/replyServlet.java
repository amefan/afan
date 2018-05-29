package com.bbs.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.bbs.mapper.ReplyMapper;
import com.bbs.pojo.Reply;
import com.bbs.session.SessionFactory;

/**
 * Servlet implementation class inServlet
 */
@WebServlet("/replyServlet")
public class replyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public replyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath()+"/Login/sign-in.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        
        String s_aid;
        String uName;
        String rebody;
        SqlSession sqlSession=new SessionFactory().getSqlSession();
        ReplyMapper rMapper=sqlSession.getMapper(ReplyMapper.class);
        Reply reply=new Reply();
        
        s_aid=request.getParameter("aid");
        int aid=Integer.parseInt(s_aid);
        reply.setAid(aid);
        
        uName=request.getParameter("uid");
        int uid=Integer.parseInt(uName);
        reply.setUid(uid);
        
        rebody=request.getParameter("body");
        reply.setR_body(rebody);
        
        System.out.println(aid + uid);
        //Êý¾Ý¿÷²Ù×÷
        rMapper.addReply(reply);
        sqlSession.commit();
        sqlSession.close();
        
       response.sendRedirect(request.getContextPath()+"/content/articl.jsp?"+"aid="+aid);
	}

}
