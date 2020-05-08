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
		
		var result = confirm("등록이 완료되었습니다. 창을 닫으시겠습니까?");
		
		if(result){			
			
			top.location.href="${path}/javaChip?command=teacherinput";
		}
		
	});

</script>
</head>
<body>




</body>
</html>