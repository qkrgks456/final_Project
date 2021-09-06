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
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<%-- 상단 메뉴바 추가 --%>
<c:if test="${sessionScope.loginId eq null}">
    <jsp:include page="../../fix/navbar.jsp"/>
</c:if>
<c:if test="${sessionScope.loginId ne null}">
    <jsp:include page="../../fix/loginNavbar.jsp"/>
</c:if>
<jsp:include page="../../fix/menu.jsp"/>
<div class="row">
    <div class="flex-shrink-0 p-3 bg-white border-end vh-100" style="width: 280px;">
        <ul class="list-unstyled">
            <li class="mb-1">
                <p class="ms-4 align-items-center menuClick fw-bold fs-2" style="cursor: pointer">내 정보</p>
                <div class="">
                    <ul class="ms-4 list-unstyled fw-normal pb-1 listHide">
                        <li><a href="#" class="link-dark rounded fs-3">Overview</a></li>
                        <li><a href="#" class="link-dark rounded fs-3">Updates</a></li>
                        <li><a href="#" class="link-dark rounded fs-3">Reports</a></li>
                    </ul>
                </div>
            </li>
            <li class="border-top my-3"></li>
        </ul>
        <ul class="list-unstyled">
            <li class="mb-1">
                <p class="ms-4 align-items-center menuClick fw-bold fs-2" style="cursor: pointer">예약현황</p>
                <div class="">
                    <ul class="ms-4 list-unstyled fw-normal pb-1 listHide">
                        <li><a href="#" class="link-dark rounded fs-3">Overview</a></li>
                        <li><a href="#" class="link-dark rounded fs-3">Updates</a></li>
                        <li><a href="#" class="link-dark rounded fs-3">Reports</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
    <div class="col w-100 p-0">
        <div class="container px-3 border">
            안녕
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>
<script>
    $('.menuClick').on('click', function () {
        console.log("안녕");
        $(this).next().fadeToggle();
    })
</script>
</body>
</html>
