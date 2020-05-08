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
<style>
.secret {
	display: none;
}

#answerForm {
	display: none;
}

.userStatus {
	display: none;
}
</style>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
	$(function() {
		if(${sessionScope.userStatus} == 2 || ${sessionScope.userStatus} == 3){//관리자면 비밀글 show
			$('.secret').show();
			$('#formpwd').hide();
		}
		if($('.userStatus').text()==2){ //작성자가 강사인 경우, 답글작성버튼 숨기기
			$('#answer').hide();
		}
		$("button[name=confrim]").click(function() {
			 $.ajax({
				url : "community/pwdCheck.jsp",
				type : "post",
				data : "no="+${qnaBoard.qaBoardNo}+"&pwd="+$('input[name=pwd]').val(),
				success : function(jsonObj){
					if(jsonObj.status == 1){
						$('.secret').show();
					}else if(jsonObj.status == -1){
						alert(jsonObj.msg);
					}else{
						alert("잘못된 접근입니다.");
					}			
				}//end succ
			});
		});
		$('#btnSave').click(function() {
			alert("수정되었습니다!");
			location.href = "javaChip?command=updateQnA&qaBoardNo=" + ${qnaBoard.qaBoardNo}+"&content=" + $('#content').val();
		});//end save

		$('#btnDel').click(function() {
			location.href = "javaChip?command=deleteQnA&qaBoardNo=" + ${qnaBoard.qaBoardNo};
		});//end delete
		
		$('#answer').click(function(){
			$('#answerForm').show();
		});//end click
		
		$('#answerSave').click(function(){//답변 저장
			location.href
				="javaChip?command=insertQnA&no="+${qnaBoard.qaBoardNo}+"&content="+$('[name=answer]').val()+"&title="+$('[name=title]').val()+"&prodId="+$('.prodName').text();
		});//end click
	});//end load
</script>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="${path}/marga/index.jsp">J A V A C
				H I P</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
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
				<!-- qna 상세 폼 시작 -->
				<h2 style="text-align: center; margin-top: 20px;">QnA</h2>
				<hr>
				<c:choose>
					<c:when test="${qnaBoard.status == 0}">
						<!-- 일반글 -->
						<form name="form" role="form" method="post" class="normal">
							<div class="mb-3">
								<label for="title" style="font-weight: bold">작성자</label>
								${qnaBoard.customer.id} <span class="userStatus">${requestScope.userStatus}</span>
							</div>
							<div class="mb-3">
								<label for="title" style="font-weight: bold">강의명</label> <span
									class="prodName">${qnaBoard.product.id}</span>
							</div>
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
						</form>
					</c:when>
					<c:when test="${qnaBoard.status == 1}">
						<!-- 비밀글 -->
						<form name="form" role="form" method="post" class="secret">
							<div class="mb-3">
								<label for="title" style="font-weight: bold">작성자</label>
								${qnaBoard.customer.id} <span class="userStatus">${requestScope.userStatus}</span>
							</div>
							<div class="mb-3">
								<label for="title" style="font-weight: bold">강의명</label> <span
									class="prodName">${qnaBoard.product.id}</span>
							</div>
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

						</form>

						<div class="mb-3" id="formpwd">
							*비밀글은 비밀번호 입력 후 확인 가능합니다.<br> <label for="password"
								style="font-weight: bold">비밀번호</label> <br> <input
								type="password" class="" name="pwd" placeholder="최대4자리"
								maxlength="4">
							<button name="confrim" class="btn btn-sm btn-primary">확인</button>
						</div>
					</c:when>
				</c:choose>

				<div>
					<c:if test="${userId == qnaBoard.customer.id}">
						<!-- 본인이 쓴 글인 경우 수정/삭제 버튼 보이기 -->
						<button type="button" class="btn btn-sm btn-primary" id="btnSave">수정</button>
						<button type="button" class="btn btn-sm btn-primary" id="btnDel">삭제</button>
					</c:if>

					<c:if test="${sessionScope.userStatus==2}">
						<!-- 강사에게는 답변 작성 버튼 show -->
						<button type="button" class="btn btn-sm btn-primary" id="answer">답변작성하기</button>
					</c:if>
					<button type="button" class="btn btn-sm btn-primary"
						onclick='location.href="${path}/javaChip?command=selectAllQnA"'>목록</button>
				</div>

				<div class="mb-3" id="answerForm">
					<!-- 답변 폼 -->
					<hr>
					<label for="content" style="font-weight: bold">답변 내용</label>
					<textarea class="form-control" rows="5" name="answer"></textarea>
					<br>
					<button type="button" class="btn btn-sm btn-primary"
						id="answerSave">저장</button>
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
