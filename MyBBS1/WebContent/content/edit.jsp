<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN" >

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
		<!--引入summer相关文件-->
		<link href="dist/summernote.css" rel="stylesheet" />
		<script src="dist/summernote.js"></script>
		<script>
	    $(document).ready(function() {
		  $('#summernote').summernote({
		  	height: 250,                 // set editor height
			minHeight: null,             // set minimum height of editor
			maxHeight: null,             // set maximum height of editor
			focus: true,
			placeholder:"说点什么....."
		 })
       });
	    function check(){
	    	var topic=document.getElementById("topic")
	        var markupStr = $('#summernote').summernote('code');
	    	if(topic.value==""){
	    		alert("主题不能为空");
	    		return false;
	    	}else if(markupStr.length>5){
	    		alert("字数不能少于5");
	    		return false;
	    	}
	    	
	    	return true;
	    }
	    function resurm(){
	    	var markupStr = $('#summernote').summernote('code');
	    	document.getElementById("body").value=markupStr;
	    }
		</script>
	</head>
	<body>
		<div class="row">
			<div class="col-md-6 col-md-offset-3" style="margin-top: 30px;">
				<form action="<%=request.getContextPath()%>/EditServlet" method="post" enctype="multipart/form-data" onsubmit="return ckeck()">
					 <div class="input-group form-group">
					  <span class="input-group-addon" id="basic-addon1">标题</span>
					  <input type="text" name="topic" id="topic" class="form-control" aria-describedby="basic-addon1">
					 </div>
					 <div class="input-group form-group">
					 <span class="input-group-addon" id="basic-addon1">板块</span>
					 <select class="form-control"  name="board" style="width: 25%;">
					  <option value="1" >无聊灌水</option>
					  <option value="2">吐槽大会</option>
					  <option value="3">遇见最美的你</option>
					  <option value="4">兼职招聘</option>
					  <option value="5">校园大事件</option>
					</select>
					</div>
					
					 <div id="summernote" id="body" name="body"><p><br></p></div>
					 　<input type="hidden" name="body" id="body" value="">
					 
					 <div style="background-color: orange;width: 16%; height: 30px" class="btn btn-default">
					 <span class="glyphicon glyphicon-send" style="margin-left: -2px;"></span>
					 <span style="margin-left: 5px;padding-top: 20px;" >发表帖子</span>
					 <input type="submit"  style="background-color: orange;margin-left: -60px;opacity: 0;" value="发表帖子" onclick="resurm()"/>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
