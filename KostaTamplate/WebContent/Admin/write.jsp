<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${path}/Admincss/style.css">

<script src="${path}/Admin/js/jquery-3.3.1.min.js"></script>
<script>

	window.addEventListener("load", function(){
		
		var isit = document.getElementById("isit");
		
		
		isit.onclick = function(){
			
			var num = document.getElementById("prodnum").value;
			
			if(num=="" || num==null){
				
				alert("입력값을 확인해주세요");
				
				document.getElementById("prodnum").focus();
				
			} else {
				
				$.ajax({
					
					type : "post" ,
					data : "id="+num ,
					dataType : "text" ,
					url : "${path}/prodCheck" ,
					success : function(Data){
						
						if(Data=="o"){
							alert("등록가능합니다");
							$("#dupcheck").val('Y');
						} else {
							alert("이미 등록된 상품입니다");
							$("#dupcheck").val('N');
						}						
					}
					
				});
				
			}
			
		}	

		var level = document.getElementById("level");				
		var levelinput = document.getElementById("levelinput");				
		
		level.onchange = function(){			
			if(level.value == "직접입력"){								
				levelinput.type = "text";
			} else {
				levelinput.type = "hidden";
			}
		};
		

		
	});
	
	function checkValid() {
	    var f = window.document.writeForm;
			
		if ( f.model_num.value == "") {
		    alert( "상품번호를 입력해 주세요." );
		    f.model_num.focus();
			return false;
	    }
		if ( f.model_name.value == "" ) {
			alert( "상품이름을 입력해 주세요." );
			f.model_name.focus();
			return false;
		}
		if ( f.price.value == "" ) {
			alert( "가격을 입력해 주세요." );
			f.price.focus();
			return false;
		}
		if ( f.description.value == "" ) {
	        alert( "상품 설명을 입력해 주세요." );
	        f.description.focus();
	        return false;
	    }
		
		if ( f.dupcheck.value == "N") {
			alert( "중복 확인을 해주세요");
			return false;
		}
		
		if( f.level.value == "레벨선택"){
			alert( "레벨을 선택 해주세요");
			return false;
		}
		
		if( f.cate.value == "카테고리선택"){
			alert( "카테고리를 선택 해주세요");
			return false;
		}
		
		if( f.teacher.value == "강사선택"){
			alert( "강사를 선택 해주세요");
			return false;
		}
		
		if( f.validDate.value == ""){
			alert( "유효기간을 입력해주세요");
			return false;
		}
		
	    return true;
	}
	
</script>

</HEAD>
<BODY>

<form name="writeForm" method="post" action="${path}/javaChip?command=insertProd" 
  onSubmit='return checkValid()'>

<table align="center" cellpadding="5" cellspacing="2" width="600" border="2" >
  
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b> 상품 등록 </b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">상품번호</span></b></p>
            
        </td>        
        <td width="450" height="20"><b><span style="font-size:9pt;">		
		<input type=text name="model_num" size="30" id="prodnum"></span></b><button type="button" id="isit">중복체크</button>
		<input type="hidden" name="dupcheck" id="dupcheck" value="N">
		</td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">상품이름</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="model_name" size="30"></span></b></td>
    </tr>    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">레벨</span></b></p>            
        </td>
        <td>        	
        	<select name="level" id="level">
        		<option>레벨선택</option>
	        	<c:forEach items="${list}" var="list">
				<option>${list}</option>		
				</c:forEach>
				<option>직접입력</option>       		
        	</select>
        	<input type="hidden" name="levelinput" id="levelinput" placeholder="직접입력하세요">        	
        </td>        
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">카테고리</span></b></p>
        </td>
        <td>
        	<select name="cate" id="cate">
        		<option>카테고리선택</option>
        		<c:forEach items="${clist}" var="clist">
        		<option>${clist.id}-${clist.name}</option>
        		</c:forEach>        		 		        		
        	</select>        	      
        </td>        
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">강사명</span></b></p>
        </td>
        <td>
        	<select name="teacher" id="teacher">
        		<option>강사선택</option>
        		<c:forEach items="${tlist}" var="tlist">
        		<option>${tlist.id}-${tlist.name}</option>
        		</c:forEach>        		        		
        	</select>        	        
        </td>        
    </tr>    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">가격</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="price" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">유효기간</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="validDate" size="30"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">상세설명</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<textarea name="description" cols="50" rows="10"></textarea></span></b></td>
    </tr>  
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=상품등록> 
        <input type=reset value=초기화></span></b></td>
    </tr>
</table>

</form>

</BODY>
</HTML>

