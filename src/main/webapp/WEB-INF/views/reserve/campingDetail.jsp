<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <h1 id="infoAttr" class="text-white display-4" contentId="${map.dto.contentId}"
            path="${path}">${map.dto.facltNm}</h1>
        <div class="container pt-2">
            <h3 class="text-white ">
                <c:forTokens var="val" items="${map.dto.themaEnvrnCl}" delims=",">
                    #${val}
                </c:forTokens>
            </h3>
        </div>
    </div>
    <div class="container pt-2">
        <h3 class="text-white ">${map.dto.featureNm}</h3>
    </div>
</div>
<div class="container px-3 my-5">
    <div class="row">
        <div class="col-md-6 pt-2">
            <c:if test="${map.dto.firstImageUrl eq null}">
                <img src="${path}/resources/img/noImage.png" class="rounded img-fluid mx-auto d-block"
                     style="width: 500px; height: 360px;object-fit: cover;"/>
            </c:if>
            <c:if test="${map.dto.firstImageUrl ne null}">
                <img src="${map.dto.firstImageUrl}" class="rounded img-fluid mx-auto d-block"
                     style="width: 500px; height: 360px;object-fit: cover;"/>
            </c:if>
        </div>
        <div class="col-md-5">
            <table class="table table-hover align-middle">
                <tr>
                    <td class="col-3 py-3">주소</td>
                    <td>${map.dto.addr1}</td>
                </tr>
                <tr>
                    <td class="py-3">문의처</td>
                    <td>${map.dto.tel}</td>
                </tr>
                <tr>
                    <td class="py-3">캠핑장 환경</td>
                    <td>${map.dto.lctCl}</td>
                </tr>
                <tr>
                    <td class="py-3">캠핑장 유형</td>
                    <td>${map.dto.induty}</td>
                </tr>
                <tr>
                    <td class="py-3">운영기간</td>
                    <td>${map.dto.operPdCl}</td>
                </tr>
                <tr>
                    <td class="py-3">운영일</td>
                    <td>${map.dto.operDeCl}</td>
                </tr>
                <tr>
                    <td class="py-3">홈페이지</td>
                    <td><a href="${map.dto.homepage}">${map.dto.homepage}</a></td>
                </tr>
            </table>
        </div>
    </div>
    <div class="text-center mt-3">
        <a href="${path}/reserve/campingReserve" class="btn btn-warning mx-1">예약하기</a>
        <a class="btn btn-warning">가고싶어요!</a>
    </div>
    <div class="pt-4 border-bottom border-dark">
        <h4 class="fw-bold">캠핑장 소개</h4>
    </div>
    <div class="py-4 d-flex justify-content-between border-bottom border-dark">
        <c:if test="${fn:length(map.imgArr) eq 3}">
            <c:forEach items="${map.imgArr}" var="arr">
                <img src="${arr}" style="width: 400px; height: 250px"
                     onerror="this.src='${path}/resources/img/noImage.png';">
            </c:forEach>
        </c:if>
        <c:if test="${fn:length(map.imgArr) ne 3}">
            <img src="${path}/resources/img/noImage.png" style="width: 400px; height: 250px">
            <img src="${path}/resources/img/noImage.png" style="width: 400px; height: 250px">
            <img src="${path}/resources/img/noImage.png" style="width: 400px; height: 250px">
        </c:if>
    </div>
    <div class="pt-4">
        <p class="fs-6">
            ${map.dto.intro}
        </p>
    </div>
    <div class="pt-4 border-bottom border-dark">
        <h4 class="fw-bold">캠핑장 시설정보</h4>
    </div>
    <div class="py-4 my-2 rounded" style="height: 150px; background-color: #F6F5F4">
        <div class="container my-3 px-2 text-center d-flex justify-content-around">
            <c:forTokens var="val" items="${map.dto.sbrsCl}" delims=",">
                <c:if test="${val eq '무선인터넷'}">
                    <div>
                        <i class="bi bi-wifi fs-3"></i>
                        <h5 class="align-middle">${val}</h5>
                    </div>
                </c:if>
                <c:if test="${val eq '전기'}">
                    <div>
                        <i class="bi bi-plug fs-3"></i>
                        <h5 class="align-middle">${val}</h5>
                    </div>
                </c:if>
                <c:if test="${val eq '물놀이장'}">
                    <div>
                        <i class="bi bi-water fs-3"></i>
                        <h5 class="align-middle">${val}</h5>
                    </div>
                </c:if>
                <c:if test="${val eq '온수'}">
                    <div>
                        <i class="bi bi-droplet fs-3"></i>
                        <h5 class="align-middle">${val}</h5>
                    </div>
                </c:if>
                <c:if test="${val eq '산책로'}">
                    <div>
                        <i class="bi bi-bicycle fs-3"></i>
                        <h5 class="align-middle">${val}</h5>
                    </div>
                </c:if>
                <c:if test="${val eq '놀이터'}">
                    <div>
                        <i class="bi bi-emoji-laughing fs-3"></i>
                        <h5 class="align-middle">${val}</h5>
                    </div>
                </c:if>
                <c:if test="${val eq '장작판매'}">
                    <div>
                        <i class="bi bi-tree fs-3"></i>
                        <h5 class="align-middle">${val}</h5>
                    </div>
                </c:if>
                <c:if test="${val eq '마트.편의점'}">
                    <div>
                        <i class="bi bi-basket2 fs-3"></i>
                        <h5 class="align-middle">${val}</h5>
                    </div>
                </c:if>
            </c:forTokens>
        </div>
    </div>
    <div class="pt-4 border-bottom border-dark">
        <h4 class="fw-bold">기타 주요시설</h4>
    </div>
    <table class="table table-hover align-middle">
        <tr>
            <td class="col-3 py-3">주요시설</td>
            <td>${map.dto.posblFcltyCl}</td>
        </tr>
        <tr>
            <td class="py-3">기타 부대시설</td>
            <td>${map.dto.sbrsEtc}</td>
        </tr>
        <tr>
            <td class="py-3">바닥환경</td>
            <td>
                <c:if test="${map.dto.sitebottomCl1 ne 0}">
                    잔디
                </c:if>
                <c:if test="${map.dto.sitebottomCl2 ne 0}">
                    파쇄석
                </c:if>
                <c:if test="${map.dto.sitebottomCl3 ne 0}">
                    테크
                </c:if>
                <c:if test="${map.dto.sitebottomCl4 ne 0}">
                    자갈
                </c:if>
                <c:if test="${map.dto.sitebottomCl5 ne 0}">
                    맨흙
                </c:if>
            </td>
        </tr>
        <tr>
            <td class="py-3">반려동물 출입</td>
            <td>${map.dto.animalCmgCl}</td>
        </tr>
        <tr>
            <td class="py-3">화로대</td>
            <td>${map.dto.brazierCl}</td>
        </tr>
    </table>
    <div class="pt-4 border-bottom border-dark">
        <h4 class="fw-bold">댓글</h4>
    </div>
    <%-- 댓글 입력 폼 --%>
    <div class="d-flex align-items-center mt-2">
        <div class="form-floating flex-grow-1 px-2">
    <textarea class="form-control" placeholder="Leave a comment here"
              name="commentContent" id="commentContent"
              style="height: 100px; resize: none;"></textarea>
            <div class="invalid-feedback">1자 이상 입력해주세요</div>
            <c:if test="${sessionScope.loginId eq null}">
                <label for="commentContent">댓글을 작성하려면, 로그인 해주세요</label>
            </c:if>
            <c:if test="${sessionScope.loginId ne null}">
                <label for="commentContent">${sessionScope.loginId}님 이곳에 댓글을 작성하세요</label>
            </c:if>
        </div>
        <c:if test="${sessionScope.loginId ne null}">
            <a id="cafeCommentBtn" class="btn btn-warning btn-sm">등록</a>
        </c:if>
    </div>
    <%-- 댓글리스트 --%>
    <div id="commentLists" class="container px-5 my-4">
        <c:forEach items="${map.commentList}" var="dto">
            <%-- 댓글 내용 --%>
            <div class="listForm">
                <p class="fw-bold">${dto.id}</p>
                <p class="lh-sm">
                        ${dto.content}
                <div>
                    <a class="btn btn-warning btn-sm" href="">신고</a>
                    <a class='commentDelBtn btn btn-warning btn-sm'>삭제</a>
                    <a class='commentUpdateBtn btn btn-warning btn-sm'>수정</a>
                </div>
                </p>
                <hr/>
            </div>
            <%-- 수정하기 수정 클릭시 요놈 생김 --%>
            <div class="updateForm visually-hidden">
                <p class="fw-bold">${dto.id}</p>
                <div class="form-floating flex-grow-1 px-2">
    <textarea class="commentUpdateContent form-control"
              name="commentUpdateContent"
              style="height: 100px; resize: none;">${dto.content}</textarea>
                    <label>수정할 댓글을 작성하세요</label>
                    <div class="invalid-feedback">1자 이상 입력해주세요</div>
                </div>
                <div class="d-flex justify-content-end mt-2"
                     id="commentUpdateOut">
                    <a class='commentUpdateContentBtn btn btn-warning btn-sm mx-2'>등록</a>
                    <a class='cmUpdateCancel btn btn-warning btn-sm'>취소</a>
                </div>
                <hr/>
            </div>
        </c:forEach>
    </div>
    <%-- 페이지 네이션 --%>
    <ul class="pagination justify-content-center mb-3">
        <c:if test="${map.startPage ne 1}">
            <li class="page-item">
                <a class="page-link" href="?page=${map.startPage-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:forEach var="i" begin="${map.startPage}" end="${map.endPage}">
            <c:if test="${i ne map.currPage}">
                <li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
            </c:if>
            <c:if test="${i eq map.currPage}">
                <li class="page-item active"><a class="page-link">${i}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${map.totalPage ne map.endPage}">
            <li class="page-item">
                <a class="page-link" href="?page=${map.endPage+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
    <div class="visually-hidden">
        밑창띄우기
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script src="${path}/resources/js/common.js?var=1"></script>
<script>
    /* 댓글 등록 ajax */
    $('#cafeCommentBtn').on('click', function () {
        let contentId = $('#infoAttr').attr('contentId');
        let path = $('#infoAttr').attr('path');
        let commentContent = $('#commentContent').val();
        if (commentContent.trim() != "") {
            $('#commentContent').removeClass('is-invalid');
            let cafeKey = $('#cafeCommentBtn').attr("title");
            $.ajax({
                type: "POST",//방식
                url: path + "/reserve/reserveCmInsert",//주소
                data: {
                    commentContent: commentContent,
                    contentId: contentId
                },
                dataType: 'JSON',
                success: function (data) { //성공시
                    console.log(data);
                    /*commentList(data);*/
                    $('#commentContent').val("");
                },
                error: function (e) { //실패시
                    console.log(e);
                }
            });
        } else {
            $('#commentContent').addClass('is-invalid');
        }
    })

    /*/!* 댓글 삭제 ajax *!/
    $('#commentLists').on('click', '.commentDelBtn', function () {
        var commentNo = $(this).attr('title');
        var cafeKey = $('#cafeCommentBtn').attr("title");
        $.ajax({
            type: "POST",//방식
            url: "/Project/cafeCommentDel",//주소
            data: {
                commentNo: commentNo,
                cafeKey: cafeKey,
            },
            dataType: 'JSON',
            success: function (data) { //성공시
                commentList(data);
            },
            error: function (e) { //실패시
                console.log(e);
            }
        });
    })
    /!* 댓글 페이지 네이션 클릭시 ajax *!/
    $('#paginations').on('click', '.pageNum', function () {
        var pageAndCafeKey = $(this).attr('title');
        var pageArr = pageAndCafeKey.split(' ');
        var page = pageArr[0];
        var cafeKey = pageArr[1];
        $.ajax({
            type: "POST",//방식
            url: "/Project/cafeCommentList",//주소
            data: {
                page: page,
                cafeKey: cafeKey,
            },
            dataType: 'JSON',
            success: function (data) { //성공시
                commentList(data);
            },
            error: function (e) { //실패시
                console.log(e);
            }
        });
    })

    /!* 댓글 업데이트 ajax *!/
    $(document).on('click', '.commentUpdateContentBtn', function () {
        var commentNo = $(this).attr('title');
        var cafeKey = $('#cafeCommentBtn').attr("title");
        var commentUpdateContent = $(this).parent().prev().children('.commentUpdateContent').val();
        console.log(commentUpdateContent);
        if (commentUpdateContent.trim() != "") {
            $.ajax({
                type: "POST",//방식
                url: "/Project/cafeCommentUpdate",//주소
                data: {
                    commentUpdateContent: commentUpdateContent,
                    commentNo: commentNo,
                    cafeKey: cafeKey,
                },
                dataType: 'JSON',
                success: function (data) { //성공시
                    commentList(data);
                },
                error: function (e) { //실패시
                    console.log(e);
                }
            });
        } else {
            $(this).parent().prev().children('.commentUpdateContent').addClass('is-invalid');
        }
    })*/

    /* 댓글 리스트 메서드 */
    function commentList(data) {
        console.log(data);
        let content = "";
        let sessionId = data.sessionId;
        $.each(data.list, function (i, item) {
            let check = sessionId == item.memberKey;
            let check2 = sessionId == null;
            console.log(check2);
            content += "<div class='updateCheck'>"
            content += "<p class='fw-bold'>" + item.memberKey + "</p>";
            content += "<p class='lh-sm'>";
            content += item.cm_content;
            if (!check && !check2) {
                content += "<a href='/Project/report/report.jsp?commentNo=" + item.commentNo + "&memberKey=" + item.memberKey + "&commentContent=" + item.cm_content + "&cafeKey=" + data.cafeKey + "'"
                content += " class='float-end btn btn-secondary btn-sm'>신고</a>";
            } else if (check) {
                content += "<a class='commentDelBtn mx-2 float-end btn btn-secondary btn-sm' title='" + item.commentNo + "'>삭제</a>";
                content += "<a class='commentUpdateBtn float-end btn btn-secondary btn-sm'>수정</a>";
            }
            content += "</p>";
            content += "<hr/>";
            content += "</div>";
            content += "<div class='updateForm visually-hidden'>"
            content += "<p class='fw-bold'>" + item.memberKey + "</p>"
            content += "<div class='form-floating flex-grow-1 px-2'>"
            content += "<textarea class='commentUpdateContent form-control' placeholder='Leave a comment here'"
            content += "name='commentUpdateContent' id='commentUpdateContent' style='height: 100px'>" + item.cm_content + "</textarea>"
            content += "<div class='invalid-feedback'>1자 이상 입력해주세요</div>"
            content += "<label for='commentUpdateContent'>수정할 댓글을 작성하세요</label>"
            content += "</div>"
            content += "<div class='d-flex justify-content-end mt-2' id='commentUpdateOut'>"
            content += "<a id='commentUpdateContentBtn' class='commentUpdateContentBtn btn btn-secondary btn-sm mx-2' title='" + item.commentNo + "'>등록</a>"
            content += "<a class='cmUpdateCancel btn btn-secondary btn-sm'>취소</a>"
            content += "</div>"
            content += "<hr />"
            content += "</div>"
        });
        $('#commentLists').empty();
        $('#commentLists').append(content);

        content = "";
        content += "<i id='commenticons' class='bi bi-chat-square-text-fill mt-1' style='font-size: 2.0rem;'></i>"
        content += "<p  class='ms-2 mt-3 fw-bold'>댓글(" + data.commentCount + ")</p>"
        $('#commenticon').empty();
        $('#commenticon').append(content);
        /* 페이지네이션 불러오기 욕나오네 */
        content = ''
        content += '<ul class="pagination justify-content-center">'
        if (data.startPage != 1) {
            content += '<li class="page-item">'
            content += '<a class="page-link" href="?page=' + (data.startPage) - 1 + '" aria-label="Previous">'
            content += '<span aria-hidden="true">&laquo;</span>'
            content += '</a>'
            content += '</li>'
        }
        for (let i = data.startPage; i <= data.endPage; i++) {
            console.log(data.currPage)
            if (data.currPage != i) {
                content += '<li class="page-item"><a className="page-link" href="?page=' + i + '">i</a></li>'
            } else {
                content += '<li class="page-item active"><a class="page-link">i</a></li>'
            }
        }
        if (data.totalPage != data.endPage) {
            content += '<li class="page-item">'
            content += '<a class="page-link" href="?page=' + (data.endPage) + 1 + '" aria-label="Next">'
            content += '<span aria-hidden="true">&raquo;</span>'
            content += '</a>'
            content += '</li>'
        }
        content += '</ul>'
        $('#paginations').empty();
        $('#paginations').prepend(content);
    }
</script>
</body>
</html>
