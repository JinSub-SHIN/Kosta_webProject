<%@page import="model.domain.EstimateBoard"%>
<%@page import="java.util.List"%>
<%@page import="model.service.EstimateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//String userId = request.getParameter("userId");
String userId = (String) request.getSession().getAttribute("userId");
List<EstimateBoard> list = EstimateService.selectByCustomerId(userId);
if(list.isEmpty()){%>
	{"status" : 1, "msg" : "작성한 강의평이 없습니다."}<%
}else{%>
	{"status" : -1, "msg" : "이미 강의평을 작성하였습니다."}<%
}
%>