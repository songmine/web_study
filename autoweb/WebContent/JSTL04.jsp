<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
 <c:when test="${param.color=='R'}">
 	Red �Դϴ�.
 </c:when>
 <c:when test="${param.color=='B'}">
 	Blue �Դϴ�.
 </c:when>
 <c:otherwise>
 	��ġ�ϴ� ���� �����ϴ�.
 </c:otherwise>
</c:choose>
</body>
</html>