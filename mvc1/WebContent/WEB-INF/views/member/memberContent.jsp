<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
-ȸ������ �����ϱ�(View)-
<!-- ... .do?num=${vo.num}' ... �� ����  -->
<form action='${cpath}/update.do?num=${vo.num}' method='post'>
 <table border="1">
         <input type='hidden' name='num' value='${vo.num}'/>
         <tr>
         <td>��ȣ</td>
         <td>${vo.num}</td>
         </tr>
         <tr>
         <td>�̸�</td>
         <td>${vo.name}</td>
         </tr>
         <tr>
         <td>��ȭ��ȣ</td>
         <td><input type='text' name='phone' value='${vo.phone}'/></td>
         </tr>
         <tr>
         <td>�ּ�</td>
         <td><input type='text' name='addr' value='${vo.addr}' size="50"/></td>
         </tr>
         <tr>
         <td>����</td>
         <td>${vo.lat}</td>
         </tr>
         <tr>
         <td>�浵</td>
         <td>${vo.lng}</td>
         </tr>
         
         <tr>
         <td align='center' colspan='2'>
           <input type='submit' value='����'/>
           <input type='reset' value='���'/> 
         <a href='${cpath}/list.do'>[����Ʈ]</a></td>	
         			<!-- line46�� /mvc1�� context -->
         </tr>
 </table>
</form>
</body>
</html>