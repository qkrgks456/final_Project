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
    <jsp:include page="../fix/navbar.jsp"/>
</c:if>
<c:if test="${sessionScope.loginId ne null}">
    <jsp:include page="../fix/loginNavbar.jsp"/>
</c:if>
<%-- 상단 메뉴바 --%>
<jsp:include page="../fix/menu.jsp"/>
<%-- 내용 넣으세요 --%>
<div class="w-100 img-fluid border-white"
     style="height:300px;background-image: url('${path}/resources/img/bgHansol.jpg')">
    <div class="container pt-5 border-bottom border-white">
    <h1 class="text-white display-4">캠핑장이름</h1>
        <h4 class="text-white ">한줄요약 들어갈 예정이다</h4>
    </div>
    <div class="container pt-2">
    <h3 class="text-white ">태그 #봄 #여름 #따뜻한 #친절한</h3>
    </div>
</div>
<div class="container px-3 my-3">
    <div class="row">
        <div class="col-md-6 pt-2">
            <img src="${path}/resources/img/noImage.png" class="rounded img-fluid mx-auto d-block"
                 style="width: 500px; height: 360px;object-fit: cover;"/>
        </div>
        <div class="col-md-5">
            <table class="table table-hover align-middle">
                <tr>
                    <td class="col-3 py-3">주소</td>
                    <td>예시예시예시예시예시예시예시예시예시예시예시</td>
                </tr>
                <tr>
                    <td class="py-3">문의처</td>
                    <td>예시예시예시예시예시예시예시예시예시예시예시</td>
                </tr>
                <tr>
                    <td class="py-3">캠핑장 환경</td>
                    <td>예시예시예시예시예시예시예시예시예시예시예시</td>
                </tr>
                <tr>
                    <td class="py-3">캠핑장 유형</td>
                    <td>예시예시예시예시예시예시예시예시예시예시예시</td>
                </tr>
                <tr>
                    <td class="py-3">운영기간</td>
                    <td>예시예시예시예시예시예시예시예시예시예시예시</td>
                </tr>
                <tr>
                    <td class="py-3">운영일</td>
                    <td>예시예시예시예시예시예시예시예시예시예시예시</td>
                </tr>
                <tr>
                    <td class="py-3">홈페이지</td>
                    <td>예시예시예시예시예시예시예시예시예시예시예시</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="text-center mt-3">
        <a class="btn btn-warning mx-1">예약하기</a>
        <a class="btn btn-warning">가고싶어요!</a>
    </div>
    <div class="pt-4 border-bottom border-dark">
        <h4 class="fw-bold">캠핑장 소개</h4>
    </div>
    <div class="py-4 d-flex justify-content-between border-bottom border-dark">
        <img src="${path}/resources/img/noImage.png" style="width: 400px;">
        <img src="${path}/resources/img/noImage.png" style="width: 400px;">
        <img src="${path}/resources/img/noImage.png" style="width: 400px;">
    </div>
    <div class="pt-4">
        <p class="fs-6">상세설명이 들어갈 예정이다 상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다
            상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다
            상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다
            상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다
            상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다상세설명이 들어갈 예정이다
        </p>
    </div>
    <div class="pt-4 border-bottom border-dark">
        <h4 class="fw-bold">캠핑장 시설정보</h4>
    </div>
    <div class="py-4 my-2 rounded" style="height: 150px; background-color: #F6F5F4">
        <div class="container my-3 px-2 text-center d-flex justify-content-around">
            <div>
            <i class="bi bi-water fs-4"></i>
            <h5 class="align-middle">물놀이</h5>
            </div>
            <div>
                <i class="bi bi-life-preserver fs-4"></i>
                <h5 class="align-middle">안전</h5>
            </div>
            <div>
                <i class="bi bi-wifi fs-4"></i>
                <h5 class="align-middle">와이파이</h5>
            </div>
            <div>
                <i class="bi bi-lightning-fill fs-4"></i>
                <h5 class="align-middle">전기</h5>
            </div>
        </div>
    </div>
    <div class="pt-4 border-bottom border-dark">
        <h4 class="fw-bold">기타 주요시설</h4>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>
</body>
</html>
