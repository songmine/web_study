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
- ����� ������ü�ϴ� �������Դϴ�. -
</body>
</html>