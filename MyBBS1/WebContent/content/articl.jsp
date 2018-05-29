<%@page import="java.util.ArrayList"%>
<%@page import="com.bbs.mapper.UserMapper"%>
<%@page import="com.bbs.pojo.Articl"%>
<%@page import="java.util.List"%>
<%@page import="com.bbs.mapper.ArticlMapper"%>
<%@page import="com.bbs.session.SessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.bbs.pojo.User"%>
<%@page import="com.bbs.pojo.Reply"%>
<%@page import="com.bbs.mapper.ReplyMapper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN" >

	<head>
		<meta charset="utf-8">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>帖子详情</title>
		<!-- 引入Bootstrap核心样式文件 -->
		<link href="css/bootstrap.css" rel="stylesheet">
        <!-- 引入jQuery核心js文件 -->
		<script src="js/jquery-1.11.3.min.js"></script>
		<!-- 引入BootStrap核心js文件 -->
		<script src="js/bootstrap.js"></script>
		<!--引入summer相关文件-->
		<link href="dist/summernote.css" rel="stylesheet"/>
		<script src="dist/summernote.js"></script>
		<script>
		    $(document).ready(function() {
			  $('#summernote').summernote({
			  	height: 100,                 // set editor height
				minHeight: null,             // set minimum height of editor
				maxHeight: null,             // set maximum height of editor
				focus: true,
				placeholder:"说点什么....."
			 })
	       });
       function change(p1){
		
				document.getElementById("zan").className="glyphicon glyphicon-heart";
				$.post(
						"/MyBBS1/addServlet",
						{"type":"zan","aid":p1},
						function(data){
							var a=document.getElementById("like");
							a.innerHTML=data.count;
						},
						"json"
						)
			};
			function isLogin(){
				  <%
				    User u=new User("未登录","*","../hendimg/1512741399204.jpg","不存在","");
				    User user = (User)session.getAttribute("User");
				    System.out.println("1"+user);
				    if(user==null){
				    	user=u;
				    %>
				      $("#t2").hide();
				      $("#tie").hide();
				      $("#r1").hide()
				   <% }
				   else{ %>
				       $("#t1").hide();
				       $("#r2").hide()
				<%}%>
				}
			 function resurm(){
			    	var markupStr = $('#summernote').summernote('code');
			    	document.getElementById("body").value=markupStr;
			    }
       </script>
	</head>
	<body onLoad="isLogin()">
      <!--导航条-->
      <nav class="navbar navbar-default navbar-static-top " style="width: 90%;background-color:#DCDCDC;display:table;margin:0 auto;">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">This's My BBS</a>
		    </div>

			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li class="active"><a href="index.jsp">最新 <span class="sr-only">(current)</span></a></li>
			        
			        <li class="active"><a href="#">热门<span class="sr-only">(current)</span></a></li>
			        
			        <li class="active " style="margin-left: 620px; "><a href="edit.jsp">发帖<span class="glyphicon glyphicon-pencil"></span></a></li>
			         <li id="t2"><a href="<%=request.getContextPath() %>/LogoutServlet">退出</a></li>
			      </ul>
			      
			      <ul class="nav navbar-nav navbar-right">
			         <div id="t1">
				        <li><a href="../Login/sign-in.jsp">Sing in</a></li>
				        <li><a>or</a></li>
				        <li><a href="../Login/sign-up .jsp">Sing up</li>
				        </div>
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
			<!--帖子区-->
		<div class="row">
			<div class="col-md-7 col-md-offset-1" style="margin-top: 20px;">
			   <% int aid=Integer.parseInt(request.getParameter("aid"));
			   SqlSession sqlsession=new SessionFactory().getSqlSession();
	  	       ArticlMapper articMapper=sqlsession.getMapper(ArticlMapper.class);
	   	       UserMapper uMapper=sqlsession.getMapper(UserMapper.class);
	   	       User user1=new User();
	   	       Articl articl=articMapper.findArticlByAid(aid);
	   	       user1 =uMapper.findUserByID(articl.getUname());
	   	       %>
				<a  class="list-group-item">
				<img src=<%=user1.getUheadimg() %> style="height: 70px;width: 70px; " class="img-circle" >
				<span style="font-size:20px"><%=user1.getUname() %></span>
				<h2><%=articl.getA_topic() %></h2>
				<p class="lead"><%=articl.getA_body() %></p>
				<div style="margin-top: 70px;">
				<span class="badge" style="float: right;"><%=articl.getReply_count() %></span>
	            <span id="zan" class="glyphicon  glyphicon-heart-empty" style="padding-left: 25px;" onclick="change(<%=articl.getAid() %>)"></span>
	            <span class="glyphicon glyphicon-eye-open" style="float:left;"> <%=articl.getScan_count() %></span>
	            <span style="margin-left: 10px;" id="like"><%=articl.getLike_count() %></span>
	            </div>
	            </a>
	            <!--
                	描述：评论区
                -->
                 
                
                <div class="list-group" style="margin-top: 30px;">
                	  <a class=" list-group-item-info"><h3>评论</h3></a>
                	   <%
		                   ReplyMapper rMapper=sqlsession.getMapper(ReplyMapper.class);
		                   List<Reply> list =new ArrayList();
		                   Reply reply=new Reply();
		                   User user2=new User();
		                   list=rMapper.findReplyByAid(articl.getAid());
		                   if(list!=null){
	                	  for(int i=0;i<list.size();i++){
	                		  reply=list.get(i);
	                		  user2=uMapper.findUserByID(reply.getUid());
                	   %>	 
					  <a  class="list-group-item">
					  	<img src=<%=user2.getUheadimg() %> style="height: 50px;width: 50px; " class="img-circle" >&nbsp;&nbsp;
					  	<span style="font-size: 15px;margin-top: 100px;"><%=user2.getUname() %></span>
					    <h5 class="list-group-item-heading" style="margin-left: 70px;"><%=reply.getR_body()%></h5>
					  </a>
					  <% 
                	    }
                        }else{
                	
                      %>
                      <a  class="list-group-item">
                       <h3>还没有评论，快来抢沙发！！1</h3>
                      </a>
                      <%
                        }
                      %>
                </div>
                
                <!--
                	描述：评论框
                -->
                
                 <div id="r1">
                 <form action="toart.jsp" action="post">
                 <div id="summernote" name="rebody"></div>
                 　                          <input type="hidden" name="body" id="body" value="">
                 <input type="hidden" name="uid" id="uid" value=<%=user.getUid() %>>
                 <input type="hidden" name="aid" id="aid" value=<%=articl.getAid() %>>
                 <input type="submit" class="btn btn-warning" value="评论" onclick="resurm()">
                 </form>
                 </div>
                 
                 <div id="r2">
                     <h2>请登录后再评论！</h2>
                 </div>
			</div>
			
			
			
			<div class="col-md-3" style="margin-top: 20px;">
		   	   <p><img src=<%=user.getUheadimg() %> class="img-rounded" style="height: 65px;width: 65px;"></p>
		   	   <div class="list-group">
				  <a href="" class="list-group-item active">
				     信息个人
				  </a>
				   	<a href="#" class="list-group-item glyphicon glyphicon-user">昵称：<%=user.getUname() %></a>
					<a href="#" class="list-group-item glyphicon glyphicon-leaf">  个性签名：：不一样的我</a>
					<a href="#" class="list-group-item glyphicon glyphicon-comment">  帖子数量：<%=(int)(Math.random()*10)%></a>
				  	<a href="#" class="list-group-item glyphicon glyphicon-wrench">邮箱：：<%=user.getUemail()%></a>
			  </div>
            </div>
		</div>
	</body>
</html>