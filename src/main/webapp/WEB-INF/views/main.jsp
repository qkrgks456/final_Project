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
    <jsp:include page="fix/navbar.jsp"/>
</c:if>
<c:if test="${sessionScope.loginId ne null}">
    <jsp:include page="fix/loginNavbar.jsp"/>
</c:if>
<%-- 상단 메뉴바 --%>
<jsp:include page="fix/menu.jsp"/>
<%-- 슬라이드 바 --%>
<section class="page-section">
    <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${path}/resources/img/test1.jpg" class="d-block w-100"
                     style="image-rendering:smooth;height: 330px" alt="...">
            </div>
            <div class="carousel-item">
                <img src="${path}/resources/img/test2.jpg" class="d-block w-100"
                     style="image-rendering:smooth;height: 330px" alt="...">
            </div>
            <div class="carousel-item">
                <img src="${path}/resources/img/test3.jpg" class="d-block w-100" style="height: 330px" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</section>
<%-- About --%>
<section class="page-section">
    <div class="container px-4 my-3">
        <div class="container px-3">
            <div class="container my-3">
                <div class="pt-4 border-bottom border-dark">
                    <h2 class="fw-bold">About</h2>
                </div>
                <div class="row text-center mt-4">
                    <div class="col-md-4">
						<span class="fa-stack fa-4x">
                            <i class="bi bi-check-lg" style="font-size:xxx-large"></i>
						</span>
                        <h4 class="my-3">혼잡도를 확인하세요</h4>
                        <p class="text-muted mt-2">우리는 당신이 원하는 카페에 도착하여 자리가 없어 시간을
                            낭비하지않기를 바랍니다. 실시간혼잡도를 통하여 카페좌석을 확인하세요</p>
                    </div>
                    <div class="col-md-4">
						<span class="fa-stack fa-4x"> <i class="bi bi-chat-square-dots" style="font-size:xxx-large"></i>
						</span>
                        <h4 class="my-3">의견을 공유하세요</h4>
                        <p class="text-muted">카페와 관련된 내용을 소통하고 나누세요. 다양한 분위기의 카페에 대한
                            여러 사람의 생각과 시각적 안목을 기를 수 있을것입니다.</p>
                    </div>
                    <div class="col-md-4">
						<span class="fa-stack fa-4x"> <i class="bi bi-emoji-heart-eyes" style="font-size:xxx-large"></i>
						</span>
                        <h4 class="my-3">좋아하는 카페를 확인하세요</h4>
                        <p class="text-muted">좋아하는 카페는 좋아요 기능을 통하여 혼잡도를 알림 받을 수 있습니다.
                            자주 이용하는 카페는 더 편리하게 이용하세요.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="page-section bg-dark">
    <div class="container px-4 px-lg-5 py-3">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-lg-8 text-center">
                <h2 class="text-white mt-0">We've got what you need!</h2>
                <hr class="text-white">
                <p class="text-white mb-4">Start Bootstrap has everything you need to get your new website up and
                    running in no time! Choose one of our open source, free to download, and easy to use themes! No
                    strings attached!</p>
                <a class="btn btn-light btn-xl" href="#services">더 알아보기</a>
            </div>
        </div>
    </div>
</section>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>
</body>
</html>
