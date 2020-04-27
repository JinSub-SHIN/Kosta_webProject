<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">

<SCRIPT language=javascript>

	window.addEventListener("load", function(){
		
		var isit = document.getElementById("isit");
		var mit = document.getElementById("submit");
		var check = 0;
		
		isit.onclick = function(){
			
			var num = document.getElementById("prodnum").value;
			console.log(num);
			
			if(num=="12345"){
				
				alert("등록가능한 상품입니다");
				check = 1;			
				
			} else {
				
				alert("상품이 존재하지 않습니다");
			}						
		}
		
		mit.onclick = function(){
			
			if(check==0){
				
				alert("상품존재여부체크 먼저해주세요");
				return;
				
			} else {
				
				alert("등록성공!");
				window.close();				
			}
		};
		
	});

</SCRIPT>


</HEAD>
<BODY>

<form name="writeForm" method="post" action="" 
  onSubmit='return checkValid()' enctype="multipart/form-data">

<table align="center" cellpadding="5" cellspacing="2" width="600" border="2" >
  
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b> 강의 등록 </b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">상품번호</span></b></p>
            
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="model_num" size="30" id="prodnum" ></span></b><button type="button" id="isit">존재여부체크</button></td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">챕터번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="model_num" size="30"></span></b></td>
    </tr>  
     <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">*동영상첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>  
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">*강의자료첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="file" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>   

    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=상품등록 id="submit"> 
        <input type=reset value=초기화></span></b></td>
    </tr>
</table>

</form>

</BODY>
</HTML>

