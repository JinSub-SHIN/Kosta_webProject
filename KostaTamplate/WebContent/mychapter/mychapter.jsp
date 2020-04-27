<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>JavaChip - MyChapter</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/jquery.fancybox.min.css">
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
	<link rel="stylesheet" href="css/aos.css">
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

		
        <div class="container">
          <div class="row align-items-center position-relative">          				
            <div class="col-lg-4">
              <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"> 
			    <div class="container">
			      <a class="navbar-brand" href="../marga/index.jsp">J A V A C H I P</a>
			      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			        <span class="navbar-toggler-icon"></span>
			      </button>
			      <div class="collapse navbar-collapse" id="navbarResponsive">
			        <ul class="navbar-nav ml-auto">
			          <li class="nav-item active">
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" href="../Login/login.jsp">로그인</a>
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" href="../marga/index.jsp">로그아웃</a>
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" onclick="window.open('../regForm/regform.jsp', '_blank', 'width=600, height=400');">회원가입</a>
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" href="../mypage/mypage.jsp">마이페이지</a>
			          </li>
					  <li class="nav-item">
						<a class="nav-link" href="../mycart/newmycart.jsp">장바구니</a>
					  </li> 
			          <li class="nav-item">
			            <a class="nav-link" href="../classlist/cart.jsp">강의목록</a>
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" href="../mygangisil/mygangisil.jsp"><span style="color: white; font-weight: bold">내강의실</span></a>
			          </li>
			          <li class="nav-item">
			            <a class="nav-link" href="../community/community.jsp">커뮤니티</a>
			          </li>
			        </ul>
			      </div>
			    </div>
			  </nav>
			</div>
		</div>
	</div>
</header>

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:70px">    
  <!-- The Grid -->
  <div class="w3-row">
      
    <!-- Middle Column -->
    <div class="w3-col m7"> 
    
    <h1>&nbsp;&nbsp;&nbsp;JAVA 왕초보</h1>  
      
      <div class="w3-container w3-card w3-white w3-round w3-margin" style="width: 900px;"><br> 
        <hr class="w3-clear" style="margin: 0">
        <table class="table table-striped" style="width: 880px; height: 150px; font-size: 20px; text-align: center;">
        <tr><th>챕터</th><th>강의명</th><th>강의자료</th></tr>
        <tr><td>1강</td><td><a href="../myvideo/myvideo.jsp">JAVA기본용어</a></td><td>업로드가능한자료</td></tr>
        <tr><td>2강</td><td><a href="../myvideo/myvideo.jsp">제어문</a></td><td>업로드가능한자료</td></tr>
        <tr><td>3강</td><td><a href="../myvideo/myvideo.jsp">반복문1</a></td><td>업로드가능한자료</td></tr>
        <tr><td>4강</td><td><a href="../myvideo/myvideo.jsp">반복문2</a></td><td>업로드가능한자료</td></tr>
        <tr><td>4강</td><td><a href="../myvideo/myvideo.jsp">반복문2</a></td><td>업로드가능한자료</td></tr>
        <tr><td>4강</td><td><a href="../myvideo/myvideo.jsp">반복문2</a></td><td>업로드가능한자료</td></tr>
        <tr><td>4강</td><td><a href="../myvideo/myvideo.jsp">반복문2</a></td><td>업로드가능한자료</td></tr>
        <tr><td>4강</td><td><a href="../myvideo/myvideo.jsp">반복문2</a></td><td>업로드가능한자료</td></tr>
        <tr><td>4강</td><td><a href="../myvideo/myvideo.jsp">반복문2</a></td><td>업로드가능한자료</td></tr>        
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
             2020.02.05 ~ 2020.07.07
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
                    <a href="../community/Q&Aboard.jsp">질문게시판이동</a>
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
