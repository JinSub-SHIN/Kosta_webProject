<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>JavaChip-회원가입</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
    
</head>

<body>

    <div class="page-wrapper p-t-100 p-b-100 font-robo">
        <div class="wrapper wrapper--w680">
            <div class="card card-1"><img src="images/logo.png" style="text-align: center; height: 110px"><hr>                
                <div class="card-body">
                    <h2 class="title">회원가입</h2>
                    
                    <form method="POST" action="../javaChip?command=insertCus" 
                    	name="userinfo" onsubmit="return checkValue()">
                        <div class="input-group">
                            <input class="input--style-1" type="text" placeholder="아이디" id="inserid" name="id" style="width: 380px"
                            onkeydown="inputIdChk()">
                            <font id="idcheck" size="2"></font>
                            <button class="btn btn--radius btn--green" onclick="button_onclick()" type="button">중복확인</button> 
                            <input type="hidden" id="idchk" value="N" />                          
                        </div>                        
                        <div class="input-group">
                            <input class="input--style-1" type="password" id="password_1"  placeholder="비밀번호" name="pwd">
                        </div>
                       <div class="input-group">
                            <input class="input--style-1" type="password" id="password_2" placeholder="비밀번호를 한번더 입력하세요" name="repassward">
                            <font id="check" size="2"></font>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-1 " type="text" placeholder="성함" name="name" id="namechk" 
                                    onKeyup="this.value=this.value.replace(/[^(ㄱ-힣a-zA-Z)]/gi,'');"/>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="gender">
                                            <option disabled="disabled" selected="selected">성별</option>
                                            <option>남자</option>
                                            <option>여자</option>
                                            <option>Other</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
						<div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-1 " type="text" placeholder="전화번호 ( '-' 제외 입력)" name="phone"
                                    id="phonechk" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
                                    <font id="phonecheck" size="2"></font>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-1" type="text" id="agechk" placeholder="나이" name="age" 
                                    onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
                                	<font id="agecheck" size="2"></font>
                                </div>
                            </div>
                        </div>
                                
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-1" type="text" placeholder="E-MAIL" name="email">
                                </div>
                            </div>
                        </div>
                        <div class="p-t-20">
                            <button class="btn btn--radius btn--green" type="submit" id="join">가입</button>                            
                        </div>                        
                    </form>
                    
                    <div class="p-t-20">
                    <button class="btn btn--radius btn--green" onclick="window.close()">창닫기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

	<script type="text/javascript">
	
	function button_onclick(){
		var over = $('#inserid').val();
		
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
	
	///////////////////////////////////////
	
	
	function checkValue() {
		var form = document.userinfo;
		var string = /admin/gi;
		
		if(form.id.value.match(string)){
			alert("그 단어는 포함될 수 없습니다");
			return false;
		}
		
		if(!form.id.value){
			alert("아이디를 입력하세요");
			return false;
		}
		
		if(!form.pwd.value){
			alert("비밀번호를 입력해주세요");
			return false;
		}
		
		if(form.pwd.value != form.repassward.value){
			alert("비밀번호를 동일하게 입력해주세요");
			return false;
		}
		
		if(!form.name.value){
			alert("이름을 입력해주세요");
			return false;
		}
		
		if(!form.gender.value){
			alert("성별을 선택해주세요");
			return false;
		}
		
		if(!form.phone.value){
			alert("전화번호를 입력해주세요");
			return false;
		}
		
		if(!form.age.value){
			alert("나이를 입력해주세요");
			return false;
		}
		
		if(!form.email.value){
			alert("e-mail을 입력해주세요");
			return false;
		}
		
	}
	
	$(function(){
		
		var join = document.getElementById('join');
		var inid = $('#inserid').val();
		var string = /admin/gi;
		
		$('#password_1').keyup(function(){
			$('#check').html('');
		});
		
		/* $('#inserid').keyup(function{
			if(inid.match(string)){
				$('#idcheck').html('단어<br>');
				$('#idcheck').attr('color', '#f82a2aa3');
			}
		}); */
		
		$('#password_1').keyup(function(){
			if($('#password_1').val().length<1 || $('#password_1').val().length>10){
				$('#check').html('비밀번호는 1자리 이상 10자리 이하만 가능합니다<br>');
				$('#check').attr('color', '#f82a2aa3');
			}	
		});
		
		$('#password_2').keyup(function(){
			if($('#password_1').val() != $('#password_2').val()){
				$('#check').html('비밀번호가 일치하지 않습니다<br>');
				$('#check').attr('color', '#f82a2aa3');
				
			}else{
				$('#check').html('비밀번호 일치<br>');
				$('#check').attr('color', '#199894b3');
			}
		});
		
		$('#agechk').keyup(function(){
			if(event.keyCode<48 || event.keyCode>57){
				$('#agecheck').html('숫자만 입력해주세요<br>');
				$('#agecheck').attr('color', '#f82a2aa3');
			}
		});
		
		$('#namechk').keyup(function(){
			if(event.keyCode>=37 || event.keyCode<=40){
				$('#namechk').html('문자만 입력해주세요<br>');
				$('#namechk').attr('color', '#f82a2aa3');
			}
		});
		
		$('#phonechk').keyup(function(){
			if(event.keyCode<48 || event.keyCode>57){
				$('#phonecheck').html('숫자만 입력해주세요<br>');
				$('#phonecheck').attr('color', '#f82a2aa3');
			}
		});

	});
</script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->