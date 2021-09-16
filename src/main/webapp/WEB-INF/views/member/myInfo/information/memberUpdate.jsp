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
            <div class="pt-4 border-bottom border-dark">
        <h2 class="fw-bold">정보수정</h2>
    </div>
    <div class="d-flex justify-content-center my-2">
        <form action="${path}/member/join" class="w-50" method="post">
            <div class="mb-3">
                <label for="id" class="form-label">${dto.id} 아이디</label>
                <input name="id" type="text" class="form-control nullCheck" id="id" placeholder="필수정보 입니다"  >
            </div>
            <div class="mb-3">
                <label for="pw" class="form-label">비밀번호</label>
                <input name="pw" type="password" class="form-control nullCheck goCheck" id="pw" placeholder="필수정보 입니다">
                <div class="invalid-feedback"></div>
            </div>
            <div class="mb-3">
                <label for="nicName" class="form-label">닉네임</label>
                <input name="nicName" type="text" class="form-control nullCheck goCheck" id="nicName"
                       placeholder="필수정보 입니다">
                <div class="invalid-feedback"></div>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <input name="email" type="text" class="form-control nullCheck" id="email" placeholder="필수정보 입니다"
                       readonly>
                <div class="valid-feedback">인증 성공!</div>
            </div>
            <div class="mb-3 text-center">
                <input id="joinBtn" type="submit" class="btn btn-warning" value="정보수정">
            </div>
        </form>
        <!-- 팝업창 -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div>
                            <label for="code" class="form-label">이메일</label>
                            <input class="form-control" type="text" id="emailSender" name="emailSender"
                                   placeholder="이메일을 입력해주세여">  
                        </div>
                        <div>
                            <label for="code" class="form-label">인증코드</label>
                            <input class="form-control" type="text" id="code" name="code" placeholder="코드를 입력해주세요">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button id="close" type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기
                        </button>
                        <button id="right" type="button" class="btn btn-warning">확인</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:if test="${suc eq 0}">
    <script>
        alert('다시 시도해주세요');
    </script>
</c:if>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>
</body>
</html>
