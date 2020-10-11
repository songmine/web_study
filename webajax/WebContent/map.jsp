<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String lat = request.getParameter("lat"); 
	String lng = request.getParameter("lng"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
-사용자 지도보기-<br/>
위도:<%=lat%><br/>
경도:<%=lng%>
<!-- 지도를 표시할 div 입니다 -->
<div id="map" style="width:100%;height:350px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c6035e90dafd2624f7c5f1ee3c24580d"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(<%=lat%>, <%=lng%>), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨 (숫자작으면 detail하게)
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);
//마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(<%=lat%>, <%=lng%>); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>
</body>
</html>