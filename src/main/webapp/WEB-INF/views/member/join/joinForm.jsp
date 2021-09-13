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
<%-- 상단 메뉴바 추가 --%>
<c:if test="${sessionScope.loginId eq null}">
    <jsp:include page="../../fix/navbar.jsp"/>
</c:if>
<c:if test="${sessionScope.loginId ne null}">
    <jsp:include page="../../fix/loginNavbar.jsp"/>
</c:if>
<jsp:include page="../../fix/menu.jsp"/>
<div class="container px-3 py-3">
    <div class="pt-4 border-bottom border-dark">
        <h2 class="fw-bold">회원가입</h2>
    </div>
    <div class="d-flex justify-content-center my-2">
        <form action="" class="w-50" method="post">
            <div class="mb-3">
                <label for="id" class="form-label">아이디</label>
                <input name="id" type="text" class="form-control" id="id" placeholder="필수정보 입니다">
                <div class="invalid-feedback">Please enter a message in the textarea.</div>
                <a id="idCheck" class="btn btn-warning btn-sm mt-2">중복확인</a>
            </div>
            <div class="mb-3">
                <label for="pw" class="form-label">비밀번호</label>
                <input name="pw" type="password" class="form-control" id="pw" placeholder="필수정보 입니다">
                <div class="invalid-feedback">Please enter a message in the textarea.</div>
            </div>
            <div class="mb-3">
                <label for="nicName" class="form-label">닉네임</label>
                <input name="nicName" type="text" class="form-control" id="nicName" placeholder="필수정보 입니다">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <input name="email" type="text" class="form-control" id="email" placeholder="필수정보 입니다">
                <a class="btn btn-warning btn-sm mt-2">이메일인증</a>
            </div>
            <div class="mb-3">
                <label for="code" class="form-label">이메일인증코드</label>
                <input name="code" type="text" class="form-control" id="code" placeholder="받으신 코드를 입력해주세요!">
            </div>
            <div class="mb-3 text-center">
                <a class="btn btn-warning">회원가입</a>
            </div>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">

/* $('#idCheck').click({
	console.log(안녕);
	ajax({
		url:member/join,
		type:'post',
		data:{
			id:id
		},
		dataType:'json',
		success:function(data){
					console.log(data);
		},
		error:function(error){
			console.log(error);
		}			
	})
}) */
</script>

</body>
</html>
