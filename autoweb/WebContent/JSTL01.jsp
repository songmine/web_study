<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- taglibrary������ --%>
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
  ¦���Դϴ�.
</c:if>
<c:if test="${sum%2!=0}">
  Ȧ���Դϴ�.
</c:if>
</body>
</html>