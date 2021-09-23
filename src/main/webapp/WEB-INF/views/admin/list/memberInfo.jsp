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
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet">
<%-- 공통 css --%>
<link href="${path}/resources/css/common.css?var=3" rel="stylesheet">
<style>
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<%-- 상단 메뉴바 추가 --%>
	<c:if test="${sessionScope.loginId eq null}">
		<jsp:include page="../../fix/navbar.jsp" />
	</c:if>
	<c:if test="${sessionScope.loginId ne null}">
		<jsp:include page="../../fix/loginNavbar.jsp" />
	</c:if>
	<jsp:include page="../../fix/menu.jsp" />
	<div class="row">
		<jsp:include page="../adminSidebar.jsp" />
		<div class="col w-100 p-0">
			<div class="container px-3 my-2">
				<h3>회원정보</h3>
				<!-- 전체 출력에서 검색내용을  넣었을 때 해당 내용 출력-->
				<div class="row mb-1">
					<!-- 셀렉트 -->
					<div class="form-group col-2 m-0 p-0">
						<select id ="selectType" class="form-select" name="selectType">
							<option value="nickName" selected>이름</option>
							<option value="id">아이디</option>
							<option value="email">이메일</option>
						</select>
					</div>
					<!-- 검색/버튼 -->
					<div class="col-10 m-0 p-0">
						<!-- 왼쪽으로 당기기 -->
						<div class="row">
							<!-- 검색 공간 -->
							<div class="form-group col-10 mp-0 me-0">
								<input type="text" class="form-control" id="memberInfoSearch"
									name="memberInfoSearch" />
							</div>
							<!-- 검색 버튼 공간 -->
							<div class="form-group col-2 p-0 m-0">
								<button id="searchBtn" class="btn btn-dark">검색</button>
							</div>
						</div>
					</div>
				</div>

				<table class="table table-hover text-center">
					<thead>
						<tr>
							<th scope="col" class="col-md-3">아아디</th>
							<th scope="col" class="col-md-2">이름</th>
							<th scope="col" class="col-md-3">블랙리스트 여부</th>
							<th scope="col" class="col-md-2">블랙리스트</th>
					</thead>
					<tbody id="list">
						<!-- 가져올 리스트 -->
					</tbody>
				</table>
				<%-- <button class="btn btn-dark" type="button" onclick="location.href='memberInfoBlackList?id=${list.id}'">상세보기</button> --%>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${path}/resources/js/bootstrap.js"></script>
	<script src="${path}/resources/js/bootstrap.bundle.js"></script>
	<%-- 공통 js --%>
	<script src="${path}/resources/js/common.js"></script>
</body>
<script>
memberInfo();
$('#memberInfoSearch').on('keypress', function(e) {
	if (e.keyCode == '13') {
		$('#searchBtn').click();
	}
});
$('#searchBtn').on('click', function() {
	//var selectType = $("#selectType").val();
	//var insertSearch=$("#insertSearch").val();
	//console.log("타입: "+ selectType+ "내용: "+insertSearch);
	$.ajax({
		url : 'memberInfoSearch',
		type : 'get',
		data : {
			memberInfoSearch : $("#memberInfoSearch").val(),
			selectType : $("#selectType").val()
		},
		dataType : 'JSON',
		success : function(data) {
			console.log(data);
			memberInfoList(data.list);
		},
		error : function(error) {
			console.log(error);
		}
	});
});

	
	function memberInfo() {
		console.log("jsp에서 관리자 ajax조회");
		$.ajax({
			url : 'memberInfoAjax',
			type : 'get',
			dataType : 'json',
			success : function(data) {
				console.log(data);
				memberInfoList(data.list);
			},
			error : function(error) {
				console.log(error);
			}

		});
	}
	function memberInfoList(list) {
		var content = "";
		for (var i = 0; i < list.length; i++) {
			content += "<tr>";
			content += "<td>" + list[i].id + "</td>";
			content += "<td>" + list[i].nickName + "</td>";
			content += "<td>" + list[i].delCheck + "</td>";
			content += "<td>";
			if(list[i].delCheck=="Y"){
				content += "<a class='btn btn-sm btn-dark' href='memberInfoBlackDel?id=" + list[i].id
				+ "'>블랙리스트  해제</a>";
			}
			if(list[i].delCheck=="N"){
				content += "<a class='btn btn-sm btn-dark' href='memberInfoBlackList?id=" + list[i].id
				+ "&nickName="+list[i].nickName+"'>블랙리스트  추가</a>";
			}
			
			
			content += "</td>";
			content += "</tr>";
		}
		$("#list").empty();
		$("#list").append(content);
	}
</script>

</html>
