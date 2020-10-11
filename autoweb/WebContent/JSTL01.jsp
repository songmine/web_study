<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- taglibrary지시자 --%>
<c:set var="sum" value="9"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${sum}<br/>
<c:if test="${sum%2==0}">
  짝수입니다.
</c:if>
<c:if test="${sum%2!=0}">
  홀수입니다.
</c:if>
</body>
</html>