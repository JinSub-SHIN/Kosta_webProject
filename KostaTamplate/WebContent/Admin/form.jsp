<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags--> 
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>JavaChip_Forms</title>

    <!-- Fontfaces CSS-->
    <link href="${path}/Admin/css/font-face.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="${path}/Admin/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="${path}/Admin/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="${path}/Admin/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="${path}/javaChip?command=SelectCus">
                            <img src="images/icon/logo.png" alt="CoolAdmin" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
                        <li class="has-sub">
                            <a class="js-arrow" href="${path}/javaChip?command=SelectCus">
                                <i class="fas fa-tachometer-alt"></i>대시보드</a>
                            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">                                
                            </ul>
                        </li>                     
                        <li>
                            <a href="${path}/javaChip?command=selectAdminProd">
                                <i class="fas fa-table"></i>판매품목</a>
                        </li>
                        <li>
                            <a href="${path}/javaChip?command=teacherinput">
                                <i class="far fa-check-square"></i>등록</a>
                        </li>
                         <li>
                            <a href="${path}/javaChip?command=SelectAllperson">
                                <i class="far fa-check-square"></i>회원목록</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="${path}/Admin/index.jsp">
                    <img src="images/icon/logo.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li class="has-sub">
                            <a class="js-arrow" href="${path}/Admin/index.jsp">
                                <i class="fas fa-tachometer-alt"></i>대시보드</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">                                
                            </ul>
                        </li>                        
                        <li>
                            <a href="${path}/javaChip?command=selectAdminProd">
                                <i class="fas fa-table"></i>판매품목</a>
                        </li>
                        <li class="active">                        
                            <a href="${path}/javaChip?command=teacherinput">
                                <i class="far fa-check-square"></i>등록</a>
                        </li>
                        <li>
                            <a href="${path}/javaChip?command=SelectAllperson">
                                <i class="far fa-check-square"></i>회원목록</a>
                        </li>                        
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">

                            <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="images/icon/admin01.png" alt="JinSub_SHIN" />
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#">신진섭</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="images/icon/admin01.png" alt="JinSub_SHIN" />
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#">신진섭</a>
                                                    </h5>
                                                    <span class="email">JinSub@kosta.com</span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                    <a href="${path}/community/community.jsp">
                                                        <i class="zmdi zmdi-account"></i>커뮤니티</a>
                                                </div>
                                                <div class="account-dropdown__item">
                                                    <a href="${path}/javaChip?command=selectProd">
                                                        <i class="zmdi zmdi-settings"></i>자료등록</a>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__footer">
                                                <a href="${path}/javaChip?command=logout">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>  
                             </div>
                           </div>
                         </div>
                                                  
            </header>
            <!-- HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card">
                                    <div class="card-header">
                                        <strong>강사등록</strong>
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="${path}/javaChip?command=Insertteacher" method="post" enctype="multipart/form-data" class="form-horizontal">
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">ID</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="Tid" name="Tid" placeholder="ID" class="form-control">
                                                    <button class="btn btn--radius btn--green" onclick="button_onclick()" type="button">중복확인</button>                                                                                                        
                                                	<input type="hidden" id="idchk" value="N" />
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="password-input" class=" form-control-label">비밀번호</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="password" id="Tpwd" name="Tpwd" placeholder="Password" class="form-control">
                                               </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">이름</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="Tname" name="Tname" placeholder="NAME" class="form-control">                                                    
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">연락처</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="Tphone" name="Tphone" placeholder="'-'제외하고 입력하세요" class="form-control">                                                    
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="select" class=" form-control-label">성별</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <select name="select" id="select" class="form-control">
                                                        <option value="0">선택하세요</option>
                                                        <option value="남자">남자</option>
                                                        <option value="여자">여자</option>                                                       
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label class=" form-control-label">카테고리</label>
                                                </div>
                                                <div class="col col-md-9">
                                                    <div class="form-check">                                                    
                                                <c:forEach items="${clist}" var="clist">
	                                            <div class="radio">
	                                                <label for="radio1" class="form-check-label ">
	                                                    <input type="radio" name="radios" value="${clist.id}-${clist.name}" class="form-check-input">${clist.id}-${clist.name}
	                                                </label>
	                                            </div>                                                
								        		</c:forEach>               
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="file-input" class=" form-control-label">사진</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="file" id="fileinput" name="fileinput" class="form-control-file">
                                                </div>
                                            </div>		                                            
		                                    <div class="card-footer">
		                                        <button type="submit" class="btn btn-primary btn-sm">
		                                            <i class="fa fa-dot-circle-o"></i> 등록
		                                        </button>
		                                        <button type="reset" class="btn btn-danger btn-sm">
		                                            <i class="fa fa-ban"></i> 다시작성
		                                        </button>
		                                    </div>
                                        </form>
                                    </div>
                                </div>
                            <div class="card">
                                    <div class="card-header">
                                        <strong>관리자등록</strong>
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="${path}/javaChip?command=InsertAdmin" method="post" class="form-horizontal">
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label" id="insertid">ID</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="Tid2" name="Tid2" placeholder="ID" class="form-control">                                                    
                                                	<button class="btn btn--radius btn--green" onclick="button_onclick2()" type="button">중복확인</button>
                                                	<input type="hidden" id="idchk" value="N" />
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="password-input" class=" form-control-label">비밀번호</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="password" id="Tpwd" name="Tpwd" placeholder="Password" class="form-control">
                                               </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">이름</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="Tname" name="Tname" placeholder="NAME" class="form-control">                                                    
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">연락처</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="Tphone" name="Tphone" placeholder="'-'제외하고 입력하세요" class="form-control">                                                    
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="select" class=" form-control-label">성별</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <select name="select" id="select" class="form-control">
                                                        <option value="0">선택하세요</option>
                                                        <option value="남자">남자</option>
                                                        <option value="여자">여자</option>                                                       
                                                    </select>
                                                </div>
                                            </div>  
		                                    <div class="card-footer">
		                                        <button type="submit" class="btn btn-primary btn-sm">
		                                            <i class="fa fa-dot-circle-o"></i> 등록
		                                        </button>
		                                        <button type="reset" class="btn btn-danger btn-sm">
		                                            <i class="fa fa-ban"></i> 다시작성
		                                        </button>
		                                    </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2020 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                                    <p> KOSTA 2조 PROJECT 2020.04 수정됨.&nbsp;&nbsp;&nbsp;&nbsp;Modify - JinSub
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>
	
	<script type="text/javascript">
	function button_onclick(){
		var over = $('#Tid').val();
		
		if(over == null || over == ""){
			alert('아이디를 입력해주세요');
			return false;
		}
		
		$.ajax({
			type : 'POST', data : "id="+over, dataType : 'text', 
			url : '../idCheckServlet',		
			success : function(Data){
				var chkRst = Data;
				 if(chkRst==0){
					alert("등록가능합니다");
					$("#idchk").val('Y');
				}else{
					alert("중복 아이디입니다");
					$("#idchk").val('N');
					
				} 
			}
		});
	} 
	
	function button_onclick2(){
		var over = $('#Tid2').val();
		
		if(over == null || over == ""){
			alert('아이디를 입력해주세요');
			return false;
		}
		
		$.ajax({
			type : 'POST', data : "id="+over, dataType : 'text', 
			url : '../idCheckServlet',		
			success : function(Data){
				var chkRst = Data;
				 if(chkRst==0){
					alert("등록가능합니다");
					$("#idchk").val('Y');
				}else{
					alert("중복 아이디입니다");
					$("#idchk").val('N');
					
				} 
			}
		});
	}
	
	</script>
	
    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->
