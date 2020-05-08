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
    <title>JavaChip_Tables</title>

    <!-- Fontfaces CSS-->
    <link href="${path}/Admin/css/font-face.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="${path}/Admin/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
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

<script>
</script>



</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="${path}/Admin/index.jsp">
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
                <a href="${path}/javaChip?command=SelectCus">
                    <img src="images/icon/logo.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li class="has-sub">
                            <a class="js-arrow" href="${path}/javaChip?command=SelectCus">
                                <i class="fas fa-tachometer-alt"></i>대시보드</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">                               
                            </ul>
                        </li>                       
                        <li class="active">
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
            <!-- END HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-9" style="max-width: 100%">
                            <h2 class="title-1 m-b-25">판매품목</h2>
                                    <button class="au-btn au-btn-icon au-btn--blue" 
                                   onclick="window.open('${path}/javaChip?command=Admininput','상품등록','width=700,height=540,location=no,status=no,scrollbars=yes');">                                   
                                        <i class="zmdi zmdi-plus"></i>상품등록</button>
                                    <button class="au-btn au-btn-icon au-btn--blue" 
                                   onclick="window.open('writeChapter.jsp','강의등록','width=700,height=540,location=no,status=no,scrollbars=yes');">
                                        <i class="zmdi zmdi-plus"></i>강의등록</button>
                                        
                                        <hr>            
                                <div class="table-responsive table--no-card m-b-30">
                                    <table class="table table-borderless table-striped table-earning">                                        
                                         <thead>
                                            <tr>
                                            	<th>등록일</th>
                                                <th>상품번호</th>
                                                <th>카테고리</th>
                                                <th>상품이름</th>
                                                <th>강사명</th>
                                                <th>유효기간</th>                                                
                                                <th class="text-right">금액</th>
                                                <th>삭제</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>                                        
                                        <c:forEach items="${Gangi}" var="list">
                                            <tr>
                                            	<td>${list.product.uploadDate}</td>
                                                <td>${list.product.id}</td>
                                                <td>${list.category.name}</td>
                                                <td>${list.product.name}</td>
                                                <td>${list.product.teacher.name}</td>
                                                <td>${list.product.validDate}일</td>
                                                <td class="text-right">${list.product.price}원</td>
                                                <td>
                                                <form action="${path}/javaChip?command=deleteProd" method="post">
                                                <input type="text" name="delete" id="val" value="${list.product.id}" style="color: black; display: none;">
                                                <input type="submit" value="삭제" id="de" style="border: 1px solid; background-color: silver;">
                                                </form>                                               
                                                </td>                                                                                                
                                            </tr>
                                        </c:forEach>                                       
                                        </tbody>                                       
                                    </table>
                                </div>
                            </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
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

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->
