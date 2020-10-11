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
-회원정보 수정하기(View)-
<form action='/autoweb/update' method='post'>
 <table border="1">
         <input type='hidden' name='num' value='<%=vo.getNum()%>'/>
         <tr>
         <td>번호</td>
         <td><%=vo.getNum() %></td>
         </tr>
         <tr>
         <td>이름</td>
         <td><%=vo.getName()%></td>
         </tr>
         <tr>
         <td>전화번호</td>
         <td><input type='text' name='phone' value='<%=vo.getPhone()%>'/></td>
         </tr>
         <tr>
         <td>주소</td>
         <td><input type='text' name='addr' value='<%=vo.getAddr()%>' size="50"/></td>
         </tr>
         <tr>
         <td>위도</td>
         <td><%=vo.getLat()%></td>
         </tr>
         <tr>
         <td>경도</td>
         <td><%=vo.getLng()%></td>
         </tr>
         
         <tr>
         <td align='center' colspan='2'>
         <input type='submit' value='수정하기'/> 
         <input type='reset' value='취소'/> 
         <a href='/autoweb/list'>[리스트]</a></td>
         </tr>
 </table>
</form>
</body>
</html>