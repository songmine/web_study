<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
- 회원리스트(MVC) -  <!-- JSTL과 EL사용 -->
<table border="1" width="500px">
 <tr>
	<td>번호</td>
	<td>이름</td>
	<td>전화번호</td>
	<td>주소</td>
	<td>위도</td>
	<td>경도</td>
 </tr>
 <c:forEach var="vo" items="${list}">
 	<tr>
 		<td>${vo.num}</td>
 		<td>${vo.name}</td>
 		<td>${vo.phone}</td>
 		<td>${vo.addr}</td>
 		<td>${vo.lat}</td>
 		<td>${vo.lng}</td>
 	</tr>
 </c:forEach>
</table>
</body>
</html>