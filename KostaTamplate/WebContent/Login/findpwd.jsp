<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Find-PWD</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${path}/Login/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${path}/Login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${path}/Login/css/util.css">
	<link rel="stylesheet" type="text/css" href="${path}/Login/css/main.css">
<!--===============================================================================================-->

<script>

	window.addEventListener("load", function(){
		
		findpwd.onclick = function(){			
			
			//var findid = document.getElementById("findCustomerId");
		 	var id = document.getElementById("id").value;
			var name = document.getElementById("name").value;
	 		var phone = document.getElementById("phone").value;

			if(id==null || id=="" || name==null || name=="" || phone==null || phone==""){
				
				alert("입력값이 부족합니다");
				return;				
			} else {
				alert(id);
				//self.close();
			}			
		}		
	});

</script>

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-90 p-b-30">
				<form class="login100-form validate-form" action="../javaChip?command=findPwdCus" method="post">
					<span class="login100-form-title p-b-40">
						PWD 찾기
					</span>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate="아이디를입력하세요">
						<input class="input100" type="text" name="id" placeholder="ID">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16" data-validate="이름을입력하세요">
						<input class="input100" type="text" name="name" placeholder="NAME">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-20" data-validate = "전화번호를입력하세요">
						<span class="btn-show-pass">
							<i class="fa fa fa-eye"></i>
						</span>
						<input class="input100" type="text" name="phone" placeholder="PHONE">
						<span class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" id="findpwd" type="submit">
							비밀번호찾기
						</button>
					</div>		
				</form>
			</div>
		</div>
	</div>
	
	
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/bootstrap/js/popper.js"></script>
	<script src="${path}/Login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/daterangepicker/moment.min.js"></script>
	<script src="${path}/Login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="${path}/Login/js/main.js"></script>

</body>
</html>