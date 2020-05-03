<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>JavaChip-Community</title>

<!-- Bootstrap core CSS -->
<link href="${path}/community/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${path}/community/css/simple-sidebar.css" rel="stylesheet">

</head>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
$(function(){
	$('#btnSave').click(function(){
		alert("수정되었습니다!");
		location.href="javaChip?command=updateQnA&qaBoardNo="+${qnaBoard.qaBoardNo}+"&content="+$('#content').val();
	});//end save
	
	$('#btnDel').click(function(){
		location.href="javaChip?command=deleteQnA&qaBoardNo="+${qnaBoard.qaBoardNo};
	});//end delete
});//end load
</script>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="../marga/index.jsp">J A V A C H I P</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"></li>
					<li class="nav-item"><a class="nav-link"
						href="../Login/login.jsp"><span
							style="color: white; font-weight: bold">로그인</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="../marga/index.jsp"><span
							style="color: white; font-weight: bold">로그아웃</span></a></li>
					<li class="nav-item"><a class="nav-link"
						onclick="window.open('../regForm/regform.jsp', '_blank', 'width=600, height=400');"><span
							style="color: white; font-weight: bold">회원가입</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="../mypage/mypage.jsp"><span
							style="color: white; font-weight: bold">마이페이지/내강의실</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="../mycart/newmycart.jsp"><span
							style="color: white; font-weight: bold">장바구니</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="${path}/javaChip?command=selectProd"><span
							style="color: white; font-weight: bold">강의목록</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="../community/community.jsp"><span
							style="color: white; font-weight: bold">커뮤니티</span></a></li>
				</ul>
			</div>
		</div>
	</nav>

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
				<!-- qna 상세 폼 시작 -->
				<h2 style="text-align: center; margin-top: 20px;">QnA</h2>
				<hr>
				<form name="form" id="form" role="form" method="post"
					action="/webProject_JavaChip/board/saveBoard">
					<div class="mb-3">
						<label for="title" style="font-weight: bold">작성자</label>
						${qnaBoard.customer.id}
					</div>
					<div class="mb-3">
					<label for="title" style="font-weight: bold">강의명</label>
					${qnaBoard.product.id}</div>
					<div class="mb-3">
						<label for="title" style="font-weight: bold">제목</label> <input
							type="text" class="form-control" name="title" id="title"
							value="${qnaBoard.title}" disabled>
					</div>
					<div class="mb-3">
						<label for="content" style="font-weight: bold">내용</label>
						<textarea class="form-control" rows="5" name="content"
							id="content" value="${qnaBoard.subject}">${qnaBoard.subject}</textarea>
					</div>

					<!-- <div class="mb-3" id="formpwd">
						<label for="password" style="font-weight: bold">비밀번호</label> <input
							type="password" class="form-control" name="title" id="title"
							placeholder="최대4자리" maxlength="4">
					</div> -->
				</form>
				<div>
					<c:if test="${userId == qnaBoard.customer.id}">
						<!-- 본인이 쓴 글인 경우 수정/삭제 버튼 보이기 -->
						<button type="button" class="btn btn-sm btn-primary" id="btnSave">수정</button>
						<button type="button" class="btn btn-sm btn-primary" id="btnDel">삭제</button>
					</c:if>
					<button type="button" class="btn btn-sm btn-primary"
						onclick='location.href="${path}/javaChip?command=selectAllQnA"'>목록</button>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; KOSTA_2조
				2020</p>
		</div>
		<!-- /.container -->
	</footer>


	<!-- Bootstrap core JavaScript -->
	<script src="${path}/community/vendor/jquery/jquery.min.js"></script>
	<script
		src="${path}/community/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>

</body>

</html>
