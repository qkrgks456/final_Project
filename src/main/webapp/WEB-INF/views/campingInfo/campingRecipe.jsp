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
<style>
#dimention{
	height:750px;
}
#blog{
	width:800px;
	height:750px;
}

</style>
</head>
<body>
	<%-- 상단 로그인 추가 --%>
	<c:if test="${sessionScope.loginId eq null}">
		<jsp:include page="../fix/navbar.jsp" />
	</c:if>
	<c:if test="${sessionScope.loginId ne null}">
		<jsp:include page="../fix/loginNavbar.jsp" />
	</c:if>
	<%-- 상단 메뉴바 --%>
	<jsp:include page="../fix/menu.jsp" />
	<%-- 내용 넣으세요 --%>
	<div class="container px-3">
		<h3>캠핑 레시피</h3>
		<h5 id="total"></h5>
		<div class="d-flex justify-content-start">
			<div class="col-5 m-0 p-0">
				<!-- 왼쪽으로 당기기 -->
				<div class="row">
					<!-- 검색 공간 -->
					<div class=" col-10 ps-3 pe-0">
						<input type="text" class="form-control" id="searchInput"
							name="searchInput" />
					</div>
					<!-- 검색 버튼 공간 -->
					<div class="form-group col-2 p-0">
						<button id="searchBtn" class="btn btn-dark">검색</button>
					</div>
				</div>
				<!-- 레시피 부분 -->
				<div id ="scroll" class="overflow-scroll">
				<div id="dimention" class="d-flex justify-content-start row">
					<div id="card" class="row row-cols-1 row-cols-md-2 g-4">
					
					</div>

				</div>
				</div>

			</div>
			<div id="blog" class="ml-3">블로그화면 공간
			<div class="ratio ratio-16x9">
 			 <iframe src="https://blog.naver.com/esther78944/222498429159" title="YouTube video" allowfullscreen>
 			 
 			 </iframe>
			</div>
			</div>
			<p id="blog"></p>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${path}/resources/js/bootstrap.js"></script>
	<script src="${path}/resources/js/bootstrap.bundle.js"></script>
	<script src="${path}/resources/js/common.js"></script>
	<script>
	
		
		var search = "캠핑";
		blog(search);
		
		$('#searchBtn').on('click',function(){
			search=$("#searchInput").val();
			blog(search);
		});
		
		$('#searchInput').on('keypress', function(e) {
			if (e.keyCode == '13') {
				$('#searchBtn').click();
			}
		});
		
		function blog(search) {
				$("#card").empty();
					search += "레시피";
					$.ajax({
						url : 'RecipeApi',
						type : 'GET',
						data : {
							"search" : search,
							"page" : 1,
							"perPage" : 10
						},
						dataType : 'JSON',
						success : function(data) {
							console.log(data);
							var content = "";

							$("#total").empty();
							$("#total").append("총 검색 수: " + data.total);
							
							//블로그 게시물들
							for (var i = 0; i < data.items.length; i++){
								//카드
							content = "";
							content += "<div class='col'>";
							content += "<div class='card border-dark'>";
							content += "<div class='card-body'>";
							content += "<h5 class='card-title'>"+data.items[i].title+"</h5>";
							content += "<p class='card-text'>"+data.items[i].description+"</p>";
							content += "</div>";
							content += "</div>";
							content += "</div>";
							$("#card").append(content);
							}
							

						},
						error : function(e) {
							console.log(e);
						}
					});
			}
			
	</script>
</body>

</html>
