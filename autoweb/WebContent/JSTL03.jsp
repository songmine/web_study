<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="str" value="R"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <c:choose>
 	<c:when test="${str=='R'}">
 		Red 입니다.
 	</c:when>
 	<c:when test="${str=='B'}">
 		Blue 입니다.
 	</c:when>
	<c:otherwise>
		일치하는 문자열이 없습니다.
	</c:otherwise>
 </c:choose>
</body>
</html>