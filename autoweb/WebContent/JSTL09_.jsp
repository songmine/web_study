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
- ȸ������Ʈ(MVC) -  <!-- JSTL�� EL��� -->
<table border="1" width="500px">
 <tr>
	<td>��ȣ</td>
	<td>�̸�</td>
	<td>��ȭ��ȣ</td>
	<td>�ּ�</td>
	<td>����</td>
	<td>�浵</td>
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