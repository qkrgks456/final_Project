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
    <jsp:include page="../../../fix/navbar.jsp"/>
</c:if>
<c:if test="${sessionScope.loginId ne null}">
    <jsp:include page="../../../fix/loginNavbar.jsp"/>
</c:if>
<jsp:include page="../../../fix/menu.jsp"/>
<div class="row">
    <jsp:include page="../myInfoSidebar.jsp"/>
    <div class="col w-100 p-0">
        <div class="container px-3 my-2">
            	<div class="container px-3 mt-2">
	<h3>예약확인</h3>
		<table  class="table table-hover text-center">
		<thead>
		<tr>
			<th scope="col" class="col-md-5">캠핑장</th>
			<th scope="col" class="col-md-5">예약날짜</th>
		</tr>
		</thead>
		<tbody id="list">
			<!-- 리스트가 출력될 내용 -->
			<th scope="col" class="col-md-5">더하루 캠핑파크</th><br>
			<th scope="col" class="col-md-5">9월15일~9월16일</th>
		</tbody>
			<tbody id="list">
			<!-- 리스트가 출력될 내용 -->
			<th scope="col" class="col-md-5">화천드림캠핑장</th><br>
			<th scope="col" class="col-md-5">9월18일~9월19일</th>
		</tbody>
		<tbody id="list">
			<!-- 리스트가 출력될 내용 -->
			<th scope="col" class="col-md-5">세움내움</th><br>
			<th scope="col" class="col-md-5">9월20일~9월22일</th>
		</tbody>
		<tbody id="list">
			<!-- 리스트가 출력될 내용 -->
			<th scope="col" class="col-md-5">강화버팔로캠팜</th><br>
			<th scope="col" class="col-md-5">9월21일~9월23일</th>
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
		<!-- <input class="btn btn-primary" type="button" value="문의사항 쓰기" onclick="location.href='questionWriteForm'"> -->
	</div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>
</body>
</html>
