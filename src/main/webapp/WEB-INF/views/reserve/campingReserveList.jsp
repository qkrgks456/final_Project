<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Final</title>
    <%-- 부트 스트랩 메타태그 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%-- 부트 스트랩 아이콘 --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <!-- 부트스트랩 css 추가 -->
    <link href="${path}/resources/css/bootstrap.css" rel="stylesheet">
    <%-- 공통 css --%>
    <link href="${path}/resources/css/common.css?var=2" rel="stylesheet">
    <link href="${path}/resources/css/calendar.css" rel="stylesheet">
 <%--   $('a.fc-daygrid-day-number').css({"color":"black","text-decoration":"none"});
    $('a.fc-col-header-cell-cushion').css('color','black');--%>
    <style>
        a.fc-daygrid-day-number{
            color: black;
            text-decoration: none;
        }
        a.fc-col-header-cell-cushion{
            color: black;
            text-decoration: none;
        }
    </style>
</head>
<body>
<%-- 상단 로그인 추가 --%>
<c:if test="${sessionScope.loginId eq null}">
    <jsp:include page="../fix/navbar.jsp"/>
</c:if>
<c:if test="${sessionScope.loginId ne null}">
    <jsp:include page="../fix/loginNavbar.jsp"/>
</c:if>
<%-- 상단 메뉴바 --%>
<jsp:include page="../fix/menu.jsp"/>
<%-- 내용 넣으세요 --%>
<div class="container px-3">
    <div class="my-2" id='calendar'></div>
    <div class="my-2 text-center">
        <a class="btn btn-warning">예약하기</a>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>
<script src="${path}/resources/js/calendar.js"></script>
<script>
    let test = new Object();
    test.title = '예약 인원수 : 2';
    test.start = '2021-09-05';
    let eventArr = [
        {
            title: '예약 인원수 : 1',
            start: '2021-09-05',
            backgroundColor: "white",
            textColor : "#000000"
        },
        {
            title: 'event2',
            start: '2010-01-05',
            end: '2010-01-07'
        },
        {
            title: 'event3',
            start: '2010-01-09T12:30:00',
            allDay: false // will make the time show
        }
    ];
    eventArr.push(test);
    console.log(eventArr);
    document.addEventListener('DOMContentLoaded', function () {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            headerToolbar: {
                left: '',
                center: 'title',
                right: ''
            },
            editable: true,
            initialView: 'dayGridMonth',
            locale: "ko",
            events: eventArr
        });
        calendar.render();
    });

</script>
</body>
</html>
