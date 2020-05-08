<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
<script>

window.addEventListener("load", function(){
	
	alert("탈퇴가 완료되었습니다");
		
	window.close();
	
	window.opener.parent.location.href="${path}/marga/index.jsp";
	
});

</script>
</head>
<body>

</body>
</html>