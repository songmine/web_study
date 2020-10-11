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
-����� ��������-<br/>
����:<%=lat%><br/>
�浵:<%=lng%>
<!-- ������ ǥ���� div �Դϴ� -->
<div id="map" style="width:100%;height:350px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c6035e90dafd2624f7c5f1ee3c24580d"></script>
<script>
var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
    mapOption = { 
        center: new kakao.maps.LatLng(<%=lat%>, <%=lng%>), // ������ �߽���ǥ
        level: 3 // ������ Ȯ�� ���� (���������� detail�ϰ�)
    };

// ������ ǥ���� div��  ���� �ɼ�����  ������ �����մϴ�
var map = new kakao.maps.Map(mapContainer, mapOption);
//��Ŀ�� ǥ�õ� ��ġ�Դϴ� 
var markerPosition  = new kakao.maps.LatLng(<%=lat%>, <%=lng%>); 

// ��Ŀ�� �����մϴ�
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// ��Ŀ�� ���� ���� ǥ�õǵ��� �����մϴ�
marker.setMap(map);

// �Ʒ� �ڵ�� ���� ���� ��Ŀ�� �����ϴ� �ڵ��Դϴ�
// marker.setMap(null);    
</script>
</body>
</html>