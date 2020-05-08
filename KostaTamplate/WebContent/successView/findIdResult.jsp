<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 찾기</title>
<style>
#id{
	display: none;
}
#name{
	display:none;
}
</style>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
$(function(){
	alert($('#name').text()+"님의 ID는 "+$('#id').text()+" 입니다.");
	window.close();
});
</script>
</head>
<body>
<span id="id">${findCustomerId}</span>
<span id="name">${userName}</span>
</body>
</html>