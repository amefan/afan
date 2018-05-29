 package com.bbs.Servlet;

import java.io.File;
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
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;
import org.apache.commons.*;

import com.bbs.mapper.UserMapper;
import com.bbs.pojo.User;
import com.bbs.session.SessionFactory;


/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    @Override
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        SqlSession sqlSession=new SessionFactory().getSqlSession();
        UserMapper uMapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
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
					if (fileItem.getFieldName().equals("name")) {
						// 输出提取到的具体的值
						System.out.println("用户姓名为："
								+ fileItem.getString());
						user.setUname(fileItem.getString("UTF-8"));
						User u1=uMapper.findUserByname(fileItem.getString("UTF-8"));
						
						if(u1!=null){
							response.getWriter().print("<srcipt type='text/javascript'>");
				        	response.getWriter().print("alter('昵称已存在')");
				        	response.getWriter().print("window.loacation='sign-up.jsp'");
				        	response.getWriter().print("</srcipt>");
						}
					}
					if (fileItem.getFieldName().equals("password")) {
						// 输出提取到的具体的值
						System.out.println("密码："
								+ fileItem.getString());
						user.setUpassword(fileItem.getString());
					}
					if (fileItem.getFieldName().equals("email")) {
						// 输出提取到的具体的值
						System.out.println("邮箱："
								+ fileItem.getString());
						user.setUemail(fileItem.getString());
					}
					 
				}
				// <input type="file">的上传文件的元素  
				else if(fileItem.getName()!=""){
					String fileName=fileItem.getName();
					//源文件名
					System.out.println("源文件名:"+fileName);
					String suffix = fileName.substring(fileName.lastIndexOf('.'));  
		            //System.out.println("扩展名：" + suffix);// .jpg
		         // 新文件名（唯一）  
		            String newFileName = new Date().getTime() + suffix;  
		            System.out.println("新文件名：" + newFileName);// image\1478509873038.jpg
		            // 5. 调用FileItem的write()方法，写入文件  
		            String pa = getServletContext().getRealPath("/");
		    		pa = pa.substring(0, pa.indexOf("\\.")).replace("\\", "/");
		    		String th = request.getContextPath().replace("\\", "/");

		    		//System.out.println(pa + th);
		            String path=(pa+th)+"/WebContent/hendimg/";
		            String headimg="../hendimg/"+newFileName;
		            user.setUheadimg(headimg);
		           
		            File file = new File(path + newFileName);  
		            System.out.println(file.getAbsolutePath());  
						try {
							
							fileItem.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				    }
				}
				else if(fileItem.getName()==""){
					String str="../hendimg/1512741399204.jpg";
					user.setUheadimg(str);
				}
				fileItem.delete();
			}
			System.out.println(user);
			 Date date=new Date();
	            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            String time=df.format(date);
	            user.setCreate_time(time);
             uMapper.addUser(user);
             sqlSession.commit();
             sqlSession.close();
            response.sendRedirect(request.getContextPath()+"/Login/sign-in.jsp");
	}

	
   
	protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
	
}
