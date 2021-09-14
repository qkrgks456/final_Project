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
    <jsp:include page="../../fix/navbar.jsp"/>
</c:if>
<c:if test="${sessionScope.loginId ne null}">
    <jsp:include page="../../fix/loginNavbar.jsp"/>
</c:if>
<jsp:include page="../../fix/menu.jsp"/>
<div class="row">
    <jsp:include page="../adminSidebar.jsp"/>
    <div class="col w-100 p-0">
        <div class="container px-3 my-2">
       <h3>관리자 조회</h3>
       <table class="table table-hover text-center">
		<thead>
		<tr>
			<th scope="col" class="col-md-3">아아디</th>
			<th scope="col" class="col-md-2">이름</th>
			<th scope="col" class="col-md-3">이메일</th>
			<th scope="col" class="col-md-2">등급</th>
			<th scope="col" class="col-md-2">권한삭제</th>
		</tr>
		</thead>
		<tbody id="list">
			<!-- 가져올 리스트 -->
		</tbody>
	</table>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<%-- 공통 js --%>
<script src="${path}/resources/js/common.js"></script>
</body>
<script>
	adminSearch();
	function adminSearch(){
		console.log("jsp에서 관리자 ajax조회");
		$.ajax({
			url: 'adminSearch',
			type: 'get',
			dataType: 'json',
			success:function(data){
				console.log(data);
				adminList(data.list);
			},
			error:function(error){
				console.log(error);
			}
		
		});
	}
	function adminList(list){
		var content="";
		for(var i =0; i<list.length;  i++){
			content +="<tr>";
			content +="<td>"+ list[i].id+"</td>";
			content +="<td>"+ list[i].nickName +"</td>";
			content +="<td>"+ list[i].email +"</td>";
			content +="<td>"+ list[i].admin +"</td>";
			content +="<td>";
			content +="<a class='btn btn-sm btn-dark' href='adminDeleteAuthority?id=" + list[i].id
			+ "'>권한 해제</a>";
			content +="</td>";
			content +="</tr>";
		}
		$("#list").empty();
		$("#list").append(content);
	}
</script>
</html>
