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
      <div class="row">
         <div class="col-4 border-end border-danger">
            <div id="menu_wrap" class="bg_white">
               <div class="option">
                  <div>
                     <form onsubmit="searchPlaces(); return false;" class="text-center">
                     <div class="d-flex justify-content-center mt-2">
                        <input class="form-control w-50 me-2" type="text" id="keyword">
                        <button class="btn btn-warning btn-sm" type="submit">검색하기</button>
                        </div>
                     </form>
                  </div>
               </div>
               <hr>
               <ul id="placesList" class="list-group list-group">
      
               </ul>
               <div id="pagination"></div>
            </div>
         </div>
         <div class="col-8">
            <div id="map"style="width: 100%; height: 800px; position: relative; overflow: hidden;"></div>
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
           center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
           level: 13, // 지도의 확대 레벨
           mapTypeId : kakao.maps.MapTypeId.HYBRID
       };  

   // 지도를 생성합니다    
   var map = new kakao.maps.Map(mapContainer, mapOption); 
// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
   //var infowindow = new kakao.maps.InfoWindow({zIndex:1});

	var currPage = 1;
	var per = 10;
	listCall(currPage);

	function listCall(page) {
		//{pagePerNum}/{page}
		var reqUrl = 'mapSearchList/' + per + "/" + page;
		//console.log('request page' + reqUrl);
		 $.ajax({
			url : reqUrl,
			type : 'get',
			dataType : 'json',
			success : function(data) { //데이터가 성공적으로 들어왔다면
				//console.log(data);
				listPrint(data.list); //리스트 그리기
				currPage = data.currPage;
				//페이징 처리
			/* 	$("#pagination").twbsPagination({
					startPage:data.currPage,//시작페이지 -> service에서 sql실행하여 map으로 보낸 데이타 값
					totalPages:data.pages,//총 페이지 갯수 -> service에서 sql실행하여 map으로 보낸 데이타 값
					visiblePages:5,//보여줄 페이지 갯수
					onPageClick: function(e,page){
						console.log(e,page);
						listCall(page);
					}
					}); */

				for (var i = 0; i < data.list.length; i ++) {
					
					markers.push({content : data.list[i].facltNm, latlng: new kakao.maps.LatLng(data.list[i].mapY,data.list[i].mapX)});
				    // 마커를 생성합니다
				    var marker = new kakao.maps.Marker({
				        map: map, // 마커를 표시할 지도
				        position: markers[i].latlng // 마커의 위치
				    });

				    marker.setMap(map);
				    
				  // console.log(infowindow.open(map, marker));
				    // 마커에 표시할 인포윈도우를 생성합니다 
				    var infowindow = new kakao.maps.InfoWindow({
				        content: markers[i].content // 인포윈도우에 표시할 내용
				        , removable : true
				        
				    });
				kakao.maps.event.addListener(marker, 'click', function() {
			
				    infowindow.open(map, marker);
				    alert('marker click!');
				});
				}
					
			},
			error : function(error) {
				console.log(error);
			}
		});
	}
	
	function listPrint(list){
		var content = "";
		
		
		
		
		for(var i = 0; i<list.length; i++){
			
			/* content += "<li class='list-group-item d-flex justify-content-between align-items-start'><div class='ms-2 me-auto row'><div class='col-3'>"
			content += "<img src='"+list[i].firstImageUrl+"'  style='width: 300px; height: 200px;'></div>"
			content += "<div class='col-9'><h5>"+list[i].facltNm+"</h5>"
			content += "<p >"+list[i].addr1+"</p>"
			content += "<p >"+list[i].tel+"</p></div></div> </li>" */
			content +=  '<div class="card mb-1" style="max-width: 500px;"><div class="row g-0"><div class="col-md-4">'
                content +=     '<img src="'+list[i].firstImageUrl+'" class="img-fluid w-100 h-100 rounded-start me-1" alt="'+list[i].facltNm+'">'
                content +=   '</div><div class="ms-2 col-md-7">'
                    content +=    '<h5 class="card-title">'+list[i].facltNm+'</h5>'
                    content +=    '<p class="card-text">'+list[i].addr1+'</p>'
                    content +=    '<p class="card-text"><small class="text-muted">'+list[i].tel+'</small></p></div></div></div>'
			$("#placesList").empty();
			$("#placesList").append(content);
		}
	}
	
   </script>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   <script src="${path}/resources/js/bootstrap.js"></script>
   <script src="${path}/resources/js/bootstrap.bundle.js"></script>
   <script src="${path}/resources/js/common.js"></script>
</body>
</html>