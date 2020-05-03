<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>JavaChip-detail</title>

  <!-- Bootstrap core CSS -->
  <link href="${path}/detail_information/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${path}/detail_information/css/shop-item.css" rel="stylesheet">
 
</head>

<body>

  <!-- Navigation -->
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
			            <a class="nav-link" href="${path}/mypage/mypage.jsp"><span style="color: white; font-weight: bold">마이페이지/내강의실</span></a>
			          </li>
			          <li class="nav-item">
						<a class="nav-link" href="${path}/mycart/newmycart.jsp"><span style="color: white; font-weight: bold">장바구니</span></a>
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
	</header>
  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">
        <h1 class="my-4"> ${prodDetail.product.name}</h1>
        <div class="list-group">
          <h3 class="list-group-item active">다른강의</h3>
          <c:forEach items="${sameCateProd}" var="prod">
          <a href="javaChip?command=selectProdInfo&prodId=${prod.id}" class="list-group-item">${prod.name}</a>
          </c:forEach>
        </div>
      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div class="card mt-4">
          <video src="${path}/detail_information/video/${prodDetail.url}" width='820' height="400" controls>
          </video>          
          <div class="card-body">
            <h3 class="card-title"> ${prodDetail.product.name} by${prodDetail.product.teacher.name}</h3>
            <h4 style="text-decoration: line-through;">${salePrice}원</h4><h3 style="font-weight: bold">${prodDetail.product.price}원</h3>
            <p class="card-text"> ${prodDetail.product.description}</p>
            <span class="text-warning">
            <c:forEach var="i" begin="1" end="${aveGrade}">
            	&#9733
            </c:forEach>
            <c:forEach var="j" begin="1" end="${whiteStar}">
            	&#9734
            </c:forEach>
            </span>
            ${aveGrade} stars
          </div>
        </div>
        <!-- /.card -->

        <div class="card card-outline-secondary my-4">
          <div class="card-header">
            강의평
          </div>
          <div class="card-body">
          	<c:forEach items="${estimateList}" var="estBoard">
          		<p>${estBoard.subject}</p>
          		<span class="text-warning">
	            <c:choose>
					<c:when test="${estBoard.grade == 5}">
						&#9733; &#9733; &#9733; &#9733; &#9733;
					</c:when>
					<c:when test="${estBoard.grade == 4}">
					 &#9733; &#9733; &#9733; &#9733; &#9734; 
					</c:when>
					<c:when test="${estBoard.grade == 3}">
						&#9733; &#9733; &#9733; &#9734;
					</c:when>
					<c:when test="${estBoard.grade == 2}">
						&#9733; &#9733; &#9734;&#9734;&#9734;
					</c:when>
					<c:when test="${estBoard.grade == 1}">
						&#9733;&#9734;&#9734;&#9734;&#9734;
					</c:when>
				</c:choose>
	            </span>
	            <small class="text-muted">${estBoard.writeDay}</small>
          	</c:forEach>
            <hr>
            <a href="${path}/javaChip?command=insertCart&prodId=${prodDetail.product.id}" class="btn btn-success">장바구니 담기</a>
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
