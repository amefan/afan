<%@page import="com.bbs.mapper.UserMapper"%>
<%@page import="com.bbs.pojo.Articl"%>
<%@page import="java.util.List"%>
<%@page import="com.bbs.mapper.ArticlMapper"%>
<%@page import="com.bbs.session.SessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@page import="com.bbs.pojo.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
             
	<head>
		<meta charset="utf-8">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>首页</title>
		<!-- 引入Bootstrap核心样式文件 -->
		<link href="css/bootstrap.css" rel="stylesheet">
        <!-- 引入jQuery核心js文件 -->
		<script src="js/jquery-1.11.3.min.js"></script>
		<!-- 引入BootStrap核心js文件 -->
		<script src="js/bootstrap.js"></script>
		<script type="text/javascript" >
			function change(p1){
		        var cname=document.getElementById("zan").className;
		        if(cname=="glyphicon glyphicon-heart"){
		        	document.getElementById("zan").className="glyphicon  glyphicon-heart-empty";
		        }else{
				document.getElementById("zan").className="glyphicon glyphicon-heart";
				$.post(
						"/MyBBS1/addServlet",
						{"type":"like","aid":p1},
						function(data){
							var a=document.getElementById("like");
							a.innerHTML=data.count;
						},
						"json"
						)
		        }
			}
			function fun(p2){
				$.post(
						"/MyBBS1/addServlet",
						{"type":"scan","aid":p2},
						function(data){
							
						},
						"json"
						)
			}
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
			   <% }
			   else{ %>
			       $("#t1").hide();
			<%}%>
			}
			
		</script>
		
	</head>

	<body onLoad="isLogin()">
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
        <li class="active"><a href="#">最新 <span class="sr-only">(current)</span></a></li>
        
        <li class="active"><a href="#">热门<span class="sr-only">(current)</span></a></li>
        
        <li class="active " style="margin-left: 620px; "><a href="edit.jsp" onclick="return check()" id="tie">发帖<span class="glyphicon glyphicon-pencil"></span></a></li>
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
   <!--板块区-->
   <div class="row">
   <div class="col-md-2" style="margin-left: 60px;margin-top: 15px;">
		 
		 <div class="list-group">
		  <button type="button" class="list-group-item list-group-item-info" style="text-align: center;margin-top: 5px;">吐槽大会</button>
		  <button type="button" class="list-group-item list-group-item-info" style="text-align: center; margin-top: 5px;">遇见最美的你</button>
		  <button type="button" class="list-group-item list-group-item-info" style="text-align: center;margin-top: 5px;">无聊灌水</button>
		  <button type="button" class="list-group-item list-group-item-info" style="text-align: center;margin-top: 5px;">兼职招聘</button>
		  <button type="button" class="list-group-item list-group-item-info" style="text-align: center;margin-top: 5px;">校园大事件</button>
		  
        </div> 
  </div> 
  			<!--中心帖子区-->
	   <div class="col-md-6" style="margin-top: 20px;">
	   	 <div class="list-group" >
	   	   <% SqlSession sqlsession=new SessionFactory().getSqlSession();
	   	    ArticlMapper articMapper=sqlsession.getMapper(ArticlMapper.class);
	   	    UserMapper uMapper=sqlsession.getMapper(UserMapper.class);
	   	    User user2=new User();
	   	    List<Articl> articls=  articMapper.queryAllArticl();
	   	   for(int i=0;i<articls.size();i++){
         	    Articl articl=articls.get(i);
         	    user2=uMapper.findUserByID(articl.getUname());
         	   
	   	    %>
          <a href="articl.jsp?aid=<%=articl.getAid()%>"  class="list-group-item "onclick="fun(<%=articl.getAid()%>)">
            
            <img src=<%=user2.getUheadimg()%> style="height: 60px;width: 60px;" class="img-circle">&nbsp;&nbsp;
            <span style="font-size:18px"><%=user2.getUname()%></span>
            <h3 class="list-group-item-heading"><%=articl.getA_topic()%></h3>
            <p class="list-group-item-text"><%=articl.getA_body() %></p></br>
           
            <span class="badge"><%=articl.getReply_count() %></span>
            <span><span id="zan" class="glyphicon  glyphicon-heart-empty" style="padding-left: 25px;" onclick="change(<%=articl.getAid()%>)"></span></span>
            <span class="glyphicon glyphicon-eye-open" style="float:left;"> <%=articl.getScan_count()%></span>
            <span style="margin-left: 10px;" id="like"><%=articl.getLike_count()%></span>
          </a>
          <br>
          <%}%>
       </div>
	   </div>
	   <!-- 个人信息 -->
	   <div class="col-md-3" style="margin-top: 20px;">
	   	 <p><img src=<%=user.getUheadimg() %> class="img-rounded" style="height: 65px;width: 65px;"></p>
	   	  <div class="list-group"> 
			  <a href="#" class="list-group-item active">
			     信息个人
			  </a>
			   <a href="#" class="list-group-item glyphicon glyphicon-user">昵称:<%=user.getUname()%></a>
			<a href="#" class="list-group-item glyphicon glyphicon-leaf"> 个性签名：不一样的我</a>
			<a href="#" class="list-group-item glyphicon glyphicon-comment">  帖子数量：<%=(int)(Math.random()*10)%></a>
			  <a href="#" class="list-group-item glyphicon glyphicon-wrench">我的邮箱：<%=user.getUemail()%></a>
             </div>
             <ul class="list-group">
			  <li class="list-group-item list-group-item-info">失物招领</li>
			  <li class="list-group-item ">校园卡</li>
			  <li class="list-group-item ">姓名***</li>
			  <li class="list-group-item ">学号***</li>
			</ul>
	   	</div>
   </div>
	</body>
</html>
