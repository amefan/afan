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
       //�����ļ��ϴ�������
        DiskFileItemFactory fItemFactory=new DiskFileItemFactory();
        //�����ļ��ϴ�����
        ServletFileUpload upload = new ServletFileUpload(fItemFactory);
		//���������������ת���ļ�����
        List<FileItem> list=null;
		try {
			list = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(list);
		Iterator<FileItem> iterator=list.iterator();
		
			//��������������
			while (iterator.hasNext()) {
				FileItem fileItem = iterator.next();	
				//��ͨ�ı�Ԫ��
				if(fileItem.isFormField()){
					if (fileItem.getFieldName().equals("name")) {
						// �����ȡ���ľ����ֵ
						System.out.println("�û�����Ϊ��"
								+ fileItem.getString());
						user.setUname(fileItem.getString("UTF-8"));
						User u1=uMapper.findUserByname(fileItem.getString("UTF-8"));
						
						if(u1!=null){
							response.getWriter().print("<srcipt type='text/javascript'>");
				        	response.getWriter().print("alter('�ǳ��Ѵ���')");
				        	response.getWriter().print("window.loacation='sign-up.jsp'");
				        	response.getWriter().print("</srcipt>");
						}
					}
					if (fileItem.getFieldName().equals("password")) {
						// �����ȡ���ľ����ֵ
						System.out.println("���룺"
								+ fileItem.getString());
						user.setUpassword(fileItem.getString());
					}
					if (fileItem.getFieldName().equals("email")) {
						// �����ȡ���ľ����ֵ
						System.out.println("���䣺"
								+ fileItem.getString());
						user.setUemail(fileItem.getString());
					}
					 
				}
				// <input type="file">���ϴ��ļ���Ԫ��  
				else if(fileItem.getName()!=""){
					String fileName=fileItem.getName();
					//Դ�ļ���
					System.out.println("Դ�ļ���:"+fileName);
					String suffix = fileName.substring(fileName.lastIndexOf('.'));  
		            //System.out.println("��չ����" + suffix);// .jpg
		         // ���ļ�����Ψһ��  
		            String newFileName = new Date().getTime() + suffix;  
		            System.out.println("���ļ�����" + newFileName);// image\1478509873038.jpg
		            // 5. ����FileItem��write()������д���ļ�  
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
