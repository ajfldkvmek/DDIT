<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='en'>

<head>
<meta charset='utf-8' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>

<style>
#calendar { 
 	width: 100vw; 
	height: 80vh; 
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
	<!-- 모달은 메인 영역 밖으로 빼어 놓는게 좋음-->
	<div id="yrModal">
		<div id="cont" style="text-align: center;">
			<br>
			<h1>예린 모달 모달</h1>
			시작일 <input type="text" id="schStart" value=""><br> 종료일 <input
				type="text" id="schEnd" value=""><br> 제목 <input
				type="text" id="schTitle" value=""><br> 하루종일 <input
				type="checkbox" id="allDay"><br> 배경색<input type="color"
				id="schBColor" value=""> 글자색<input type="color"
				id="schFColor" value="">
			<button onclick="fCalAdd()">추강</button>
			<br>
			<button onclick="fMClose()">X</button>
		</div>
	</div>
	<!-- 실제 화면을 담을 영역 -->
	<div id="Wrapper">
		<div id='calendar'></div>
	</div>
	<script>
		
		//db에서 뽑아낸 데이터 json파일로 가져와서 달력에 넣는 방식
		var eventSources = [
    	{
            title: '삼성전자',
            start: '2024-04-08T00:00', //시간 찍으면 dot로 나옴
            //end: '2024-04-09T00:00',
            color: '#CC77FF', 
          },

          {
            title: '삼성전자',
            start: '2024-04-18T00:00', 
            color: '#808080',
          },    	{
              title: '엘지전자',
              start: '2024-04-08T00:00', 
              color: '#CC77FF', 
            },

            {
              title: '엘지전자',
              start: '2024-04-18T00:00',
              color: '#808080',
            },
  	 	]
	
        const YrModal = document.querySelector("#yrModal");
        const mySchStart = document.querySelector("#schStart"); 
        const mySchEnd = document.querySelector("#schEnd");
        const mySchTitle = document.querySelector("#schTitle");	
        const mySchAllday = document.querySelector("#allDay");	//allday옵션
        const mySchBColor = document.querySelector("#schBColor"); //배경컬러
        const mySchFColor = document.querySelector("#schFColor"); //폰트컬러


        //캘린더 헤더 옵션
        const headerToolbar = {
            left: 'prev,next',
            center: 'title',
            right: 'today'
        }

        
        const calendarEl = document.querySelector('#calendar'); //달력지정
       
        const calendarOption = {
        	eventLimit : 999,
            contentHeight: 'auto',
           // eventTimeFormat: 'HH:mm', << v6에서 안되네
           
            expandRows: true, // 화면에 맞게 높이 재설정
//             slotMinTime: '09:00', // Day 캘린더 시작 시간
//             slotMaxTime: '18:00', // Day 캘린더 종료 시간
            // 맨 위 헤더 지정
            headerToolbar: headerToolbar,
            initialView: 'dayGridMonth',  // default: dayGridMonth 'dayGridWeek', 'timeGridDay', 'listWeek'
            locale: 'kr',        // 언어 설정
            selectable: true,    // 영역 선택
            selectMirror: true,  // 오직 TimeGrid view에만 적용됨, default false
            navLinks: true,      // 날짜,WeekNumber 클릭 여부, default false
            //weekNumbers: true,   // WeekNumber 출력여부, default false
            editable: false,      // event(일정) 
            /* 시작일 및 기간 수정가능여부
            eventStartEditable: false,
            eventDurationEditable: true,
            */
           // contentHeight: 500,
            dayMaxEventRows: true,  // Row 높이보다 많으면 +숫자 more 링크 보임!
            /*
            views: {
                dayGridMonth: {
                    dayMaxEventRows: 3
                }
            },
            */
            nowIndicator: true,
            events: eventSources
           
        }

        // 캘린더 생성
        const calendar = new FullCalendar.Calendar(calendarEl, calendarOption);
        // 캘린더 그리깅
        calendar.render();

//         selectable
        // 캘린더 이벤트 등록
        calendar.on("eventAdd", info => alert("일정추가완료"));
//         calendar.on("eventChange", info => console.log("Change:", info));
//         calendar.on("eventRemove", info => console.log("Remove:", info));
        calendar.on("eventClick", info => {
//             console.log("eClick:", info);
//             console.log('Event: ', info.event.extendedProps);
//             console.log('Coordinates: ', info.jsEvent);
//             console.log('View: ', info.view);
            alert(url);
        });
        calendar.on("eventMouseEnter", info => console.log("eEnter:", info));
        calendar.on("eventMouseLeave", info => console.log("eLeave:", info));
        calendar.on("dateClick", info => console.log("dateClick:", info));
      
        calendar.on("select", info => {
            mySchStart.value = info.startStr;
            mySchEnd.value = info.endStr;

            YrModal.style.display = "block";
        });

		
        // 일정(이벤트) 추가하깅
        function fCalAdd() {
            if (!mySchTitle.value) {
                alert("제모게 머라도 써주삼")
                mySchTitle.focus();
                return;
            }
            let bColor = mySchBColor.value;
            let fColor = mySchFColor.value;
            if (fColor == bColor) {
                bColor = "black";
                fColor = "yellow";
            }

            let event = {
                start: mySchStart.value,
                end: mySchEnd.value,
                title: mySchTitle.value,
                allDay: mySchAllday.checked,
                backgroundColor: bColor,
                textColor: fColor
            };

            calendar.addEvent(event);
            fMClose();
        }

        // 모달 닫기
        function fMClose() {
            YrModal.style.display = "none";
        }
    </script>
</body>

</html>