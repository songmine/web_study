'use strict';

$(function(){
	
	$('button').on('click', function(){
		
		let obj = {
			num: 123,
			alpha: 'Hello',
			hangul:'안녕'
		};
		
		// /Ajax?num=123&alpha=Hello&hangul=16진수형태 <<로 전달됨(한글은 16진수형태로 변형되어 전달)
		$.ajax({
			url :'Ajax',
			data: obj,		//'num=123',
			success: function(){
				console.log('서버요청성공!');
			}
			
		});	//end ajax
	});	//end on()
});	//end function()