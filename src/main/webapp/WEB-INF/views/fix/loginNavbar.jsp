<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%-- 최상단 메뉴바 --%>
<div style="background-color: #DCDCDC">
    <div class="d-flex justify-content-end">
        <div class="border-end border-dark">
            <a class="fs-6 btn-sm btn-outline-light text-dark" href="${path}/member/logout" style="text-decoration:none">로그아웃</a>
        </div>
        <div class="border-end border-dark">
            <a href="${path}/member/myInfo" class="fs-6 btn-sm btn-outline-light text-dark" style="text-decoration:none">내정보</a>
        </div>
        <div class="border-end border-dark">
            <a href="#" class="fs-6 btn-sm btn-outline-light text-dark" style="text-decoration:none">예약현황</a>
        </div>
        <div class="">
            <a href="#" class="fs-6 btn-sm btn-outline-light text-dark" style="text-decoration:none">공지사항</a>
        </div>
        <div class="">
            <a href="#" class="fs-6 btn-sm btn-outline-light text-dark" style="text-decoration:none">관리자</a>
        </div>
    </div>
</div>

