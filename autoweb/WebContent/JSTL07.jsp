<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kr.model.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	list.add(new MemberVO("���浿", "010-1111", "����"));
	list.add(new MemberVO("��浿", "010-1111", "����"));
	list.add(new MemberVO("�̱浿", "010-1111", "����"));
	request.setAttribute("list", list);  				//��ü���ε�(�� request���ε�)
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
  	<td>�̸�</td>
   	<td>��ȭ��ȣ</td>
   	<td>�ּ�</td>
  </tr>
  <c:forEach var="vo" items="${list}">	
  <!-- ArrayList���� ����ִ� ${list} -->
   <tr>
	<td>${vo.name}</td>
	<td>${vo.phone}</td>
	<td>${vo.addr}</td>
   </tr>
  </c:forEach>
 </table>
</body>
</html>