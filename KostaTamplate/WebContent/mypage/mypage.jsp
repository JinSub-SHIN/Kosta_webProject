<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>JavaChip - MyPage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${path}/mypage/css/style.css">
	<link rel="stylesheet" href="${path}/mypage/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/mypage/css/animate.min.css">
	<link rel="stylesheet" href="${path}/mypage/css/jquery.fancybox.min.css">
	<link rel="stylesheet" href="${path}/mypage/css/owl.carousel.min.css">
	<link rel="stylesheet" href="${path}/mypage/css/owl.theme.default.min.css">
	<link rel="stylesheet" href="${path}/mypage/fonts/flaticon/font/flaticon.css">
	<link rel="stylesheet" href="${path}/mypage/css/aos.css">
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
</style>
<script src="${path}/mypage/js/jquery-3.3.1.min.js"></script>
<script>

	window.addEventListener("load", function(){
		
		var updatepwd = document.getElementById("updatepwd");
		var destoryid = document.getElementById("destoryid");
		
		updatepwd.onclick = function(){
			
			window.open('${path}/mypage/pwdcheck.jsp', '_blank', 'width=600, height=400');
			
		};
		
		destoryid.onclick = function(){
			
			window.open('${path}/mypage/destoryidcheck.jsp', '_blank', 'width=600, height=400');
			
		}
		
		$(".notrefund").click(function(){
			
			alert("환불 불가 상품입니다.");			
			
		});	
		
		
		$(".canrefund").click(function(){
			
			var value = $(this).val();			
			
			var result = confirm("환불하시겠습니까?");
			
			if(result){
				
				location.href="${path}/javaChip?command=canrefund&orderNo="+value;				
			}
			
		});
		
	});	

</script>

<body class="w3-theme-l5">

 <header class="site-navbar site-navbar-target bg-white" role="banner">		
		<c:choose>
			<c:when test="${empty sessionScope.userId}">	<!-- 로그인하지 않았다면... -->	
        <div class="container">
          <div class="row align-items-center position-relative">          				
            <div class="col-lg-4">
              <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"> 
			    <div class="container">
			      <a class="navbar-brand" href="${path}/marga/index.jsp">J A V A C H I P</a>
			      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			        <span class="navbar-toggler-icon"></span>
			      </button>
			      <div class="collapse navbar-collapse" id="navbarResponsive">
			        <ul class="navbar-nav ml-auto">
			          <li class="nav-item active">
			          </li>
					  <li class="nav-item" id="login">
					  <a class="nav-link" href="${path}/Login/login.jsp"><span style="color: white; font-weight: bold">로그인</span></a>
			          </li>
			         <li class="nav-item">
			           <a class="nav-link" onclick="window.open('${path}/regForm/regform.jsp', '_blank', 'width=600, height=400');"><span style="color: white; font-weight: bold">회원가입</span></a>
			         </li>
			          <li class="nav-item">
			            <a class="nav-link" href="${path}/javaChip?command=selectProd"><span style="color: white; font-weight: bold">강의목록</span></a>
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" href="${path}/community/community.jsp"><span style="color: white; font-weight: bold">커뮤니티</span></a>
			          </li>
			        </ul>
			      </div>
			    </div>
			  </nav>
			</div>
    	 </div>
       </div> 
			</c:when>
			<c:otherwise> <!-- 로그인하였다면.. -->
	  <div class="container">
          <div class="row align-items-center position-relative">          				
            <div class="col-lg-4">
              <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"> 
			    <div class="container">
			      <a class="navbar-brand" href="${path}/marga/index.jsp">J A V A C H I P</a>
			      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			        <span class="navbar-toggler-icon"></span>
			      </button>
			      <div class="collapse navbar-collapse" id="navbarResponsive">
			        <ul class="navbar-nav ml-auto">
			          <li class="nav-item active">
			          </li>
			          <li class="nav-item" id="logout">
			            <a class="nav-link" href="${path}/javaChip?command=logout"><span style="color: white; font-weight: bold">로그아웃</span></a>
			          </li>
			          <c:if test="${sessionScope.userStatus==1}">
			          <li class="nav-item">
			            <a class="nav-link" href="${path}/javaChip?command=selectByCusIdOrderLine"><span style="color: white; font-weight: bold">마이페이지/내강의실</span></a>
			          </li>
			          </c:if>
			          <c:if test="${sessionScope.userStatus==2}">
			          <li class="nav-item">
			            <a class="nav-link" href="${path}/javaChip?command=Tgangmok"><span style="color: white; font-weight: bold">마이페이지</span></a>
			          </li>
			          </c:if>
			          <c:if test="${sessionScope.userStatus==1}"><!-- customer인 경우에만 장바구니 보이기 -->
			          <li class="nav-item">
						<a class="nav-link" href="${path}/javaChip?command=selectCart&id=${userId}"><span style="color: white; font-weight: bold">장바구니</span></a>
					  </li>
					  </c:if>
			          <li class="nav-item">
			            <a class="nav-link" href="${path}/javaChip?command=selectProd"><span style="color: white; font-weight: bold">강의목록</span></a>
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" href="${path}/community/community.jsp"><span style="color: white; font-weight: bold">커뮤니티</span></a>
			          </li>
			        </ul>
			      </div>
			    </div>
			  </nav>
			</div>
    	 </div>
       </div>
			</c:otherwise>
		</c:choose>	  
	</header>

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:70px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3" style="margin-left: 40px; margin-top: 15px;">
      <!-- Profile -->
      <div class="w3-card w3-round w3-white">
        <div class="w3-container">
         <h4 class="w3-center" style="margin-top: 15px;">${user.name} 회원님</h4>
         <c:if test="${user.gender eq '남자'}">
         	<p class="w3-center"><img src="${path}/mypage/images/man.jpg" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
         </c:if>
         <c:if test="${user.gender eq '여자'}">
         	<p class="w3-center"><img src="${path}/mypage/images/woman.jpg" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
         </c:if>
         <c:if test="${user.gender eq 'Other'}">
         	<p class="w3-center"><img src="${path}/mypage/images/other.jpg" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
         </c:if>
         <hr>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i>email : ${user.email}</p>
         <p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i>phone : ${user.phone}</p>
         <p><i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i>가입일 : ${user.regDate}</p>
        </div>
      </div>
      <br>
      
      <!-- 정보변경 및 탈퇴하기 -->
      <div class="w3-card w3-round">
        <div class="w3-white">
          <button class="w3-button w3-block w3-theme-l1 w3-left-align" id="updatepwd">정보변경</button>
          <button class="w3-button w3-block w3-theme-l1 w3-left-align" id="destoryid">탈퇴하기</button>
        </div>      
      </div>
      <br>
      
      <!-- 최근수강강의 --> 
