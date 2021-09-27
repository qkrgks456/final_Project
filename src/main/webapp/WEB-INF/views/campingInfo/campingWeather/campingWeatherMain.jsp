<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>

<title>Final</title>
<style>
.weather-number {
	color: red;
}
</style>
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
<link href="${path}/resources/css/campingWeather.css?var=9"
	rel="stylesheet">
</head>
<body style="background-color: aliceblue;">
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
	<div class="container px-3 py-3"  >
		<div class="border-bottom mb-3">
            <h2 class="">날씨</h2>
        </div> 
	
		<div class="row">
			<%-- <div style="position: absolute; z-index: -1;">
				<img src="${path}/resources/img/koreaMap.png">
			</div> --%>
			<div class="col-8">
				<div class="row row-cols-1 row-cols-md-6 g-1 text-center" id="list">
			</div>
			</div>
			<div class="col-4">
			<!-- 첫번째 날씨 위젯-->
			<div class="lb-widget" style="margin-top : 150px;">
				<div class="lb-main">
					<select class="beom" id="select-box">
						<option value="1">Seoul, 서울</option>
						<option value="2">Incheon, 인천</option>
						<option value="3">Daejeon, 대전</option>
						<option value="4">Gwangju, 광주</option>
						<option value="5">Daegu, 대구</option>
						<option value="6">Ulsan, 울산</option>
						<option value="7">Busan, 부산</option>
						<option value="8">Jeju, 제주</option>
					</select>
				</div>
				<div id="lb-1" class="lb-weather">
					<iframe
						src="https://forecast.io/embed/#lat=37.5266&lon=127.0403&name=Seoul, 서울&color=&font=&units=si"></iframe>
				</div>
				<div id="lb-2" class="lb-weather">
					<iframe
						src="https://forecast.io/embed/#lat=37.4496&lon=126.7074&name=Incheon, 인천&color=#F6A8A6&font=&units=si"></iframe>
				</div>
				<div id="lb-3" class="lb-weather">
					<iframe
						src="https://forecast.io/embed/#lat=36.3512&lon=127.3954&name=Daejeon, 대전&color=#5BC065&font=&units=si"></iframe>
				</div>
				<div id="lb-4" class="lb-weather">
					<iframe
						src="https://forecast.io/embed/#lat=35.1787&lon=126.8974&name=Gwangju, 광주(전남)&color=#A5C8E4&font=&units=si"></iframe>
				</div>
				<div id="lb-5" class="lb-weather">
					<iframe
						src="https://forecast.io/embed/#lat=35.8759&lon=128.5964&name=Daegu, 대구&color=#C0ECCC&font=&units=si"></iframe>
				</div>
				<div id="lb-6" class="lb-weather">
					<iframe
						src="https://forecast.io/embed/#lat=35.538&lon=129.324&name=울산&color=#F9F0C1&font=&units=si"></iframe>
				</div>
				<div id="lb-7" class="lb-weather">
					<iframe
						src="https://forecast.io/embed/#lat=35.1334&lon=129.1058&name=부산&color=#BA55D3&font=&units=si"></iframe>
				</div>
				<div id="lb-8" class="lb-weather">
					<iframe
						src="https://forecast.io/embed/#lat=33.5007&lon=126.5288&name=제주&color=#ffc261&font=&units=si"></iframe>
				</div>
			</div>
			</div>
		
</div>
		<%-- 
