<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="kr.model.*" %>
<%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
-ȸ������ �����ϱ�(View)-
<form action='/autoweb/update' method='post'>
 <table border="1">
         <input type='hidden' name='num' value='<%=vo.getNum()%>'/>
         <tr>
         <td>��ȣ</td>
         <td><%=vo.getNum() %></td>
         </tr>
         <tr>
         <td>�̸�</td>
         <td><%=vo.getName()%></td>
         </tr>
         <tr>
         <td>��ȭ��ȣ</td>
         <td><input type='text' name='phone' value='<%=vo.getPhone()%>'/></td>
         </tr>
         <tr>
         <td>�ּ�</td>
         <td><input type='text' name='addr' value='<%=vo.getAddr()%>' size="50"/></td>
         </tr>
         <tr>
         <td>����</td>
         <td><%=vo.getLat()%></td>
         </tr>
         <tr>
         <td>�浵</td>
         <td><%=vo.getLng()%></td>
         </tr>
         
         <tr>
         <td align='center' colspan='2'>
         <input type='submit' value='�����ϱ�'/> 
         <input type='reset' value='���'/> 
         <a href='/autoweb/list'>[����Ʈ]</a></td>
         </tr>
 </table>
</form>
</body>
</html>