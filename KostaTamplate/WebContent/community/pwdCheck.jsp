<%@page import="model.service.QnAService"%>
<%@page import="model.domain.QnABoard"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
String no = request.getParameter("no"); 
String pwd = request.getParameter("pwd");

QnABoard qnaBoard=QnAService.selectByNo(Integer.parseInt(no));
if(qnaBoard.getPwd() == Integer.parseInt(pwd)) {%>
{"status":1, "msg": "비밀번호가 일치합니다."}<%	
}else {%>
{"status":-1, "msg": "비밀번호가 일치하지 않습니다."}<%
}
%>