<!--       <div class="w3-card w3-round w3-white w3-hide-small"> -->
<!--         <div class="w3-container" style="text-align: center;"> -->
<!--           <h4 class="w3-center" style="margin-top: 15px;">최근수강강의</h4> -->
<!--           <hr> -->
<!--           <p> -->
<!--           최근수강 3개까지표현된다. -->
<!--             <a href=""><span class="w3-tag w3-small w3-theme-d5">JAVA 1강 - 반복문</span></a><br> -->
<!--             <a href=""><span class="w3-tag w3-small w3-theme-d5">JAVA 2강 - 제어문</span></a><br> -->
<!--             <a href=""><span class="w3-tag w3-small w3-theme-d5">JAVA 3강 - 조건문</span></a> -->
<!--           </p> -->
<!--         </div> -->
<!--       </div> -->
      <br>  
    
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    <div class="w3-col m7">   
      
      <div class="w3-container w3-card w3-white w3-round w3-margin" style="width: 900px;"><br>        
       <h4>수강중인 목록</h4><br>
        <hr class="w3-clear" style="margin: 0">
        <table class="table table-striped" style="width: 850px; height: 150px;">
        <tr><th>강의명</th><th>강사명</th><th>수강종료기간</th></tr>
        <c:forEach items="${myLectureList}" var="list">
        	<tr>
        		<td><a href="${path}/javaChip?command=selectProdDetail&goTo=mychapter&prodId=${list.product.id}">${list.product.name}</a></td>
        		<td>${list.product.teacher.name}</td>
        		<td>${list.endDate}</td>
        	</tr>
        </c:forEach>
        </table> 
        </div>        
      </div>
      
      
     <div class="w3-col m7">   
      
      <div class="w3-container w3-card w3-white w3-round w3-margin" style="width: 900px;"><br>        
       <h4>결제내역</h4><br>
        <hr class="w3-clear" style="margin: 0">
        <table class="table table-striped" style="width: 850px; height: 150px;">
        <tr><th>강의명</th><th>강사명</th><th>결제금액</th><th>승인날짜</th><th>환불</th></tr>
        
        <c:forEach items="${orderList}" var="list">
        	<tr>
        		<td>${list.product.name}</td>
        		<td>${list.product.teacher.name}</td>
        		<td>${list.product.price}</td>
        		<td>${list.orderLine.payDate}</td>
        		<c:if test="${list.orderLine.canrefund eq true}">        		
        		<td><button value="${list.itemNo}" class="canrefund">가능</button></td>        		
        		</c:if>
        		<c:if test="${list.orderLine.canrefund eq false}">
        		<td><input type="button" value="불가" class="notrefund"></td>
        		</c:if>
        	</tr>
        </c:forEach>
        </table> 
        </div>        
      </div>
      
    <!-- End Middle Column -->
    </div>
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->  
<!-- End Page Container -->
<br>

  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; KOSTA_2조 2020</p>
    </div>
    <!-- /.container -->
  </footer>
 
<script>
// Accordion
function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-theme-d1";
  } else { 
    x.className = x.className.replace("w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-theme-d1", "");
  }
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>

</body>
</html> 
