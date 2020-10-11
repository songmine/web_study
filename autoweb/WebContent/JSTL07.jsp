<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kr.model.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	list.add(new MemberVO("나길동", "010-1111", "광주"));
	list.add(new MemberVO("김길동", "010-1111", "광주"));
	list.add(new MemberVO("이길동", "010-1111", "광주"));
	request.setAttribute("list", list);  				//객체바인딩(중 request바인딩)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <table border="1" width="300px">
  <tr align="center" bgcolor="orange">
  	<td>이름</td>
   	<td>전화번호</td>
   	<td>주소</td>
  </tr>
  <c:forEach var="vo" items="${list}">	
  <!-- ArrayList값이 들어있는 ${list} -->
   <tr>
	<td>${vo.name}</td>
	<td>${vo.phone}</td>
	<td>${vo.addr}</td>
   </tr>
  </c:forEach>
 </table>
</body>
</html>