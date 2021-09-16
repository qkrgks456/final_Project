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
<div class="container px-3 mt-2">
<div class="container mx-2">

<!-- 상단 -->
<div class="row">
	<div class="col">
		${dto.title}
	</div>
	
	<div class="col d-flex flex-row-reverse">
		<input type="button" value="수정" onclick="location.href='../questionUpdateForm/${dto.boardNum}'"/>
		<input type="button" value="삭제" onclick="location.href='../questionDel/${dto.boardNum}'"/>
	</div>	
</div>

<div class="row">
	<div class="col">
		${dto.id}  l  ${dto.dates}
	</div>
	
	<div class="col d-flex flex-row-reverse">
		조회수${dto.boardHit} l 좋아요0  l 댓글수0	
	</div>	
</div>

<hr/>

<!-- 중단 -->
<div>
	<div class="d-flex justify-content-center row">
		<c:forEach var="photo" items="${phoDtos}">
			<div class="d-flex justify-content-center row mb-3">
			<img src="/photo/${photo.newFileName}" style="max-width: 400px; height: auto;" onerror="this.src='${path}/resources/img/noImage.png';"/>
			</div>
		</c:forEach>
	</div>
	<br/>
	<div>
		${dto.content}
	</div>
</div>

<div class="d-flex justify-content-center"">
	<input type="button" value="좋아요"/>
	<input type="button" value="신고"/>
</div>

<hr/>

<div class="d-flex flex-row-reverse">
<input class="btn btn-primary" type="button" value="목록" onclick="location.href='../questionBoard'">
</div>


<!-- 댓글 -->









 
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>
</body>
</html>
