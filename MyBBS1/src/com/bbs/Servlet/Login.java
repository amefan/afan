package com.bbs.Servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.bbs.mapper.UserMapper;
import com.bbs.pojo.User;
import com.bbs.session.SessionFactory;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
         response.setContentType("text/html;charset=utf-8");
		    String code=request.getParameter("code");
           String rpcode=(String)request.getSession().getAttribute("ycode");
           SqlSession sqlSession=new SessionFactory().getSqlSession();
           UserMapper uMapper=sqlSession.getMapper(UserMapper.class);
           User user=new User();
		    String name=request.getParameter("username");
		    user.setUname(name);
		    String password=request.getParameter("password");
		    user.setUpassword(password);
		    User u=uMapper.checkUser(user);
		    String isrber="";
		     isrber=request.getParameter("remember");
		    System.out.println(isrber);
		     if(code.equals(rpcode)){
       	        if(u==null){
       	           response.getWriter().println("验证 错误");
     	    	   response.getWriter().println("<a href=Login/sign-in.jsp>返回</a>");
       	        }
       	        if(u!=null){
       	        	if(isrber!=null){
       	        	     //创建两个Cookie对象
       	        	     Cookie nameCookie = new Cookie("username", URLEncoder.encode(name, "UTF-8"));
       	                 //设置Cookie的有效期为3天
       	        	     nameCookie.setMaxAge(60 * 60 * 24 * 3);
       	        	     Cookie pwdCookie = new Cookie("password",password);
       	        	     pwdCookie.setMaxAge(60 * 60 * 24 * 3);
       	                 response.addCookie(nameCookie);
       	                 response.addCookie(pwdCookie);
       	                 
       	                 System.out.println("记住");
       	        	}
       	        	HttpSession session=request.getSession();
       	        	session.setAttribute("User", u);
       	        	System.out.println(u.getUid());
       	        	response.sendRedirect(request.getContextPath()+"/content/index.jsp");
       	        }
		      }else{ 
   	    	   response.getWriter().println("验证码 错误");
   	    	   response.getWriter().println("<a href=Login/sign-in.jsp>返回</a>");
   	          }
		doGet(request, response);
	}

}
