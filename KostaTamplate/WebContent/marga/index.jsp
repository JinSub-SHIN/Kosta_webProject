<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>JavaChip</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${path}/marga/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${path}/marga/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/marga/css/animate.min.css">
    <link rel="stylesheet" href="${path}/marga/css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="${path}/marga/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${path}/marga/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${path}/marga/fonts/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="${path}/marga/css/aos.css">

    <!-- MAIN CSS -->
    <link rel="stylesheet" href="${path}/marga/css/style.css">

<style>
html,body{
  height:100%;
}
body{
  text-align:center;
}
body:before{
  content:'';
  height:100%;
  display:inline-block;
  vertical-align:middle;
}
button{
  background: green;
  color:#fff;
  border:none;
  position:relative;
  height:50px;
  font-size:1.15em;
  padding:0 1em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
button:hover{
  background:#fff;
  color:#1AAB8A;
}
button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}

.tost{

position: fixed;
z-index: 1000;
left: 20px;
bottom: 20px;
width: 300px;
height: 200px;

}

.toast_close span {
position: fixed;
z-index: 3000;
left: 280px;
bottom: 180px;
width: 40px;
height: 40px;   
font-size: 25px;
color: #fff;
background-color: black;
    
}

.tost2{

position: fixed;
z-index: 1000;
left: 1300px;
bottom: 20px;
width: 300px;
height: 200px;

}

.toast_close2 span {
position: fixed;
z-index: 3000;
left: 1560px;
bottom: 180px;
width: 40px;
height: 40px;   
font-size: 25px;
color: #fff;
background-color: black;
    
}

</style>

<script>

	window.addEventListener("load", function(){
		
		var list = document.getElementById('classlist');

		var x1 = document.getElementById("x1");
		var toast1 = document.getElementById("toast1");
		var x2 = document.getElementById("x2");
		var toast2 = document.getElementById("toast2");
		
		x1.onclick = function(){
			
			toast1.style.display = 'none';
			
		}
		
		x2.onclick = function(){
			
			toast2.style.display = 'none';			
		}
		
	
	});

</script>

</head>

  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

    
    <div class="site-wrap" id="home-section">

      <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
          <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>
          </div>
        </div>
        <div class="site-mobile-menu-body"></div>
      </div>      
    
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
			          <li class="nav-item">
			            <a class="nav-link" href="${path}/javaChip?command=selectByCusIdOrderLine"><span style="color: white; font-weight: bold">마이페이지/내강의실</span></a>
			          </li>
			          <li class="nav-item">
						<a class="nav-link" href="${path}/javaChip?command=selectCart&id=${userId}"><span style="color: white; font-weight: bold">장바구니</span></a>
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
			</c:otherwise>
		</c:choose>	  
			  
			  <!-- 토스트 배너부분 -->
                
              <div class="toast_ban" id="toast1">
              	<div class="toast_in">        
              	<a href="javascript:;" class="toast_close" id="x1"><span>X</span></a>
             	<a href="192.168.0.168/notebookShop/index.jsp"><img src="images/tost.jpg" class='tost'></a>    
              	</div> 
              </div>
              <div class="toast_ban" id="toast2">
              	<div class="toast_in">
              	<a href="javascript:;" class="toast_close2" id="x2"><span>X</span></a>
              	<a href="${path}/community/evaluation.jsp"><img src="images/tost2.jpg" class='tost2'></a>
              	</div>
              </div> 
              
              <!-- 토스트 배너 끝 -->
                       

      </header>
    <div class="owl-carousel-wrapper">
      <div class="box-92819">
        <div class="owl-carousel slide-one-item-alt-text">
          <div>
            <h1 class="text-uppercase mb-3">자칭 1등 프로그래밍 인터넷 강의</h1>
            <p class="mb-5"> 'KOSTA' 출신 명문강사들 총 집합!! </p>
            <p class="mb-0"><a href="${path}/classlist/cart.jsp" class="btn btn-primary rounded-0">바로신청하기!</a></p>
          </div>
          <div>
            <h2 class="text-uppercase mb-3">여러분들의 꿈을 자바칩에서 키우세요!</h2>
            <p class="mb-5"> 자바칩과 함께라면 어려울것이 없어요!</p>
            <p class="mb-0"><a href="${path}/classlist/cart.jsp" class="btn btn-primary rounded-0">바로신청하기!</a></p>
          </div>

          <div>
            <h2 class="text-uppercase mb-3">자랑스러운 취업률</h2> <h1>"100%" !</h1>
            <p class="mb-5">역대 최대 취업률을 경험하시려면 바로 신청하세요!</p>            
            <p class="mb-0"><a href="${path}/classlist/cart.jsp" class="btn btn-primary rounded-0">바로신청하기!</a></p>
          </div>

        </div>
      </div>
      <div class="owl-carousel owl-1 ">
        <div class="ftco-cover-1" style="background-image: url('images/main03.jpg');"></div>
        <div class="ftco-cover-1" style="background-image: url('images/back01.png');"></div>
        <div class="ftco-cover-1" style="background-image: url('images/back001.jpg');"></div>
        
      </div>
    </div>

    
    <div class="site-section">
      <div class="container">
        <div class="row align-items-stretch">
        <img src="images/image_99.jpg" height="900px">
          <div class="col-lg-4">
            <div class="h-100 bg-white box-29291">
              <h2 class="heading-39291">Welcome To <br> Our Company</h2>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo mollitia id ea ab in! Nam eligendi distinctio, vitae.</p>
              <p>Alias odit ipsam quas unde obcaecati molestiae consequatur numquam cupiditate perferendis facere, nulla nemo id, accusantium corrupti tempora.</p>

              <p class="mt-5">
                <span class="d-block font-weight-bold text-black">Bruce Smith</span>
                <span class="d-block font-weight-bold text-muted">Founder, CEO</span>
                
                <img src="images/signature.svg" alt="Image"  width="140">
              </p>
            </div>
          </div>
          <div class="col-lg-8">
            <div class="owl-carousel owl-3">
              
            </div>
          </div>
        </div>
      </div>
    </div>    
    <div class="site-section">
      <div class="container">
        <div class="row align-items-stretch">
          <div class="col-lg-3 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
            </div>
          </div>
          <div class="col-lg-3 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
              
              
            </div>
          </div>
          <div class="col-lg-3 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
              
            </div>
          </div>
          <div class="col-lg-3 col-md-6 mb-5">
            <div class="post-entry-1 h-100">
            </div>
          </div>
        </div>
      </div>
    </div>
    
   <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; KOSTA_2조 2020</p>
    </div>
    <!-- /.container -->
  </footer>

    </div>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.sticky.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.animateNumber.min.js"></script>
    <script src="js/jquery.fancybox.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/aos.js"></script>

    <script src="js/main.js"></script>


  </body>
</html>
