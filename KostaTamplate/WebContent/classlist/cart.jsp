<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>JavaChip-Cart</title>

  <!-- Bootstrap core CSS -->
  <link href="${path}/classlist/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${path}/classlist/css/heroic-features.css" rel="stylesheet">

<style>

table{
	border: 1px solid;
}

td, th{
	width: 400px;
	height: 40px;
	font-size: 20px;
	border: 1px solid;
	text-align: center;
}

.jumbotron{
	padding: 0;
}

#tdteacher, #tdlevel{

	display: none;

}

</style>

<script src="${path}/marga/js/jquery-3.3.1.min.js"></script>
<script>

	window.addEventListener("load", function(){
		
		var tdcate = document.getElementById("tdcate");
		var tdteacher = document.getElementById("tdteacher");		
		
		var selectcate2 = document.getElementById("selectcate");
		var selectteacher2 = document.getElementById("selectteacher");		
		
		selectcate2.onchange = function(){
			
			var selectcate = document.getElementById("selectcate").value;
			
			if(selectcate == "카테고리별"){
				
				tdteacher.style.display = "none";				
				
			} else {
				
				tdteacher.style.display = "inline-block";
								
	   		$.ajax({
	    			url: "/webProject_JavaChip/jogun" ,
	    			type: "post",
	    			data: {"value" : selectcate},
	    		    dataType:"json" , 
	    		    success : function(result){ 	    		    
	    		    	var str = ""; 
	    		    	
	    		    	$.each(result, function(index, item){	    		    		
	    		    			    		    		
	    		    		str+= "<div class='col-lg-3 col-md-6 mb-4'>";
	    		    		str+= "<div class='card h-100'>";
	    		    		str+= "<img class='card-img-top' src='/webProject_JavaChip/classlist/images/"+item.product.teacher.pictureName+"' alt=''>"
	    		    		str+= "<div class='card-body'>";
	    		    		str+= "<h4 class='card-title' style='color: green; font-weight: bold;'>"+item.product.teacher.name+"강사</h4><hr>"
	    		    		str+= "<h4 class='card-title'>"+item.product.name+"</h4>";
	    		    		str+= "<p class='card-text'>"+item.product.description+"</p>"
	    		    		str+= "</div>";
	    		    		str+= "<div class='card-footer'>";
	    		    		str+= "<a href='${path}/javaChip?command=selectProdInfo&prodId="+item.product.id+"' class='btn btn-primary'>자세히보기</a>"
	    		    		str+= "</div>";
	    		    		str+= "</div>";
	    		    		str+= "</div>";		    		    		
	    		    	});  
	    		    	
	    		  	 	$('#jogunlist').empty();
	    		    	$('#jogunlist').append(str);
	    		    	$("a").css("textDecoration", "none");
	    		    	
	    		    } , 
	    		    error:function(err){
	    		    	alert("에러 : "+err)
	    		    } 
	    		});
	   		
			}		
		}
		
		selectteacher2.onchange = function(){
			
			var selectteacher = document.getElementById("selectteacher").value;
			var selectcate = document.getElementById("selectcate").value;
			
			if(selectteacher == "강사별"){			
				
				tdlevel.style.display = "none";
				
			} else {
				
				console.log(selectteacher);				
				
		   		$.ajax({
	    			url: "${path}/jogun" ,
	    			type: "post",
	    			data: {"value" : selectcate , "value2" : selectteacher},
	    		    dataType:"json" , 
	    		    success : function(result){ 
	    		    	 
	    		    	var str = ""; 	    		    	
	    		    	$.each(result, function(index, item){	    		    		
	    		    			    		    		
	    		    		str+= "<div class='col-lg-3 col-md-6 mb-4'>";
	    		    		str+= "<div class='card h-100'>";
	    		    		str+= "<img class='card-img-top' src='/webProject_JavaChip/classlist/images/"+item.product.teacher.pictureName+"' alt=''>"
	    		    		str+= "<div class='card-body'>";
	    		    		str+= "<h4 class='card-title' style='color: green; font-weight: bold;'>"+item.product.teacher.name+"강사</h4><hr>"
	    		    		str+= "<h4 class='card-title'>"+item.product.name+"</h4>";
	    		    		str+= "<p class='card-text'>"+item.product.description+"</p>"
	    		    		str+= "</div>";
	    		    		str+= "<div class='card-footer'>";
	    		    		str+= "<a href='${path}/javaChip?command=selectProdInfo&prodId="+item.product.id+"' class='btn btn-primary'>자세히보기</a>"
	    		    		str+= "</div>";
	    		    		str+= "</div>";
	    		    		str+= "</div>";		    		    		
	    		    	});  
	    		    	
	    		  	 	$('#jogunlist').empty();
	    		    	$('#jogunlist').append(str);
	    		    	$("a").css("textDecoration", "none"); 
	    		    	
	    		    } , 
	    		    error:function(err){
	    		    	alert("에러 : "+err)
	    		    } 
	    		});
				
			}
			
		}
		
	});

