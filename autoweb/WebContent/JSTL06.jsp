<%@page import="kr.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	// Servlet --> JSP 
	MemberVO vo = new MemberVO();
	vo.setName("ȫ�浿");
	vo.setPhone("010-1111-1111");
	vo.setAddr("����");
	request.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 ${vo.name},${vo.phone},${vo.addr}
</body>
</html>