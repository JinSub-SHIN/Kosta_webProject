<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>JavaChip-Community</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">  

  <!-- Custom styles for this template -->
  <link href="css/simple-sidebar.css" rel="stylesheet">

<style>
table{
	width: 1200px;
	margin-top: 20px;

}

/*

.page{
	text-align: center;
	width: 50%;
}

.pagination{
	list-style: none;
	display: inline-block;
	padding: 0;
	margin-top: 20px;
}

.pagination li{
	display: inline;
	text-align: center;
}

.pagination a{
	float:left;
	display: block;
	font-size: 14px;
	text-decoration: none;
	padding: 5px 12px;
	color: #96a0ad;
	line-height: 1.5;
	
}

.first{
	margin-right: 15px;

}

.last{
	margin-left: 15px;

}

.first:hover, .last:hover, .left:hover, .right:hover {
	color: #2e9cdf;
	
}

.pagination a.active{
	cursor : default;
	color : #ffffff;
}

.pagination a:active{
	outline: none;
}

.modal .num{
	margin-left: 3px;
	padding: 0;
	width: 30px;
	height: 30px;
	line-height: 30px;
	-moz-border-radius:100%;
	-webkit-border-radius: 100%;
	border-radius: 100%;
}

.modal .num:hover {
	background-color: #2e9cdf;
	color: #ffffff;
}

.modal .num.active, .modal .num:active{
	background-color: #2e9cdf;
	cursor: pointer;
}

.arrow-left{
	width: 0px;
	height: 0;
	border-top: 10px solid transparent;
	border-bottom: 10px solid transparent;
	border-right: 10px solid blue;
}


*/





</style>


</head>

<body>

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
		  <a class="nav-link" href="../Login/login.jsp"><span style="color: white; font-weight: bold">로그인</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../marga/index.jsp"><span style="color: white; font-weight: bold">로그아웃</span></a>
          </li>
         <li class="nav-item">
           <a class="nav-link" onclick="window.open('../regForm/regform.jsp', '_blank', 'width=600, height=400');"><span style="color: white; font-weight: bold">회원가입</span></a>
         </li>
          <li class="nav-item">
            <a class="nav-link" href="../mypage/mypage.jsp"><span style="color: white; font-weight: bold">마이페이지/내강의실</span></a>
          </li>
          <li class="nav-item">
			<a class="nav-link" href="../mycart/newmycart.jsp"><span style="color: white; font-weight: bold">장바구니</span></a>
		  </li>
          <li class="nav-item">
            <a class="nav-link" href="../classlist/cart.jsp"><span style="color: white; font-weight: bold">강의목록</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../community/community.jsp"><span style="color: white; font-weight: bold">커뮤니티</span></a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">Start Bootstrap </div>
      <div class="list-group list-group-flush">
        <a href="Q&Aboard.jsp" class="list-group-item list-group-item-action bg-light">Q&A게시판</a>
        <a href="evaluation.jsp" class="list-group-item list-group-item-action bg-light">강의평게시판</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">회사정보</a>
      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button class="btn btn-primary" id="menu-toggle">Toggle Menu</button>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>
      
      <div class="container-fluid">
	    <table class="table table-striped">
	    	<thead>
	    	<tr>
	    		<th>번호</th>
	    		<th>제목</th>
	    		<th>작성자</th>
	    		<th>날짜</th>
	    		<th>조회수</th>
	    	</tr>
	    	</thead>
	    	<tbody>
	    	<tr>
	    		<td>1</td>
	    		<td>자바1강 for문 질문이요!</td>
	    		<td>낑깡낑깡</td>
	    		<td>2020-04-24</td>
	    		<td>1</td>
	    	</tr>
	    	<tr>
	    		<td>2</td>
	    		<td>자바3강 if문 질문이요!</td>
	    		<td>홀짝홀짝</td>
	    		<td>2020-04-24</td>
	    		<td>37</td>
	    	</tr>
	    	<tr>
	    		<td>3</td>
	    		<td>파이썬2강 while문 질문이요!</td>
	    		<td>고수될꺼야</td>
	    		<td>2020-04-24</td>
	    		<td>12</td>
	    	</tr>
	    	</tbody>	    	
	    </table>
	    
<!-- 	 <div class="page">
	    	<ul class="pagination modal">
	    	<li><a href="#" class="first">처음페이지</a></li>
	    	<li><a href="#" class="arrow left">&lt;&lt;</a></li>
	    	<li><a href="#" class="num">1</a></li>
	    	<li><a href="#" class="num">2</a></li>
	    	<li><a href="#" class="num">3</a></li>
	    	<li><a href="#" class="num">4</a></li>
	    	<li><a href="#" class="arrow right">>></a></li>	 
	    	<li><a href="#" class="last">끝페이지</a></li>   	
	    	</ul>	    
	    </div>
	    
-->	    
	    
	    <hr>
	    <button style="float: right" onclick="location.href='writeform.jsp'">질문하기</button>
		
      </div>     
    </div>
    <!-- /#page-content-wrapper -->
    

  </div>
  <!-- /#wrapper -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; KOSTA_2조 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Menu Toggle Script -->
  <script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>

</body>

</html>
