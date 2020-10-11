<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.model.*" %>
<%
	MyUtil my = new MyUtil();
	int sum = my.hap();
    String user_id = request.getParameter("user_id");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%=sum%> 
</body>
</html>