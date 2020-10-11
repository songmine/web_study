<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	if(session.getAttribute("id")==null){
		response.sendRedirect("login.html");
	};
%> --%>
<c:if test="${id==null}">
	<c:redirect url="login.html"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
- 여기는 계좌이체하는 페이지입니다. -
</body>
</html>