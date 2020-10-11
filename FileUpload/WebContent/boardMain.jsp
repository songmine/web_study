<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.BoardDAO"%>
<%@page import="com.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/board.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
</head>
<body>		
			<%
				BoardDAO dao = new BoardDAO();
				ArrayList<BoardDTO> list = dao.viewAll();
				request.setAttribute("list", list);
			%>
			<div id="board">
				<table id = "list">
					<tr>
						<td>��ȣ</td>
						<td>����</td>
						<td>�ۼ���</td>
						<td>�ð�</td>
					</tr>
					<c:set var="i" value="1"/>
					<c:forEach var="item" items="${list}">
					<%--  <% for(int i = 0; i<list.size(); i++){ %> --%>
					<tr>
						<td>${i}</td>
						<td><a href="viewBoard.jsp?num=${item.num}">${item.title}</a></td>
						<td>${item.writer}</td>
						<td>${item.day}</td>
					</tr>
					<c:set var ="i" value="${i+1}"/>
					</c:forEach>
				</table>
				<a href="main.jsp"><button id="writer">Ȩ���ΰ���</button></a>
				<a href="writerBoard.jsp"><button id="writer">�ۼ��Ϸ�����</button></a>
			</div>


			<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
</body>
</html>