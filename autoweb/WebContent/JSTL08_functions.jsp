<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="str" value=" I am a boy "/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
1. ���ڿ� ��� : ${str} <br/>
2. ���ڿ��� ���� : ${fn:length(str)} <br/>
3. ���ڿ� �߿��� am�� ��� : ${fn:substring(str,3,5)} <br/>
4. ���ڿ� �߿��� boy��� ���ڿ��� ���° ��ġ�� �ִ°�? : ${fn:indexOf(str, "boy")} <br/>
5. ���ڿ� �߿��� a��� ���ڸ� X��� ���ڷ� �����Ͽ� ��� : ${fn:replace(str, "a", "X")} <br/>
6. ���ڿ� �յ� ������ �����Ͽ� ��� : ${fn:trim(str)} <br/>
7. ���ڿ��� ������ �������� �и��Ͽ� ��� : <br/>
<c:forEach var="s" items="${fn:split(str,' ')}">
	${s}<br/>
</c:forEach>
</body>
</html>