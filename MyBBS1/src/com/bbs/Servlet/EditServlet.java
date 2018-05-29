package com.bbs.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;

import com.bbs.mapper.ArticlMapper;
import com.bbs.mapper.UserMapper;
import com.bbs.pojo.Articl;
import com.bbs.pojo.User;
import com.bbs.session.SessionFactory;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        SqlSession sqlSession=new SessionFactory().getSqlSession();
        ArticlMapper articlMapper=sqlSession.getMapper(ArticlMapper.class);
        Articl articl=new Articl();
        User user=new User();
        user=(User)request.getSession().getAttribute("User");
        int uid=user.getUid();
        //System.out.println("登录召唤："+user);
        articl.setUid(uid);
       //创建文件上传管理工厂
        DiskFileItemFactory fItemFactory=new DiskFileItemFactory();
        //创建文件上传对象
        ServletFileUpload upload = new ServletFileUpload(fItemFactory);
		//将请求的所有数据转成文件对象
        List<FileItem> list=null;
		try {
			list = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(list);
		Iterator<FileItem> iterator=list.iterator();
		
			//遍历整个表单集合
			while (iterator.hasNext()) {
				FileItem fileItem = iterator.next();	
				//普通的表单元素
				if(fileItem.isFormField()){
					if (fileItem.getFieldName().equals("topic")) {
						// 输出提取到的具体的值
						System.out.println("主题："
								+ fileItem.getString("UTF-8"));
						articl.setA_topic(fileItem.getString("UTF-8"));
					   }
					if(fileItem.getFieldName().equals("board")){
						System.out.println("板块："
					             +fileItem.getString("UTF-8") );
						int bid=Integer.parseInt(fileItem.getString("UTF-8"));
						articl.setBid(bid);
					}
					if(fileItem.getFieldName().equals("body")){
						System.out.println("内容"+fileItem.getString("UTF-8"));
						//response.getWriter().print(fileItem.getString("UTF-8"));
						articl.setA_body(fileItem.getString("UTF-8"));
					}
				}
			}
			 Date date=new Date();
             SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String time=df.format(date);
             articl.setCreat_time(time);
             articlMapper.addArticl(articl);
             sqlSession.commit();
             sqlSession.close();
             response.sendRedirect(request.getContextPath()+"/content/index.jsp");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
