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
 	Red 입니다.
 </c:when>
 <c:when test="${param.color=='B'}">
 	Blue 입니다.
 </c:when>
 <c:otherwise>
 	일치하는 값이 없습니다.
 </c:otherwise>
</c:choose>
</body>
</html>