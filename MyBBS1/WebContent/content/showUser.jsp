<%@page import="com.bbs.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.bbs.session.SessionFactory, org.apache.ibatis.session.SqlSession,com.bbs.mapper.UserMapper" %>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Bootstrap基本模板</title>
		<!-- 引入Bootstrap核心样式文件 -->
		<link href="css/bootstrap.css" rel="stylesheet">
        <!-- 引入jQuery核心js文件 -->
		<script src="js/jquery-1.11.3.min.js"></script>
		<!-- 引入BootStrap核心js文件 -->
		<script src="js/bootstrap.js"></script>
	</head>
	<body>
		<div class="row">
			<div class="col-md-8  col-md-offset-2" style="margin-top: 35px; ">
	   	 		<a href="#" class="list-group-item active">用户</a>
	   	     <div class="list-group">
	   	     <% SqlSession sqlSession=new SessionFactory().getSqlSession();
                UserMapper uMapper=sqlSession.getMapper(UserMapper.class);
                List<User> uList=uMapper.queryAllUser();
                for(int i=0;i<uList.size();i++){
                	User user=uList.get(i);
              %>
			    <a href="#" class="list-group-item ">
		   	  		<img src=<%=user.getUheadimg() %> class="img-rounded" style="height: 65px;width: 65px;">
		   	  		<span href="#" class=" glyphicon glyphicon-user" style="margin-left: 15px;">ID:<%=user.getUid()%></span>
		   	  	    <span href="#" class=" glyphicon glyphicon-user" style="margin-left: 25px;">昵称:<%=user.getUname() %></span>
				    
				    <span href="#" class=" glyphicon glyphicon-comment" style="margin-left: 25px;">邮箱:<%=user.getUemail() %>
				    </a>
				    <button type="button" class="btn btn-danger" style="float: right;">删除用户</button>
	   	  	    </a>
	   	  	    <% 
	   	  	      } 
	   	  	    %>
             </div>
            </div>
		</div>
	</body>
</html>