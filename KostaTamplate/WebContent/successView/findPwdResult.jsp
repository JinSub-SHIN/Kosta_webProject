<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<style>
#id{
	display: none;
}
#pwd{
	display: none;
}
</style>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
$(function(){
	alert($('#id').text()+"님의 비밀번호는 "+$('#pwd').text()+" 입니다.");
	window.close();
});
</script>
</head>
<body>
<span id="id">${userId}</span>
<span id="pwd">${findCustomerPwd}</span>
</body>
</html>