<div class="modal-pop iconguide-wrap" data-pop="open-iconguide-pop">
	<button class="pop-close" title="날씨기호 설명 닫기"></button>
	<h2>날씨기호 설명</h2>
	<div class="layer-pop-wrap">
		<div class="over-scroll">
			<table class="table-col">
				<caption class="hide-caption">아이콘, 설명으로 날씨 아이콘을 설명하는 표입니다.</caption>
				<colgroup>
					<col width="15%" />
					<col width="35%" />
					<col width="15%" />
					<col width="35%" />
				</colgroup>
				<thead>
				<tr>
					<th scope="col">날씨기호</th>
					<th scope="col">설명</th>
					<th scope="col">날씨기호</th>
					<th scope="col">설명</th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB01.png" alt="맑음" /></td>
					<td>맑음</td>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB01_N.png" alt="맑음 (밤)" /></td>
					<td>맑음 (밤)</td>
				</tr>
				<tr>
				  <td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB02.png" alt="구름조금 (낮)" /></td>
				  <td>구름조금 (낮)</td>
				  <td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB02_N.png" alt="구름조금 (밤)" /></td>
				  <td>구름조금 (밤)</td>
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB03.png" alt="구름많음 (낮)" /></td>
					<td>구름많음 (낮)</td>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB03_N.png" alt="구름많음 (밤)" /></td>
					<td>구름많음 (밤)</td>
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB04.png" alt="흐림" /></td>
					<td>흐림</td>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB07.png" alt="소나기" /></td>
					<td>소나기</td>
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB08.png" alt="비" /></td>
					<td>비</td>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB20.png" alt="가끔 비, 한때 비" /></td>
					<td>가끔 비, 한때 비</td>
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB11.png" alt="눈" /></td>
					<td>눈</td>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB21.png" alt="가끔 눈, 한때 눈" /></td>
					<td>가끔 눈, 한때 눈</td>
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB12.png" alt="비 또는 눈" /></td>
					<td>비 또는 눈</td>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB22.png" alt="가끔 비 또는 눈, 한때 비 또는 눈 " /></td>
					<td>가끔 비 또는 눈, <br />한때 비 또는 눈</td>
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB13.png" alt="눈 또는 비" /></td>
					<td>눈 또는 비</td>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB23.png" alt="가끔 눈또는 비, 한때 눈 또는 비" /></td>
					<td>가끔 눈 또는 비,<br />한때 눈 또는 비</td>
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/DY@64/Light/DB_LGT.png" alt="낙뢰" /></td>
					<td>낙뢰</td>
					<td><img class="ic_img" src="/w/resources/icon/DY@64/Light/DB10.png" alt="빗방울" /></td>
					<td>빗방울</td>					
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB18.png" alt="연무" /></td>
					<td>연무</td>
					<td><img class="ic_img" src="/w/resources/icon/DY@64/Light/DB12.png" alt="눈날림" /></td>
					<td>눈날림</td>						
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB15.png" alt="안개" /></td>
					<td>안개</td>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB17.png" alt="박무 (엷은 안개)" /></td>
					<td>박무 (엷은 안개)</td>				
				</tr>
				<tr>
					<td><img class="ic_img" src="/w/resources/icon/NY@64/Light/NB16.png" alt="황사" /></td>
					<td>황사</td>
					<td colspan="2" class="info"><a href="/w/resources/image/kma_icon.png" id="open_icon_info"><img src="/w/resources/image/btn_icon_info.gif" alt="강수 아이콘 구분 안내"/></a></td>
				</tr>
				<tr>
					<td colspan="2" class="buoy_wind"><img src="/w/resources/icon/legacy/NW/NB24.png" alt="부이" width="103" height="100"/><strong>부이</strong></td>
					<td colspan="2">
						<a rel="license" target="_blank" href="http://www.kogl.or.kr/open/koglLicenseInfoView.do?license_type=4&amp;egov_code=372&amp;license_idx=13251"><img alt="공공누리" src="https://www.kogl.or.kr/open/web/images/content/symbol04.gif" /></a>
						<div>
							<span xmlns:dct="http://purl.org/dc/terms/"
								href="http://purl.org/dc/dcmitype/StillImage"
								property="dct:title" rel="dct:type">날씨 아이콘</span> 저작물은 "공공누리"
							<a rel="license"
								href="http://www.kogl.or.kr/open/koglLicenseInfoView.do?license_type=4&amp;egov_code=372&amp;license_idx=13251"
								target="_blank"> 출처표시-상업적이용금지-변경금지 </a> 조건에 따라 이용 할 수 있습니다.
						</div>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div> 
--%>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${path}/resources/js/bootstrap.js"></script>
	<script src="${path}/resources/js/bootstrap.bundle.js"></script>
	<script src="${path}/resources/js/common.js"></script>
	<script src="${path}/resources/js/campingWeather.js?var=5"></script>
	<script>
