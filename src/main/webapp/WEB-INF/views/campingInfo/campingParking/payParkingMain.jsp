<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta charset="utf-8">
    <title>Final</title>
    <%-- 부트 스트랩 메타태그 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%-- 부트 스트랩 아이콘 --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <!-- 부트스트랩 css 추가 -->
    <%--<link href="${path}/resources/css/bootstrap.css" rel="stylesheet">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <%-- 공통 css --%>
    <link href="${path}/resources/css/common.css?var=2" rel="stylesheet">
</head>
<body>
<%-- 상단 로그인 추가 --%>
<c:if test="${sessionScope.loginId eq null}">
    <jsp:include page="../../fix/navbar.jsp"/>
</c:if>
<c:if test="${sessionScope.loginId ne null}">
    <jsp:include page="../../fix/loginNavbar.jsp"/>
</c:if>
<%-- 상단 메뉴바 --%>
<jsp:include page="../../fix/menu.jsp"/>
<%-- 내용 넣으세요 --%>
<div class="container px-3">

<div class="row">

<div>
 차박지도 (유료 자동차 야영장을 보여줍니다!)
</div>

<div>
 <button onclick="location.href='./campingParking'" class="btn btn-warning btn-sm">무료</button>
 <button onclick="location.href='./payPark'" class="btn btn-warning btn-sm">유료</button>
</div>

</div>


<div class="d-flex justify-content-center">

<div class="list col-2" style="border:1px solid;">
</div>  


<div id="map" style="width:100%;height:600px;"></div>    

</div>
    

    
    
    
    
</div>


<!-- 
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=379ea69d5a147ed25817ca69e93842c3&​&libraries=services"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
		        level: 6, // 지도의 확대 레벨
		        mapTypeId : kakao.maps.MapTypeId.HYBRID // 지도종류
		    }; 

		// 지도를 생성한다 
		var map = new kakao.maps.Map(mapContainer, mapOption); 

		// 지도 타입 변경 컨트롤을 생성한다
		var mapTypeControl = new kakao.maps.MapTypeControl();

		// 지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
		map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);	

		// 지도에 확대 축소 컨트롤을 생성한다
		var zoomControl = new kakao.maps.ZoomControl();

		// 지도의 우측에 확대 축소 컨트롤을 추가한다
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
		
		
		// 지도위에 생성된 마커들을 담는 배열임!
		var markers = [];
		
		// 지도 중심 좌표 변화 이벤트를 등록한다
		kakao.maps.event.addListener(map, 'dragend', function (){
			
			// 지도위에 표시된 마커들 제거
			// 지도위에 생성된 마커들을 담는 배열임 => 하나하자 지움!
			for (var e = 0; e < markers.length; e++) {
				markers[e].setMap(null);
			}
			$(".list").empty();
			
			
			console.log('지도의 중심 좌표는 ' + map.getCenter().toString() +' 입니다.');
			var aaa = map.getCenter().toString()
			
			var bbb = aaa.replace(/\(|\)| /g,'');
			console.log(bbb);
			
			var ccc = bbb.split(",");
			console.log(ccc[0]);//위도 
			console.log(ccc[1]);//경도
			
			var wido = ccc[0];
			var kyongdo = ccc[1];
			
			$.ajax({
				type:"POST",
				url:"./payZapyo",
				data:{
					"wido":wido,
					"kyongdo":kyongdo
				},
				success:function(data){ //dto 배열 받아옴
					console.log("예??",data);
				
					// 지도에 마커를 생성하고 표시한다	
					for (var i = 0; i < data.length; i++) {
						
						//마커생성 여러번!
						var marker = new kakao.maps.Marker({
						    position: new kakao.maps.LatLng(data[i].mapX, data[i].mapY), // 마커의 좌표
						    map: map, // 마커를 표시할 지도 객체
						});
						
						marker.setMap(map);
						
						// 생성된 마커들을 배열에 담음(지도 이동할때마다, 이전에 표시된 마커 지우려고 담는거임)
						markers.push(marker);
						listPrint(data[i]); //리스트 그리기
						
						// 인포윈도우를 생성합니다
						var infowindow = new kakao.maps.InfoWindow({
						    content : data[i].facltnm
						});
						
						//마우스 이벤트 등록
						kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
					    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
					    kakao.maps.event.addListener(marker, 'click', makeClickListener(data[i].facltnm));
						
					}	
				},
				error: function(data){
					console.log(data);
				}
			});			
		});
		
		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
		    return function() {
		        infowindow.open(map, marker);
		    };
		}
		
		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
		    return function() {
		        infowindow.close();
		    };
		}
		
		function makeClickListener(prkplcenm) {
		    return function() {
		      alert(prkplcenm);
		      location.href="./freeParkDetail/"+prkplcenm;    
			};
		}
		
		function listPrint(data){
			var content = "";
			
			content +=  '<div class="card mb-1" style="max-width: 600px;">'
            content +=   '<div class="ms-2 col-md">'
            content +=    '<h6 class="card-title"><a href="./freeParkDetail/'+data.facltnm+'">'+data.facltnm+'</a></h6>';
            content +=    '<p class="card-text"><small>'+"주소: "+data.addr1+'</small></p>';
            content +=    '<p class="card-text"><small class="text-muted">'+"전화번호: "+data.tel+'</small></p></div></div>';
			$(".list").append(content);
			
		}

</script>



 -->
 
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>

<script>























/*  
$.ajax({
    url:'apiCall',
    type:'POST',
    data:{},
    dataType:'JSON',
    success:function(data){
        console.log(data);
        console.log(typeof data);

    },
    error:function(data){
        console.log(data);
    }
});
*/
</script>

</body>
</html>

