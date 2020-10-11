<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*" %>
<%@page import="kr.model.*" %>
<%
	/* 부모가 object타입이라서 다운캐스팅 필요 */
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
-회원리스트(View)-
 <table border='1'>
	<tr>
	<td>번호</td>
	<td>이름</td>
	<td>전화번호</td>
	<td>주소</td>
	<td>위도</td>
	<td>경도</td>
	<td>삭제</td>
	</tr>
	<% for(MemberVO vo : list) { %>
		<tr>
		<td><%=vo.getNum()%></td>
		<td><a href="/autoweb/content?num=<%=vo.getNum()%>"><%=vo.getName()%></a></td>
		<td><%=vo.getPhone()%></td>
		<td><%=vo.getAddr()%></td>
		<td><%=vo.getLat()%></td>
		<td><%=vo.getLng()%></td>
		<td><a href="/autoweb/delete?num=<%=vo.getNum()%>">삭제</a></td>
		</tr>	
	<% } %>
	  <tr>
      <td colspan='7' align='right'>
      <a href='member/member.html'>회원가입</a>
      </td>
      </tr>
 </table>
</body>
</html>