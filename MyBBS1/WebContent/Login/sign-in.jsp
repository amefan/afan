<%@page import="com.bbs.pojo.User,java.net.URLEncoder,java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.bbs.session.SessionFactory, org.apache.ibatis.session.SqlSession,com.bbs.mapper.UserMapper" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>登陆</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	

  

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/style.css">


	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
    <script>
    	function changeVerifyCode(){
    		var i=1;
    		document.getElementById("verifyCode").src="<%=request.getContextPath()%>/CheckimgServlet?rand="+Math.random();
    	}
    	
    </script>
	</head>
	<body class="style-2">
   <% String str="";
      String username = "";
      String password = "";
    //获取当前站点的所有Cookie
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
         if ("username".equals(cookies[i].getName())) {
            str = cookies[i].getValue();
            username=URLDecoder.decode(str, "utf-8");
            System.out.print(username);
        } else if ("password".equals(cookies[i].getName())) {
            password = cookies[i].getValue();
        }
    }
 %>
				<div class="col-md-4" style="padding-left: 35px; ">
					

					<!-- Start Sign In Form -->
					<form action="<%=request.getContextPath() %>/Login" class="fh5co-form animate-box" data-animate-effect="fadeInLeft" method="post" onsubmit="return check()">
						<h2>Sign In</h2>
						<div class="form-group">
							<label for="username" class="sr-only">昵称</label>
							<input type="text" class="form-control" id="username" name="username" placeholder="昵称" autocomplete="off" value="<%=username%>">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input type="password" class="form-control" id="password" name="password" placeholder="密码" autocomplete="off" value=<%=password%>>
						</div>
						
							<div class="form-group">
								<label for="verify" class="sr-only">验证码</label>
								<input type="text" name="code" id="code" placeholder="验证码"  autocomplete="off" class="verify">
									&nbsp;&nbsp;
								<img src="<%=request.getContextPath()%>/CheckimgServlet" id="verifyCode" title="单击换一换" onclick="changeVerifyCode()" style="height: 46px; width: 120px;"/>
                                <a href="javascript:changeVerifyCode();">看不清？</a>
						    </div>
					
						
						<div class="form-group">
							<label for="remember"><input type="checkbox" id="remember" name="remember" value="1" checked="checked"> 记住我</label>
						</div>
						<div class="form-group">
							<p>没账号？ <a href="sign-up.jsp">去注册&nbsp;</a> | <a href="forgot.jsp">忘记密码?</a></p>
						</div>
						<div class="form-group">
							<input type="submit" value="登陆" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->
                   
				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center"><p><small>&copy; All Rights Reserved. More Templates  - Collect from <a href="http://www.baidu.com/" title="网页模板" target="_blank">联系我们</a></small></p></div>
			</div>
		</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>

	</body>
</html>


</html>