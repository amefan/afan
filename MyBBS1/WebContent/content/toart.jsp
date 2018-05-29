<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.bbs.session.SessionFactory"%>
<%@page import="com.bbs.pojo.Reply"%>
<%@page import="com.bbs.mapper.ReplyMapper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
    <%
    
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
    //数据亏操作
     rMapper.addReply(reply);
     sqlSession.commit();
     sqlSession.close();
   
    %>
<body>
     <div style="text-align:center">
        <h3>评价成功，3秒后自动返回...</h3> 
     </div>
</body>
 <script type="text/javascript"> 
//3秒钟之后跳转到指定的页面 
setTimeout("window.location.href='articl.jsp?aid=<%=aid%>'",3000); 
</script>
</html>
