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
    <title>JavaChip_DashBoard</title>

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
                            <a href="${path}/Admin/form.jsp">
                                <i class="far fa-check-square"></i>고객관리</a>
                        </li>                        
                    </ul>
                </div>
            </nav>
        </header>
     </div>
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
                        <li class="active has-sub">
                            <a class="js-arrow" href="${path}/javaChip?command=SelectCus">
                                <i class="fas fa-tachometer-alt"></i>대시보드</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">                               
                            </ul>
                        </li>
                        <li>
                            <a href="${path}/javaChip?command=selectAdminProd">
                                <i class="fas fa-table"></i>판매품목</a>
                        </li>
                        <li>
                            <a href="${path}/Admin/form.jsp">
                                <i class="far fa-check-square"></i>고객관리</a>
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
                        
                        <!-- 여기에 강의명을 입력하였을때 action 처리 해준다... -->
                                                            
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
                                                    <a href="#">
                                                        <i class="zmdi zmdi-account"></i>Account</a>
                                                </div>
                                                <div class="account-dropdown__item">
                                                    <a href="#">
                                                        <i class="zmdi zmdi-settings"></i>Setting</a>
                                                </div>
                                                <div class="account-dropdown__item">
                                                    <a href="#">
                                                        <i class="zmdi zmdi-money-box"></i>Billing</a>
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
                            <div class="col-md-12">
                                <div class="overview-wrap">
                                    <h2 class="title-1">한눈에보기</h2>
                                </div>
                            </div>
                        </div>
                        <div class="row m-t-25">
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c1">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-account-o"></i>
                                            </div>
                                            <br>
                                            <div class="text">
                                                <h2>${size}</h2>
                                                <span>총 회원수</span>
                                            </div>
                                        </div>                                       
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c2">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-shopping-cart"></i>
                                            </div>
                                            <br>
                                            <div class="text">
                                                <h2>${num}</h2>
                                                <span>총 판매수량</span>
                                            </div>                                    
                                        </div>                                       
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c3">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-calendar-note"></i>
                                            </div>
                                            <br>
                                            <div class="text">
                                                <h2>${seven}</h2>
                                                <span>금주 판매량</span>
                                            </div>
                                        </div>                                        
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c4">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="fas fa-won-sign"></i>
                                            </div>
                                            <div class="text">
                                                <h2>${total}원</h2>
                                                <span>총 판매금액</span>
                                            </div>
                                        </div>                                       
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-9" style="max-width: 100%">
                                <h2 class="title-1 m-b-25">최근판매품목</h2>
                                <div class="table-responsive table--no-card m-b-40">
                                    <table class="table table-borderless table-striped table-earning">
                                        <thead>
                                            <tr>
                                                <th>결제일자</th>
                                                <th>주문번호</th>
                                                <th>상품ID</th>
                                                <th>고객ID</th>
                                                <th class="text-right">결제금액</th>
                                            </tr>
                                        </thead>
                                        <tbody>                                        
                                        <c:forEach items="${orderlist}" var="orderlist">
                                            <tr>
                                                <td>${orderlist.orderLine.payDate}</td>
                                                <td>${orderlist.orderLine.lineNo}</td>
                                                <td>${orderlist.product.id}</td>
                                                <td>${orderlist.orderLine.customer.id}</td>
                                                <td class="text-right">${orderlist.orderLine.totalPrice}원</td>                                                
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
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
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
