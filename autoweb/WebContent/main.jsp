<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	/* HttpSession ses = request.getSession();
	ses.getAttribute("id"); //������ ��� �ؾ������� jsp�ǰ�� ����Ǿ������Ƿ� ���ʿ����
	session�����ؾ� session�� ã�ư�!!*/
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
-�α��� �Ŀ� ���񽺵Ǵ� ù �������Դϴ�. -<br/>
${id}�� �湮�� ȯ���մϴ�. <br/>
<input type="button" value="�α׾ƿ�" onclick="logout()"/>
</body>
</html>