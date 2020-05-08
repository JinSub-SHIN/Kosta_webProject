<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>JavaChip - pwdUpdate</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${path}/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/mypage/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/mypage/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/mypage/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/mypage/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${path}/mypage/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/mypage/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/mypage/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${path}/mypage/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/mypage/css/util.css">
	<link rel="stylesheet" type="text/css" href="${path}/mypage/css/main.css">
<!--===============================================================================================-->

<script>

	window.addEventListener("load", function(){
		
		pwdupdate.onclick = function(){	
			
		 	var pwd = document.getElementById("pwd").value;	 		
		 
		 	if(pwd==null || pwd==""){
		 		
		 		alert("입력값이 부족합니다");
		 		return; 
		 		}
		 	}		
	});

</script>

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-90 p-b-30">
			
			<!-- action 값 지정할것! -->
			
				<form class="login100-form validate-form" action="${path}/javaChip?command=updatePwdCus" method="post">
					<span class="login100-form-title p-b-40">
						비밀번호입력
					</span>

					<div class="wrap-input100 validate-input m-b-16" data-validate="비밀번호를 입력하세요">
						<input class="input100" type="password" name="pwd" placeholder="PWD" id="pwd">
						<span class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" id="pwdupdate" type="submit">
							비밀번호 수정
						</button>
					</div>		
				</form>
			</div>
		</div>
	</div>
	
	
<!--===============================================================================================-->
	<script src="${path}/mypage//vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/mypage/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/mypage/vendor/bootstrap/js/popper.js"></script>
	<script src="${path}/mypage/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/mypage/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/mypage/vendor/daterangepicker/moment.min.js"></script>
	<script src="${path}/mypage/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${path}/mypage/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="${path}/mypage/js/main.js"></script>

</body>
</html>