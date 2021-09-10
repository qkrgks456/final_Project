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
<div class="container px-3">
디테일

<table>
		<tr>
			<th>제목</th>
			<td>${dto	.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${dto.dates}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${dto.boardHit}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content}</td>
		</tr>
		<c:if test="${file.size()>0 }">
		<tr>
			<th>다운로드</th>
			<td>
				<ul>
					<c:forEach items="${file }" var="file">
					<!-- 뒤에 만약 /가 없으면 . 뒤에 확장자 내용을 지워버림 -->
						<li><a href="download/${file.oriFileName }/${file.newFileName}/">${file.oriFileName}</a></li>
					</c:forEach>
				</ul>
			</td>
		</tr>
		</c:if>
		<tr>
			<td colspan="2">
				<button onclick="location.href='noticeBoard'">리스트</button>
				<%-- <button onclick="location.href='./updateForm?idx=${bbs.idx}'">수정</button>
				<button onclick="location.href='./del?idx=${bbs.idx}'">삭제</button>			 --%>
			</td>
		</tr>
	</table>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>
</body>
</html>