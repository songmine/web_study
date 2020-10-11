<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	/* HttpSession ses = request.getSession();
	ses.getAttribute("id"); //서블릿의 경우 해야하지만 jsp의경우 내장되어있으므로 할필요없음
	session으로해야 session을 찾아감!!*/
 	if(session.getAttribute("id")==null){
		response.sendRedirect("login.html");
	}
	
	String id = (String)session.getAttribute("id"); 
%> --%>
<c:if test="${id==null}">
	<c:redirect url="login.html"></c:redirect>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function logout(){
		location.href="/autoweb/logout";
	}
</script>
</head>
<body>
-로그인 후에 서비스되는 첫 페이지입니다. -<br/>
${id}님 방문을 환영합니다. <br/>
<input type="button" value="로그아웃" onclick="logout()"/>
</body>
</html>