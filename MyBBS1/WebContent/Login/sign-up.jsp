<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>注册</title>
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
   <script type="text/javascript">
		function c () {
		var r= new FileReader();
		f=document.getElementById('file').files[0];
		r.readAsDataURL(f);
			r.onload=function  (e) {
			document.getElementById('show').src=this.result;
			};
		}
		function checkForm(){
			var name=document.getElementById("name");
			var eValue=document.getElementById("email");
			var pValue=document.getElementById("password");
			var rpValue=document.getElementById("re-password");
			console.log("pValue"+pValue.value);
			console.log("rp"+rpValue.value);
			if(name.value.length==0){
				alert("请输入昵称！");
				return false;
			}else if(pValue.value.length==0){
				alert("请输入密码！");
				return false;
			}else if(pValue.value!=rpValue.value||rpValue.value.length==0){
				alert("两次密码不一致!");
				return false;
			}else if(eValue.value.length==0){
				alert("请输入邮箱！");
			}
			alert("注册成功");
			return true;
		}
</script>
	</head>
	<body class="style-2">

		<!--<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<ul class="menu">
						<li><a href="index.html">Style 1</a></li>
						<li class="active"><a href="index2.html">Style 2</a></li>
						<li><a href="index3.html">Style 3</a></li>
					</ul>
				</div>
			</div>
			<div class="row">-->
				<div class="col-md-4">
					

					<!-- Start Sign In Form -->
					<form method="post" action="<%=request.getContextPath() %>/RegistServlet" class="fh5co-form animate-box" data-animate-effect="fadeInLeft" onsubmit="return checkForm()"enctype="multipart/form-data">
						<h2>Sign Up</h2>
                        
                        
				
						<div class="form-group">
							<div class="alert alert-success" role="alert">填写信息</div>
						</div>
						<img src="images/head1.jpg" id='show' style="width: 150px;height: 150px; margin-left: 10px;margin-top: -10px;">
							<input  type="button"  value="上传头像"style="font: '微软雅黑';margin-top: -60px;margin-left: 195px;" class="btn btn-success"/><br />
						<input type="file" id='file'; onchange="c()" name="headimg" style="opacity:0;margin-top:-50px ;margin-left: 195px;" >
						
						<div class="form-group">
							<label for="name" class="sr-only">昵称</label>
							<input type="text" class="form-control" id="name" name="name" placeholder="昵称" autocomplete="off" style="margin-top:40px ;">
						</div>
						
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input type="password" class="form-control" id="password"name="password" placeholder="密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="re-password" class="sr-only">确认密码</label>
							<input type="password" class="form-control" id="re-password" placeholder="确认密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="email" class="sr-only">邮箱</label>
							<input type="email" class="form-control" id="email"name="email" placeholder="邮箱" autocomplete="off">
						</div>
						<div class="form-group">
							<input type="submit" value="注册" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->


				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center"><p><small>&copy; All Rights Reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></small></p></div>
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