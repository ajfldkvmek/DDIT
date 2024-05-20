<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src='${pageContext.request.contextPath}/resources/calendar/dist/index.global.js'></script>

<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }
  
  #yrModal {
    position: fixed;
    width: 100%;
    height: 100%;
    background-color: rgba(50, 150, 150, 0.7);
    display: none;
    z-index: 1000;
   }

  #cont {
    margin: 50px auto;
    width: 50%;
    height: 70%;
    background-color: darkblue;
    color: yellow;
  }

</style>
</head>
<body>
	
	<div id="yrModal">
        <div id="cont" style="text-align: center;">
            <br>
            <h1>예린 모달 모달</h1>
		            시작일 <input type="text" id="schStart" value=""><br>
		            종료일 <input type="text" id="schEnd" value=""><br>
		            제목 <input type="text" id="schTitle" value=""><br>
		            하루종일 <input type="checkbox" id="allDay"><br>
		            배경색<input type="color" id="schBColor" value="">
		            글자색<input type="color" id="schFColor" value="">
            <button onclick="fCalAdd()">추강</button><br>
            <button onclick="fMClose()">X</button>
        </div>
    </div>
	
 	<div id='calendar'></div>
  	
  	<script>

// 	const YrModal = document.querySelector("#yrModal");
// 	const calendarEl = document.querySelector('#calendar');
// 	const mySchStart = document.querySelector("#schStart");
// 	const mySchEnd = document.querySelector("#schEnd");
// 	const mySchTitle = document.querySelector("#schTitle");
// 	const mySchAllday = document.querySelector("#allDay");
// 	const mySchBColor = document.querySelector("#schBColor");
// 	const mySchFColor = document.querySelector("#schFColor");
	//https://fullcalendar.io/docs
	// ① title : 해당 이벤트의 제목을 나타낸다.
	// ② color : 이벤트의 색상을 변경한다.
	// ③ textColor : 이벤트 내용의 텍스트의 색상을 변경한다.
	// ④ backgroundColor : 이벤트 배경색의 색상만을 변경한다.
	// ⑤ borderColor : 이벤트 테두리의 색상만을 변경한다.
	// ⑥ rendering : "bakground"라고 입력하면 color, backgroundColor의 색상으로 해당일 전체의 내용이 채워진다.
	//현재 날짜 계산 >> 이거 자바단에서 처리하자
	var today = new Date();
	var year = today.getFullYear();
	var month = ('0' + (today.getMonth() + 1)).slice(-2);
	var day = ('0' + today.getDate()).slice(-2);
	var dateString = year + '-' + month  + '-' + day;

    document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
    	
      local : 'kr',
//       timeZone: 'Asia/Korea',
      headerToolbar: {
//         left: 'prev,next today',
        center: 'title',
//         right: 'dayGridMonth,timeGridWeek,timeGridDay'
// 		right: 'dayGridMonth'
      },
      initialDate: dateString, //현재날짜 가져오기
      navLinks: true, // can click day/week names to navigate views
      selectable: true,

         
      select: function (arg) { // 캘린더에서 이벤트를 생성할 수 있다.
    	  
          var title = prompt('일정을 입력해주세요.');
          if (title) {
              calendar.addEvent({
                  title: title,
                  start: arg.start,
                  end: arg.end,
                  allDay: arg.allDay,
              })
          }

          var allEvent = calendar.getEvents(); // .getEvents() 함수로 모든 이벤트를 Array 형식으로 가져온다. (FullCalendar 기능 참조)

          var events = new Array(); // Json 데이터를 받기 위한 배열 선언
          for (var i = 0; i < allEvent.length; i++) {
              var obj = new Object();     // Json 을 담기 위해 Object 선언
              // alert(allEvent[i]._def.title); // 이벤트 명칭 알람
              obj.title = allEvent[i]._def.title; // 이벤트 명칭  ConsoleLog 로 확인 가능.
              obj.start = allEvent[i]._instance.range.start; // 시작
              obj.end = allEvent[i]._instance.range.end; // 끝

              events.push(obj);
          }
          var jsondata = JSON.stringify(events);
          console.log(jsondata);
          // saveData(jsondata);

          $(function saveData(jsondata) {
              $.ajax({
                  url: "/full-calendar/calendar-admin-update",
                  method: "POST",
                  dataType: "json",
                  data: JSON.stringify(events),
                  contentType: 'application/json',
              })
                  .done(function (result) {
                      // alert(result);
                  })
                  .fail(function (request, status, error) {
                       // alert("에러 발생" + error);
                  });
              calendar.unselect()
          });
      },
      
      
      eventClick: function(arg) {
    	  //클릭이벤트 여기 클릭시 채용정보창 띄우기
    	  alert("aasddsaasdasd");
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: [
        {
          title: '이거 시작',
          start: '2024-04-08T00:00', //시간 찍으면 dot로 나옴
          //end: '2024-04-09T00:00',
          color: '#CC77FF', 
        },

        {
          title: '이거 끝',
          start: '2024-04-18T00:00', //시간 찍으면 dot로 나옴
//           end: '2024-04-21T00:00',
          color: '#808080',
        },

      ]
    });

    calendar.render();
  });

  
</script>
</body>
</html>
