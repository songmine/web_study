<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*" %>
<%@page import="kr.model.*" %>
<%
	/* �θ� objectŸ���̶� �ٿ�ĳ���� �ʿ� */
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
-ȸ������Ʈ(View)-
 <table border='1'>
	<tr>
	<td>��ȣ</td>
	<td>�̸�</td>
	<td>��ȭ��ȣ</td>
	<td>�ּ�</td>
	<td>����</td>
	<td>�浵</td>
	<td>����</td>
	</tr>
	<% for(MemberVO vo : list) { %>
		<tr>
		<td><%=vo.getNum()%></td>
		<td><a href="/autoweb/content?num=<%=vo.getNum()%>"><%=vo.getName()%></a></td>
		<td><%=vo.getPhone()%></td>
		<td><%=vo.getAddr()%></td>
		<td><%=vo.getLat()%></td>
		<td><%=vo.getLng()%></td>
		<td><a href="/autoweb/delete?num=<%=vo.getNum()%>">����</a></td>
		</tr>	
	<% } %>
	  <tr>
      <td colspan='7' align='right'>
      <a href='member/member.html'>ȸ������</a>
      </td>
      </tr>
 </table>
</body>
</html>