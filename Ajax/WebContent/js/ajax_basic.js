'use strict';

$(function(){
	
	$('button').on('click', function(){
		
		//ajax(비동기통신) : 화면갱신없이 필요한 데이터만을 요청/응답하는 기술
		//ajax기본구조 ___ 아래.. 여러 속성들..
		//url: 요청할 서버의 주소
		//success: 서버에 요청을 성공했을 때 동작하는 메소드
		//data: 요청할 때 서버에 보낼 데이터
		//dataType: 응답받을 데이터의 포맷 설정(xml, plain(단순텍스트로 받겠다), json, html, ...)
		//error: 요청에 실패했을 때 동작하는 메소드
		//type: 데이터 전송방식 설정(GET/POST)
		$.ajax({
			url:'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101',
			success: function(){
				console.log('서버 요청 성공!');
			}
			
		});	//end ajax
	});	//end on()
});	//end function()