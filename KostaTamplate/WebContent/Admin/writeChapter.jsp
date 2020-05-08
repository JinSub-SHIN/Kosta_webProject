<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${path}/Admin/css/style.css">
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
								alert("해당 상품이 없습니다.");
								$("#dupcheck").val('N');
							} else {
								alert("등록가능합니다");
								$("#dupcheck").val('Y');
							}						
						}
						
					});					
				}
				
			}
			
			
		var isit2 = document.getElementById("isit2");	
			
		isit2.onclick = function(){
			
			var chap = document.getElementById("chapternum").value;
			var num2 = document.getElementById("prodnum").value;
			
			if(chap=="" || chap==null){
				
				alert("입력값을 확인해주세요");
				
				document.getElementById("chapternum").focus();
				 
			} else { 
		
				$.ajax({
					type : "post" ,					
					data : "id="+num2+"&id2="+chap ,
					dataType : "text" ,
					url : "${path}/ChapterDupCheckServlet" ,
					success : function(Data){
						
						if(Data=="x"){
							alert("해당 상품의 챕터는 이미 존재합니다.");
							$("#dupcheck2").val('N');
						} else {
							alert("등록가능합니다");
							$("#dupcheck2").val('Y');
						}						
					}
					
				});	
				
			}
			
		}
			
	});
		
	function checkValid() {
	    var f = window.document.writeForm;
			
		if ( f.model_num.value == "") {
		    alert( "상품번호를 입력해 주세요." );
		    f.model_num.focus();
			return false;
	    }
		if ( f.chapter_num.value == "" ) {
			alert( "챕터를 입력해 주세요." );
			f.chapter_num.focus();
			return false;
		}
		
		if ( f.dupcheck.value == "N") {
			alert( "상품번호 체크를 해주세요.");
			return false;
		}
		
		if ( f.dupcheck2.value == "N") {
			alert( "챕터 체크를 해주세요.");
			return false;
		}
		
		if ( f.title.value == "") {
		    alert( "상품번호를 입력해 주세요." );
		    f.title.focus();
			return false;
	    }
		if ( f.video_file.value == "") {
		    alert( "강의 동영상을 첨부해 주세요." );
		    f.video_file.focus();
			return false;
	    }
		
	    return true;
	}

</script>


</HEAD>
<BODY>

<form name="writeForm" method="post" action="${path}/javaChip?command=insertProdDetatil" 
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
		<input type=text name="model_num" size="30" id="prodnum" ></span></b><button type="button" id="isit">체크</button>
		<input type="hidden" name="dupcheck" id="dupcheck" value="N">
		</td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">챕터번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="chapter_num" id="chapternum" size="30"></span></b><button type="button" id="isit2">체크</button>
		<input type="hidden" name="dupcheck2" id="dupcheck2" value="N">
		</td>
    </tr> 
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">주제입력</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="title" size="30"></span></b></td>
    </tr>  
     <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">*동영상첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="video_file" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>  
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">*강의자료첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="text_file" maxlength="60" size="40">
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

