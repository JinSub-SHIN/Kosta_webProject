<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>JavaChip - MyChapter</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${path}/mychapter/css/style.css">
	<link rel="stylesheet" href="${path}/mychapter/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/mychapter/css/animate.min.css">
	<link rel="stylesheet" href="${path}/mychapter/css/jquery.fancybox.min.css">
	<link rel="stylesheet" href="${path}/mychapter/css/owl.carousel.min.css">
	<link rel="stylesheet" href="${path}/mychapter/css/owl.theme.default.min.css">
	<link rel="stylesheet" href="${path}/mychapter/fonts/flaticon/font/flaticon.css">
	<link rel="stylesheet" href="${path}/mychapter/css/aos.css">
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
</style>

<script>

	window.addEventListener("load", function(){
		
		var updatepwd = document.getElementById("updatepwd");
		var destoryid = document.getElementById("destoryid");
		
		updatepwd.onclick = function(){
			
			window.open('pwdcheck.html', '_blank', 'width=600, height=400');
			
		};
		
		destoryid.onclick = function(){
			
			window.open('destoryidcheck.html', '_blank', 'width=600, height=400');
			
		}
		
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
			            <a class="nav-link" href="${path}/javaChip?command=selectByCusIdOrderLine"><span style="color: white; font-weight: bold">마이페이지</span></a>
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
      
    <!-- Middle Column -->
    <div class="w3-col m7"> 
    
    <h1>&nbsp;&nbsp;&nbsp;${prodDetailList[0].product.name}</h1>  
      
      <div class="w3-container w3-card w3-white w3-round w3-margin" style="width: 900px;"><br> 
        <hr class="w3-clear" style="margin: 0">
        <table class="table table-striped" style="width: 880px; height: 150px; font-size: 20px; text-align: center;">
        <tr><th>챕터</th><th>강의명</th><th>강의자료</th></tr>
        <c:forEach items="${prodDetailList}" var="prodDetail" varStatus="state"> 
        	<tr>
        		<td>${state.count}</td>
        		<td><a href="${path}/javaChip?command=selectProdDetail&goTo=myvideo&prodId=${prodDetail.product.id}&chapter=${prodDetail.chapter}">${prodDetail.title}</a></td>
        		<td><a href='downLoad?fileName=${prodDetail.fileName}'>${prodDetail.fileName}</a></td>
        	</tr>
        </c:forEach>
        </table> 
        </div>        
      </div>
           
    <!-- End Middle Column -->
    </div>
    
       <div class="col-md-3" style="position: fixed; left: 1100px; top: 100px">        

        <!-- Side Widget -->
        <div class="card my-4">
          <h5 class="card-header">강의만료일</h5>
          <div class="card-body">
             ${startEndDay.orderLine.payDate} ~ ${startEndDay.endDate}
          </div>
        </div>
       
        <!-- Categories Widget -->
        <div class="card my-5">
          <h5 class="card-header">질문있어요!</h5>
          <div class="card-body">
            <div class="row">
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="${path}/javaChip?command=selectAllQnA">질문게시판이동</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
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
