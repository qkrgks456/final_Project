<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Final</title>
<%-- 부트 스트랩 메타태그 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- 부트 스트랩 아이콘 --%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<!-- 부트스트랩 css 추가 -->
<%--<link href="${path}/resources/css/bootstrap.css" rel="stylesheet">--%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<%-- 공통 css --%>
<link href="${path}/resources/css/common.css?var=2" rel="stylesheet">
</head>
<body>
	<%-- 상단 로그인 추가 --%>
	<c:if test="${sessionScope.loginId eq null}">
		<jsp:include page="../../fix/navbar.jsp" />
	</c:if>
	<c:if test="${sessionScope.loginId ne null}">
		<jsp:include page="../../fix/loginNavbar.jsp" />
	</c:if>
	<%-- 상단 메뉴바 --%>
	<jsp:include page="../../fix/menu.jsp" />
	<%-- 내용 넣으세요 --%>
	<div class="row mt-1">
		<div class="col-4 border-end border-danger">
			<div id="menu_wrap" class="bg_white">
				<div class="option">

					<form onsubmit="searchPlaces(); return false;" class="text-center"
						id="searchList">
						<div class="d-flex justify-content-center mt-2">
							<select class="form-select form-select-sm col"
								aria-label=".form-select-sm example" required="required" id="type">
								<option value="addr" selected >주소</option>
								<option value="them" >테그</option>
							</select> <input class="form-control w-50 me-2" type="text" id="keyword">
							<button class="btn btn-warning btn-sm" type="submit">검색하기</button>
						</div>
					</form>
				</div>
				<hr>
				<div class="list" style="overflow-y: scroll; height: 700px;">
					<div>
						<ul id="placesList" class="list-group list-group">
							<!-- 리스트 -->
						</ul>
						<div id="pagination"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-8 ms-0">
			<div id="map"
				style="width: 100%; height: 780px; position: relative; overflow: hidden;"></div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=de13013a67053c1d19922fa8b31042a9"></script>
	<script>
		// 마커를 담을 배열입니다
		var markers = [];

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 10, // 지도의 확대 레벨
			mapTypeId : kakao.maps.MapTypeId.HYBRID
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);
		// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
		//var infowindow = new kakao.maps.InfoWindow({zIndex:1});
		var currPage = 1;
		var type = document.getElementById("type").options[document.getElementById("type").selectedIndex].value;
		var word = "";
		function searchPlaces() {
			type = document.getElementById("type").options[document.getElementById("type").selectedIndex].value;
			word = document.getElementById('keyword').value;
			console.log(type);
			
			 if (!word.replace(/^\s+|\s+$/g)) {
				alert('키워드를 입력해주세요!');
				return false;
			} 
			listCall(currPage, word,type);
		}
		listCall(currPage, word,type);
		function listCall(page, word, type) {
			//{pagePerNum}/{page}
			var reqUrl = 'mapSearchList/' + page;
			//console.log('request page' + reqUrl);
			$.ajax({
				url : reqUrl,
				type : 'post',
				data : {
					"word" : word, "type": type
				},
				dataType : 'json',
				success : function(data) { //데이터가 성공적으로 들어왔다면
					var check = true;
					//console.log(data);
					listPrint(data.list); //리스트 그리기
					PagePrint(data);

					/* for (var i = 0; i < data.list.length; i ++) {
						markers.push({content : data.list[i].facltNm, latlng: new kakao.maps.LatLng(data.list[i].mapY,data.list[i].mapX)});
						
					    // 마커를 생성합니다
					    var marker = new kakao.maps.Marker({
					        map: map, // 마커를 표시할 지도
					        position: markers[i].latlng // 마커의 위치
					    });		    
					  // console.log(infowindow.open(map, marker));
					    // 마커에 표시할 인포윈도우를 생성합니다 
					    var infowindow = new kakao.maps.InfoWindow({
					        content: markers[i].content // 인포윈도우에 표시할 내용
					        , removable : true
					        
					    });
					kakao.maps.event.addListener(marker,'click',addClickListener(map,marker,infowindow))
					}
						function addClickListener(map,marker,infowindow){
							  return function() {
							        infowindow.open(map, marker);
							    };
						} */
				},
				error : function(error) {
					console.log(error);
				}
			});
		}

		function listPrint(list) {
			var content = "";
			for (var i = 0; i < list.length; i++) {
				content += '<div class="card mb-1" style="max-width: 500px;"><div class="row g-0"><div class="col-md-4">'
				content += '<img src="'+list[i].firstImageUrl+'" class="img-fluid w-100 h-100 rounded-start me-1" alt="'+list[i].facltNm+'">'
				content += '</div><div class="ms-2 col-md-7">'
				content += '<h5 class="card-title">' + list[i].facltNm
						+ '</h5>'
				content += '<p class="card-text">' + list[i].addr1 + '</p>'
				content += '<p class="card-text"><small class="text-muted">'
						+ list[i].tel + '</small></p></div></div></div>'
				$("#placesList").empty();
				$("#placesList").append(content);
			}
		}

		function PagePrint(map) {
			console.log(map);
			content = '';
			content += '<ul class="pagination justify-content-center">'
			if (map.startPage != 1) {
				content += '<li class="page-item">'
				content += '<a class="page-link page-info" page="'
						+ (map.startPage - 1)
						+ '" aria-label="Previous" style="cursor:pointer;">'
				content += '<span aria-hidden="true">&laquo;</span>'
				content += '</a>'
				content += '</li>'
			}
			for (let i = map.startPage; i <= map.endPage; i++) {
				if (map.currPage != i) {
					content += '<li class="page-item"><a style="cursor:pointer;" class="page-link page-info" page="' + i + '" >'
							+ i + '</a></li>'
				} else {
					content += '<li class="page-item active"><a class="page-link">'
							+ i + '</a></li>'
				}
			}
			if (map.totalPage != map.endPage) {
				content += '<li class="page-item">'
				content += '<a class="page-link page-info" page="'
						+ (map.endPage + 1)
						+ '" aria-label="Next" style="cursor:pointer;">'
				content += '<span aria-hidden="true">&raquo;</span>'
				content += '</a>'
				content += '</li>'
			}
			content += '</ul>'
			$('#pagination').empty();
			$('#pagination').append(content);
		}

		function removeMarker() {
			for (var i = 0; i < markers.length; i++) {
				console.log(markers);
				markers[i].setMap(null);
			}
			markers = [];
		}

		$(document).on('click', '.page-info', function() {
			page = $(this).attr('page');
			$.ajax({
				type : "post",
				url : 'mapSearchList/' + page,
				data : {
					"word" : word
					,"type" : type
				},
				dataType : 'JSON',
				success : function(data) { //성공시
					console.log(data);
					listPrint(data.list); //리스트 그리기
					PagePrint(data);
				},
				error : function(e) { //실패시
					console.log(e);
				}
			});
		})

		/* 	kakao.maps.event.addListener(map, 'dragend', function (){
		
		 // 지도위에 표시된 마커들 제거
		 // 지도위에 생성된 마커들을 담는 배열임 => 하나하자 지움!
		 removeMarker();
		
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
		 url:"./zapyo",
		 data:{
		 "wido":wido,
		 "kyongdo":kyongdo
		 },
		 success:function(data){ //dto 배열 받아옴
		 console.log(data);
		
		 // 지도에 마커를 생성하고 표시한다	
		 for (var i = 0; i < data.length; i++) {
		 //마커생성 여러번!
		 var marker = new kakao.maps.Marker({
		 position: new kakao.maps.LatLng(data[i].mapY,data[i].mapX), // 마커의 좌표
		 map: map, // 마커를 표시할 지도 객체
		 });
		
		 marker.setMap(map);
		
		 // 생성된 마커들을 배열에 담음(지도 이동할때마다, 이전에 표시된 마커 지우려고 담는거임)
		 markers.push(marker);
		 listPrint(data); 
		 //리스트 그리기
		
		 // 인포윈도우를 생성합니다
		 var infowindow = new kakao.maps.InfoWindow({
		 content : data[i].facltNm
		 });
		
		 //마우스 이벤트 등록
		 /* kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		 kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
		 kakao.maps.event.addListener(marker, 'click', makeClickListener(data[i].prkplcenm)); */

		/* 	}
			
		},
		error: function(data){
			console.log(data);
			//dragPrint();
		}
		});			
		});
		 */
	</script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${path}/resources/js/bootstrap.js"></script>
	<script src="${path}/resources/js/bootstrap.bundle.js"></script>
	<script src="${path}/resources/js/common.js"></script>
</body>
</html>