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
1. 문자열 출력 : ${str} <br/>
2. 문자열의 길이 : ${fn:length(str)} <br/>
3. 문자열 중에서 am만 출력 : ${fn:substring(str,3,5)} <br/>
4. 문자열 중에서 boy라는 문자열이 몇번째 위치에 있는가? : ${fn:indexOf(str, "boy")} <br/>
5. 문자열 중에서 a라는 문자를 X라는 문자로 변경하여 출력 : ${fn:replace(str, "a", "X")} <br/>
6. 문자열 앞뒤 공백을 제거하여 출력 : ${fn:trim(str)} <br/>
7. 문자열을 공백을 기준으로 분리하여 출력 : <br/>
<c:forEach var="s" items="${fn:split(str,' ')}">
	${s}<br/>
</c:forEach>
</body>
</html>