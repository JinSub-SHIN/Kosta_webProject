<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>JavaChip-myVideo</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/blog-post.css" rel="stylesheet">

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

      <!-- Post Content Column -->
      <div class="col-lg-8">

        <!-- Title -->
        <h1 class="mt-4">JAVA 왕초보 1강</h1>

        <!-- Author -->
        <p class="lead">
          by
          <a href="#">김민호 강사</a>
        </p>

        <hr>

        <!-- Preview Image -->
        <video src="video/videosample.mp4" width='800' height="500" controls>
        </video>

        <hr>

        <!-- Post Content -->
        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus, vero, obcaecati, aut, error quam sapiente nemo saepe quibusdam sit excepturi nam quia corporis eligendi eos magni recusandae laborum minus inventore?</p>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, tenetur natus doloremque laborum quos iste ipsum rerum obcaecati impedit odit illo dolorum ab tempora nihil dicta earum fugiat. Temporibus, voluptatibus.</p>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, doloribus, dolorem iusto blanditiis unde eius illum consequuntur neque dicta incidunt ullam ea hic porro optio ratione repellat perspiciatis. Enim, iure!</p>

        <blockquote class="blockquote">
          <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
          <footer class="blockquote-footer">Someone famous in
            <cite title="Source Title">Source Title</cite>
          </footer>
        </blockquote>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error, nostrum, aliquid, animi, ut quas placeat totam sunt tempora commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem obcaecati?</p>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur ratione tempore quidem voluptates cupiditate voluptas illo saepe quaerat numquam recusandae? Qui, necessitatibus, est!</p>

        <hr>       

      </div>

      <!-- Sidebar Widgets Column -->
      <div class="col-md-3" style="position: fixed; left: 1100px; top: 100px">        

        <!-- Side Widget -->
        <div class="card my-4">
          <h5 class="card-header">상세정보</h5>
          <div class="card-body">
            기본적인 변수선언에 대해 배웁니다.<p>
            변수를 타입에 따라 캐스팅 할 수 있음을<br> 배웁니다.
          </div>
        </div>
        
                <!-- Categories Widget -->
        <div class="card my-5">
          <h5 class="card-header">강의목록</h5>
          <div class="card-body">
            <div class="row">
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="../mychapter/mychapter.jsp">리스트로 이동</a>
                  </li>
                  <li>
                    <a href="myvideo.jsp">1강 변수선언</a>
                  </li>
                  <li>
                    <a href="myvideo.jsp">2강 반복문</a>
                  </li>
                  <li>
                    <a href="myvideo.jsp">3강 제어문</a>
                  </li>
                  <li>
                    <a href="myvideo.jsp">4강 람다식</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>
    <!-- /.row -->

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
