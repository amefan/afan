<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title>test</title>
		<script src="content/js/jquery-1.11.3.min.js"></script>
		
	</head>
	
	<body>
		<span id="sapn1"  onclick="fun(3)">12</span>
		<input type="button" id="b1">
	</body>
</html>
<script>
		
function fun(p1){
	$.post(
			"/MyBBS1/addServlet",
			{"type":"like","aid":p1},
			function(data){
				
			},
			"json"
			)
}
	</script>