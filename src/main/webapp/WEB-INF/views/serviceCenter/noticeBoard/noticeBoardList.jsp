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
	<div class="container px-3 mt-2">
	<h3>공지사항</h3>
		<table  class="table table-hover">
		<thead>
		<tr>
			<th scope="col">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">날짜</th>
			<th scope="col">조회수</th>
		</tr>
		</thead>
		<%-- <tbody>
		<c:forEach items="${list}" var="dto">
			<tr onClick = "location.href='noticeDetail?boardnum=${dto.boardNum}'">
				<td>${dto.title}</td>
				<td>${dto.id}</td>
				<td>${dto.dates}</td>
				<td>${dto.boardHit}</td>
			</tr>
		</c:forEach>
		</tbody> --%>
		<tbody id="list">
			<!-- 리스트가 출력될 내용 -->
		</tbody>
		<tr>
			<td colspan="6">
				<!--  페이징이 표시될 부분 -->
				<div class="contanier">
					<nav aria-label="Page navigation" style="text-algin:center">
						<ul class="pagination" id="pagination"></ul>
					</nav>
				</div>
			</td>
		</tr>
		</table>
		<input class="btn btn-primary" type="button" value="공지사항쓰기" onclick="location.href='#'">
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${path}/resources/js/bootstrap.js"></script>
	<script src="${path}/resources/js/bootstrap.bundle.js"></script>
	<script src="${path}/resources/js/common.js"></script>
	<script>
	var currPage = 1;
	var per = 10;
	listCall(currPage);


	function listCall(page) {
		//{pagePerNum}/{page}
		var reqUrl = 'noticeBoardList/' + per + "/" + page;
		//console.log('request page' + reqUrl);
		console.log(page + " page가져오기");
		console.log(reqUrl);

		/* $.ajax({
			url : reqUrl,
			type : 'get',
			dataType : 'json',
			success : function(data) { //데이터가 성공적으로 들어왔다면
				console.log(data);
				listPrint(data.list); //리스트 그리기
				currPage = data.currPage;
				//페이징 처리
				$("#pagination").twbsPagination({
					startPage:data.currPage,//시작페이지 -> service에서 sql실행하여 map으로 보낸 데이타 값
					totalPages:data.pages,//총 페이지 갯수 -> service에서 sql실행하여 map으로 보낸 데이타 값
					visiblePages:5,//보여줄 페이지 갯수
					onPageClick: function(e,page){
						console.log(e,page);
						listCall(page);
					}
				});
			},
			error : function(error) {
				console.log(error);
			}
		}); */
	}
	
	function listPrint(list){
		var content = "";
		
		for(var i = 0; i<list.length; i++){
			
			content += "<tr>";
			content +="<td>"+list[i].id+"</td>";
			content +="<td>"+list[i].title+"</td>";
			//miliscondes로 표현됨 그래서 Date()를 통해서 바꿔야 함
			//content +="<td>"+list[i].reg_date+"</td>";
			var date = new Date(list[i].dates);
			//console.log(date.toLocaleDateString("ko-KR"));
			content +="<td>"+date.toLocaleDateString("ko-KR")+"</td>";
			//content +="<td>"+list[i].bHit+"</td>";
			content +="</tr>";
			$("#list").empty();
			$("#list").append(content);
		}
	}
	</script>
</body>
</html>