</script>


</head>

<body>

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
			          <c:if test="${sessionScope.userStatus==1}">
			          <li class="nav-item">
			            <a class="nav-link" href="${path}/javaChip?command=selectByCusIdOrderLine"><span style="color: white; font-weight: bold">마이페이지/내강의실</span></a>
			          </li>
			          </c:if>
			          <c:if test="${sessionScope.userStatus==2}">
			          <li class="nav-item">
			            <a class="nav-link" href="${path}/javaChip?command=Tgangmok"><span style="color: white; font-weight: bold">마이페이지</span></a>
			          </li></c:if>
			          <c:if test="${sessionScope.userStatus==1}"><!-- customer에게만 장바구니 보이기 -->
			          <li class="nav-item">
						<a class="nav-link" href="${path}/javaChip?command=selectCart&id=${userId}"><span style="color: white; font-weight: bold">장바구니</span></a>
					  </li>
					  </c:if>
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
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
    <div class="row" style="text-align: center; box-shadow: 1px;">
     <div class="col-4" style="background-color: white;">
     <img src="${path}/classlist/images/1jangteacher.jpg" style="width: 350px; height: 270px;">
     </div>
     <div class="col-8" style="background-color: white;">
      <h3>※ 최  다  판  매  량 ※</h3>
      <hr>
      <p class="lead">자바칩의 자랑 장희정 강사!<br> 프로그래밍계의 전설!<br> 패키지로 바로 만나보세요!<br><br></p>
      <a href="${path}/javaChip?command=selectProdInfo&prodId=PACK" class="btn btn-primary btn-lg">패키지구매하기</a>
      </div> 
      </div>
    </header>

	<div>
	
	<table>
		<tr><th rowspan="2">구분별</th><th colspan="3">검색조건을 선택하세요!</th></tr>
		<tr>
		<td id="tdcate">
		
		<select name="category" id="selectcate">
			<option>카테고리별</option>
			<c:forEach items="${cate}" var="catelist">
			<option>${catelist.name}</option>		
			</c:forEach>
		</select>
		</td>
		<td id="tdteacher">
		<select name="teacher" id="selectteacher">
			<option>강사별</option>
			<c:forEach items="${set}" var="set">
			<option>${set}</option>
			</c:forEach> 
		</select>
		</td>
		</tr>		
	</table>
	<p>
	
	</div>
    <!-- Page Features -->
    <div class="row text-center" id="jogunlist">

	<c:forEach items="${Gangi}" var="list">
      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="${path}/classlist/images/${list.product.teacher.pictureName}" alt="">
          <div class="card-body">
            <h4 class="card-title" style="color: green; font-weight: bold;">${list.product.teacher.name}강사</h4><hr>
            <h4 class="card-title">${list.product.name}</h4>
            <p class="card-text">${list.product.description}</p>
          </div>
          <div class="card-footer">
            <a href="${path}/javaChip?command=selectProdInfo&prodId=${list.product.id}" class="btn btn-primary">자세히보기</a>
          </div>
        </div>
      </div>
        
      </c:forEach>
        
      </div>
      
    </div>
    <!-- /.row -->


  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; KOSTA_2조 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="${path}/classlist/vendor/jquery/jquery.min.js"></script>
  <script src="${path}/classlist/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
