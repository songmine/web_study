<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*"%>
<%
 	Date d = new Date();
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <table border="1">
 <tr>
 	<td>현재시간</td>
	<td><%=d.toString()%></td>
 <tr>
 </table>
</body>
</html>