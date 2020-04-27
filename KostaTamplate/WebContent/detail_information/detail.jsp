<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>JavaChip-detail</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-item.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
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
            </div>
    	 </div>
        </div>
      </header>
  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">
        <h1 class="my-4"> Python 초보</h1>
        <div class="list-group">
          <h3 class="list-group-item active">다른강의</h3>
          <a href="#" class="list-group-item">Python 중급</a>
          <a href="#" class="list-group-item">Python 고급</a>
        </div>
      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div class="card mt-4">
          <video src="video/videosample.mp4" width='820' height="400" controls>
          </video>          
          <div class="card-body">
            <h3 class="card-title"> Python 기본기를 다질 수 있는 강의</h3>
            <h4 style="text-decoration: line-through;">230,000원</h4><h3 style="font-weight: bold">210,000원</h3>
            <p class="card-text"> Python의 끝판왕 김민호 강사의 초급다지기!</p>
            <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9733;</span>
            5.0 stars
          </div>
        </div>
        <!-- /.card -->

        <div class="card card-outline-secondary my-4">
          <div class="card-header">
            강의평
          </div>
          <div class="card-body">
            <p>프로그래밍 이 강의로 입문했어요 진짜 너무 좋아요!</p>
            <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9733;</span>
            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
            <hr>
            <p>이해가 쏙쏙!</p>
            <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9733;</span>
            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
            <hr>
            <p>좋아요~~</p>
            <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9733;</span>
            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
            <hr>
            <a href="#" class="btn btn-success">장바구니 담기</a>
          </div>
        </div>
        <!-- /.card -->

      </div>
      <!-- /.col-lg-9 -->

    </div>

  </div>
  <!-- /.container -->

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

</body>

</html>
