'use strict';

$(function(){
   
   $('button').on('click',function(){
      
      $.ajax({
         url:'memberList',
         dataType:'json', //전달될떄는 문자열, 받아올때는 객체로 받아와져서 쓰기 쉽다는 특징!
         success:function(memberList){
            	//console.log('회원목록>> ', memberList);
            let tag = '<table border="1">';
            tag += '<tr><th>이름</th><th>나이</th><th>번호</th><th>주소</th></tr>'
               
            memberList.forEach(function(member){
               
               tag += '<tr>';
               tag += `<td>${member.name}</td>`;
               tag += `<td>${member.age}</td>`;
               tag += `<td>${member.tel}</td>`;
               tag += `<td>${member.address}</td>`;
               tag += '</tr>';
               
            });
            
            tag+='</table>';
            
            $('#memberTable').html(tag);
               
         }      
         
      }); //end ajax()
   }); //end on()
}); //end function()