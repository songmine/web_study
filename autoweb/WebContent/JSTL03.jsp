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
 		Red �Դϴ�.
 	</c:when>
 	<c:when test="${str=='B'}">
 		Blue �Դϴ�.
 	</c:when>
	<c:otherwise>
		��ġ�ϴ� ���ڿ��� �����ϴ�.
	</c:otherwise>
 </c:choose>
</body>
</html>