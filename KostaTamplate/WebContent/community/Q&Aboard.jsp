<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>JavaChip-Community</title>

  <!-- Bootstrap core CSS -->
  <link href="${path}/community/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">  

  <!-- Custom styles for this template -->
  <link href="${path}/community/css/simple-sidebar.css" rel="stylesheet">

<style>
table{
	width: 1200px;
	margin-top: 20px;
}
.qnaNo{
	display: none;
}
.kickOut{
	border:0px;
}
</style>
</head>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
$(function(){
	$('button[name=adminDel]').click(function(){ //admin이 게시글 삭제
		location.href="${path}/javaChip?command=deleteQnA&qaBoardNo="+$(this).val();
	});
	
	$('td[class=count]').click(function(){ 
		$.ajax({
			url : "${path}/javaChip?command=addViewCount",
			type : "get",
			data : "no="+$(this).find('span').text(),
			success : function(){
				
			}
		}); //end ajax
	});//end count
	
	$('a[name=qnaDetail]').click(function(e){
		if(${sessionScope.userId==null}){
			alert('로그인이 필요합니다.');
			e.preventDefault();
		}
	});
});

window.onload = function(){
	var kickOutBt = document.getElementsByClassName('kickOut');
	
	for(var i=0; i<kickOutBt.length; i++){
		kickOutBt[i].onclick = function(){
			if(confirm("강제탈퇴 시키시겠습니까?")){
				location.href="${path}/javaChip?command=kickOutCustomer&customerId="+$(this).val();
			}
		}
	}
};
</script>
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
										<c:if test="${sessionScope.userStatus == 1}">
										<li class="nav-item"><a class="nav-link"
											href="${path}/mypage/mypage.jsp"><span
												style="color: white; font-weight: bold">마이페이지/내강의실</span></a></li>
										<li class="nav-item"><a class="nav-link"
											href="${path}/mycart/newmycart.jsp"><span
												style="color: white; font-weight: bold">장바구니</span></a></li>
										</c:if>
							        	<c:if test="${sessionScope.userStatus==2}">
							         	<li class="nav-item">
							          	 <a class="nav-link" href="${path}/javaChip?command=Tgangmok"><span style="color: white; font-weight: bold">마이페이지</span></a>
							         	</li>
							          	</c:if>
									<li class="nav-item"><a class="nav-link"
										href="${path}/javaChip?command=selectProd"><span
											style="color: white; font-weight: bold">강의목록</span></a></li>
									<li class="nav-item"><a class="nav-link"
										href="${path}/javaChip?command=community"><span
											style="color: white; font-weight: bold">커뮤니티</span></a></li>
									<c:if test="${sessionScope.userStatus == 3}">
									<li class="nav-item"><a class="nav-link"
										href="${path}/Admin/index.jsp"><span
											style="color: white; font-weight: bold">관리자페이지</span></a></li>
									</c:if>
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
					class="list-group-item list-group-item-action bg-light">QnA게시판</a>
				<a href="${path}/javaChip?command=selectAllEst"
					class="list-group-item list-group-item-action bg-light">강의평게시판</a>
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
				<table class="table table-striped">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
							<c:if test="${userStatus == 3}"><th>삭제</th></c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${QnAList}" var="qna" varStatus="state">
							<tr>
								<td>${state.count}</td>
								<c:choose>
								<c:when test="${qna.status == 0}"> <!-- 일반글 -->
									<td class="count">
									<a href="${path}/javaChip?command=selectQnAByNo&no=${qna.qaBoardNo}" name="qnaDetail">${qna.title}</a>
									<span class="qnaNo">${qna.qaBoardNo}</span></td>
								</c:when>			
								<c:when test="${qna.status == 1}"> <!-- 비밀글 -->
									<td class="count">
									<a href="${path}/javaChip?command=selectQnAByNo&no=${qna.qaBoardNo}">비밀글 입니다.</a>
									<span class="qnaNo">${qna.qaBoardNo}</span></td>
								</c:when>
								<c:otherwise>
									<td>비밀글 입니다.</td>
								</c:otherwise>
								</c:choose>
								<td><button class="kickOut" value="${qna.customer.id}">${qna.customer.id}</button></td>
								<td>${qna.writeDay}</td>
								<td>${qna.count}</td>
								<!-- admin에게는 삭제 버튼 보이기 -->
								<c:if test="${sessionScope.userStatus == 3}">
									<td><button value="${qna.qaBoardNo}" name='adminDel'>삭제</button></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<hr>
				<c:if test="${not empty itemList}">
					<!-- 구매한 상품이 있으면 질문하기 버튼 보이기 -->
					<button style="float: right"
						onclick="location.href='community/qnaForm.jsp'">질문하기</button>
				</c:if>
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