// var apiURI = "http://maps.openweathermap.org/maps/2.0/weather/TA2/10/36.57601009561782/127.9369886453819?appid=55d3503973ed8cc55f407d450e0c3899";
var apiURI = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=55d3503973ed8cc55f407d450e0c3899";
$(document).ready(function(){
		var array = ['seoul', 'busan', 'jeju', 'chuncheon', 'suwon', 'daegu', 'gwangju', 'incheon', 'sokcho', 'daejeon', 'ulsan',  'yeosu'];
		var xArray = [162, 297, 136, 227, 170, 268, 158, 122, 271, 209, 324, 230, 273, 190];
		var yArray = [48, 270, 346, 20, 112, 199, 247, 54, 17, 156, 214, 85, 135, 284];
		
		for(i=0;i<array.length;i++){
			console.log(array[i]);
			var locationName=array[i];
			var pointX=xArray[i];
			var pointY=yArray[i];
			
			chano(locationName);
		}
		
		function chano(locationName){
			var nationUrl="http://api.openweathermap.org/data/2.5/weather?q="+locationName+"&appid=55d3503973ed8cc55f407d450e0c3899";
			$.ajax({
			    url: nationUrl,
			    dataType: "json",
			    type: "GET",
			    async: "false",
			    success: function(resp) {
			    	console.log(resp);
					
					var wImage="";
					var wName="";
					
					if(resp.weather[0].main=="Clouds"){ // 구름꼇을때
						wImage="<img src='${path}/resources/img/cloud.png' >"
					}else if(resp.weather[0].main=="Rain"){ // 비올때
						wImage="<img src='${path}/resources/img/rain.png' >"
					}else if(resp.weather[0].main=="Snow"){ // 눈올때
						wImage="<img src='${path}/resources/img/snow.png' >"
					}else{ // 맑을때 기모링
						wImage="<img src='${path}/resources/img/brightness.png' >"
					}
					
					if(resp.name=="Seoul"){
						wName="서울";
					}else if(resp.name=="Busan"){
						wName="부산";
					}else if(resp.name=="Jeju City"){
						wName="제주";
					}else if(resp.name=="Suwon-si"){
						wName="수원";
					}else if(resp.name=="Chuncheon"){
						wName="춘천";
					}else if(resp.name=="Daegu"){
						wName="대구";
					}else if(resp.name=="Gwangju"){
						wName="광주";
					}else if(resp.name=="Incheon"){
						wName="인천";
					}else if(resp.name=="Sokcho"){
						wName="속초";
					}else if(resp.name=="Daejeon"){
						wName="대전";
					}else if(resp.name=="Ulsan"){
						wName="울산";
					}else if(resp.name=="Wŏnju"){
						wName="원주";
					}else if(resp.name=="Andong"){
						wName="안동";
					}else if(resp.name=="Yeosu"){
						wName="여수";
					}
					
			        var data = '<div class="col-2"><div class="card">'+wImage+'<div class="card-body"><h5 class="card-title">'+wName+'</h5><p class="card-text">'+(resp.main.temp-273.15).toFixed(1)+' ℃</p></div></div></div>';
			        	/* <div style="
			        	 position:absolute;
			        	z-index:2;
			        	left:`+pointX+`;
			        	top:`+pointY+`;
			        	border:1px solid gray;
			        	border-radius: 10px;
			        	background-color:#fff;
			        	padding:10px;
			        	width:45px;
						height:70px;
			        	font-size: 0.5em;
			        	text=align:center; 
                  	 	">
			        		<a>
			        		<font size="1.8em">`+wName+`</font></a>	<br><b>
				        		<font size="5em">
				        			`+wImage+`
				        		</font>
			        		</b>
			        		<br>
			        		<c class="weather-number">`+((resp.main.temp- 273.15).toFixed(1))+`℃</c> */
			        
			        $('#list').append(data);
			    }
			});
		}
});

/* <p>var imgURL = "http://openweathermap.org/img/w/" + resp.weather[0].icon + ".png";
$("html컴포넌트").attr("src", imgURL);
</p> */


</script>
</body>
</html>
