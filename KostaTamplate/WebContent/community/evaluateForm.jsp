<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>JavaChip-Community</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/simple-sidebar.css" rel="stylesheet">

<style>
table {
	width: 1200px;
	margin-top: 20px;
}

#formpwd {
	display: none;
}

#star_grade a {
	text-decoration: none;
	color: gray;
}

#star_grade a.on {
	color: red;
}

#teacher {
	display: none;
}
</style>

<script src="vendor/jquery/jquery.min.js"></script>

<script>
var grade;
	$(function() {
		$('#star_grade a').click(function() {
			$(this).parent().children("a").removeClass("on"); /* 별점의 on 클래스 전부 제거 */
			$(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
			grade = $(this).attr('id');
			return false;
		});

		//강의평 등록하기 - 내가 수강하는 강의에 한하여 등록할 수 있다
		$('#btnSave').click(function() { //강의평 등록
			//alert($(":selected").val());
			location.href="../javaChip?command=insertEst&prodId="+$(":selected").val()+"&content="+$('[name=content]').val()+"&grade="+grade;
		});
	});//end load
</script>
</head>
<body>
	<header class="site-navbar site-navbar-target bg-white" role="banner">
		<div class="container">
			<div class="row align-items-center position-relative">
				<div class="col-lg-4">
					<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
						<div class="container">
							<a class="navbar-brand" href="${path}/marga/index.jsp">J A V
								A C H I P</a>
							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#navbarResponsive"
								aria-controls="navbarResponsive" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarResponsive">
								<ul class="navbar-nav ml-auto">
									<li class="nav-item active"></li>
									<c:choose>
										<c:when test="${userId==null}">
											<li class="nav-item"><a class="nav-link"
												href="${path}/Login/login.jsp"><span
													style="color: white; font-weight: bold">로그인</span></a></li>
											<li class="nav-item"><a class="nav-link"
												onclick="window.open('${path}/regForm/regform.jsp', '_blank', 'width=600, height=400');">
													<span style="color: white; font-weight: bold">회원가입</span>
											</a></li>
										</c:when>
										<c:when test="${userId!=null}">
											<li class="nav-item"><a class="nav-link"
												href="${path}/javaChip?command=logout"><span
													style="color: white; font-weight: bold">로그아웃</span></a></li>
										</c:when>
									</c:choose>
									<li class="nav-item"><a class="nav-link"
										href="${path}/mypage/mypage.jsp"><span
											style="color: white; font-weight: bold">마이페이지/내강의실</span></a></li>
									<li class="nav-item"><a class="nav-link"
										href="${path}/mycart/newmycart.jsp"><span
											style="color: white; font-weight: bold">장바구니</span></a></li>
									<li class="nav-item"><a class="nav-link"
										href="${path}/javaChip?command=selectProd"><span
											style="color: white; font-weight: bold">강의목록</span></a></li>
									<li class="nav-item"><a class="nav-link"
										href="${path}/community/community.jsp"><span
											style="color: white; font-weight: bold">커뮤니티</span></a></li>
								</ul>
							</div>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>

	<div class="d-flex" id="wrapper">

		<!-- Sidebar -->
		<div class="bg-light border-right" id="sidebar-wrapper">
			<div class="sidebar-heading">Start Bootstrap</div>
			<div class="list-group list-group-flush">
				<a href="${path}/javaChip?command=selectAllQnA"
					class="list-group-item list-group-item-action bg-light">Q&A게시판</a>
				<a href="${path}/javaChip?command=selectAllEst"
					class="list-group-item list-group-item-action bg-light">강의평게시판</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">회사정보</a>
			</div>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">

			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<button class="btn btn-primary" id="menu-toggle">Toggle
					Menu</button>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="#">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Dropdown </a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">Action</a> <a
									class="dropdown-item" href="#">Another action</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Something else here</a>
							</div></li>
					</ul>
				</div>
			</nav>

			<div class="container-fluid">
				<h2 style="text-align: center; margin-top: 20px;">강의평 작성</h2>
				<hr>

				<form name="form" id="form" role="form" method="post"
					action="${pageContext.request.contextPath}/board/saveBoard">

					<div class="mb-3">
						<label for="title" style="font-weight: bold">강좌 선택</label> <br>
						<select>
								<option>강좌선택</option>
							<c:forEach items="${itemList}" var="item" varStatus="state">
								<option value="${item.product.id}">${item.product.name}
									/ ${item.product.teacher.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<label for="title" style="font-weight: bold">별점주기</label>
						<p id="star_grade">
							<a id="1">★</a> <a id="2">★</a> <a id="3">★</a> <a id="4">★</a> <a
								id="5">★</a>
						</p>
					</div>
					<div class="mb-3">
						<label for="content" style="font-weight: bold">내용</label>
						<textarea class="form-control" rows="5" name="content"
							id="content" placeholder="강의평을 작성해주세요."></textarea>
					</div>
				</form>

				<div>

					<button type="button" class="btn btn-sm btn-primary" id="btnSave">등록</button>

					<button type="button" class="btn btn-sm btn-primary"
						onclick='location.href="${path}/javaChip?command=selectAllEst"'>목록</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /#page-content-wrapper -->
	<!-- /#wrapper -->
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