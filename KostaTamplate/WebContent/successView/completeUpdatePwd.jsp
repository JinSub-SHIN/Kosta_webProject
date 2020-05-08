<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
$(function(){
	alert("비밀번호 변경이 완료되었습니다. 다시 로그인해주세요!");
	opener.location.href="${path}/javaChip?command=logout";
	window.close();
});
</script>
</head>
<body>

</body>
</html>