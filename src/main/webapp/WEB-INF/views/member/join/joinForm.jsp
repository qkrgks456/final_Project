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
                <input name="name" type="text" class="form-control" id="id" placeholder="필수정보 입니다">
                <div class="invalid-feedback">Please enter a message in the textarea.</div>
                <a class="btn btn-warning btn-sm mt-2">중복확인</a>
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
<script>

    var code = "";				//이메일전송 인증번호 저장위한 코드

    /* 유효성 검사 통과유무 변수 */
    var idCheck = false;			// 아이디
    var idckCheck = false;			// 아이디 중복 검사
    var pwCheck = false;			// 비번
    var pwckCheck = false;			// 비번 확인
    var pwckcorCheck = false;		// 비번 확인 일치 확인
    var nameCheck = false;			// 이름
    var mailCheck = false;			// 이메일
    var mailnumCheck = false;		// 이메일 인증번호 확인
    var addressCheck = false 		// 주소

    $(document).ready(function () {
        //회원가입 버튼(회원가입 기능 작동)
        $(".join_button").click(function () {

            /* 입력값 변수 */
            var id = $('.id_input').val(); 				// id 입력란
            var pw = $('.pw_input').val();				// 비밀번호 입력란
            var pwck = $('.pwck_input').val();			// 비밀번호 확인 입력란
            var name = $('.user_input').val();			// 이름 입력란
            var mail = $('.mail_input').val();			// 이메일 입력란
            var addr = $('.address_input_3').val();		// 주소 입력란

            /* 아이디 유효성검사 */
            if (id == "") {
                $('.final_id_ck').css('display', 'block');
                idCheck = false;
            } else {
                $('.final_id_ck').css('display', 'none');
                idCheck = true;
            }

            /* 비밀번호 유효성 검사 */
            if (pw == "") {
                $('.final_pw_ck').css('display', 'block');
                pwCheck = false;
            } else {
                $('.final_pw_ck').css('display', 'none');
                pwCheck = true;
            }

            /* 비밀번호 확인 유효성 검사 */
            if (pwck == "") {
                $('.final_pwck_ck').css('display', 'block');
                pwckCheck = false;
            } else {
                $('.final_pwck_ck').css('display', 'none');
                pwckCheck = true;
            }

            /* 이름 유효성 검사 */
            if (name == "") {
                $('.final_name_ck').css('display', 'block');
                nameCheck = false;
            } else {
                $('.final_name_ck').css('display', 'none');
                nameCheck = true;
            }

            /* 이메일 유효성 검사 */
            if (mail == "") {
                $('.final_mail_ck').css('display', 'block');
                mailCheck = false;
            } else {
                $('.final_mail_ck').css('display', 'none');
                mailCheck = true;
            }

            /* 주소 유효성 검사 */
            if (addr == "") {
                $('.final_addr_ck').css('display', 'block');
                addressCheck = false;
            } else {
                $('.final_addr_ck').css('display', 'none');
                addressCheck = true;
            }

            /* 최종 유효성 검사 */
            if (idCheck && idckCheck && pwCheck && pwckCheck && pwckcorCheck && nameCheck && mailCheck && mailnumCheck && addressCheck) {
                $("#join_form").attr("action", "/member/join");
                $("#join_form").submit();
            }
            return false;

        });
    });

    //아이디 중복검사
    $('.id_input').on("propertychange change keyup paste input", function () {

        /* console.log("keyup 테스트"); */

        var memberId = $('.id_input').val();			// .id_input에 입력되는 값
        var data = {memberId: memberId}				// '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'

        $.ajax({
            type: "post",
            url: "/member/memberIdChk",
            data: data,
            success: function (result) {
                // console.log("성공 여부" + result);
                if (result != 'fail') {
                    $('.id_input_re_1').css("display", "inline-block");
                    $('.id_input_re_2').css("display", "none");
                    idckCheck = true;
                } else {
                    $('.id_input_re_2').css("display", "inline-block");
                    $('.id_input_re_1').css("display", "none");
                    idckCheck = false;
                }
            }// success 종료
        }); // ajax 종료

    });// function 종료

    /* 인증번호 이메일 전송 */
    $(".mail_check_button").click(function () {

        var email = $(".mail_input").val();			// 입력한 이메일
        var cehckBox = $(".mail_check_input");		// 인증번호 입력란
        var boxWrap = $(".mail_check_input_box");	// 인증번호 입력란 박스
        var warnMsg = $(".mail_input_box_warn");	// 이메일 입력 경고글

        /* 이메일 형식 유효성 검사 */
        if (mailFormCheck(email)) {
            warnMsg.html("이메일이 전송 되었습니다. 이메일을 확인해주세요.");
            warnMsg.css("display", "inline-block");
        } else {
            warnMsg.html("올바르지 못한 이메일 형식입니다.");
            warnMsg.css("display", "inline-block");
            return false;
        }

        $.ajax({

            type: "GET",
            url: "mailCheck?email=" + email,
            success: function (data) {

                //console.log("data : " + data);
                cehckBox.attr("disabled", false);
                boxWrap.attr("id", "mail_check_input_box_true");
                code = data;

            }

        });

    });

    /* 인증번호 비교 */
    $(".mail_check_input").blur(function () {

        var inputCode = $(".mail_check_input").val();		// 입력코드
        var checkResult = $("#mail_check_input_box_warn");	// 비교 결과

        if (inputCode == code) {							// 일치할 경우
            checkResult.html("인증번호가 일치합니다.");
            checkResult.attr("class", "correct");
            mailnumCheck = true;
        } else {											// 일치하지 않을 경우
            checkResult.html("인증번호를 다시 확인해주세요.");
            checkResult.attr("class", "incorrect");
            mailnumCheck = false;
        }

    });

    /* 다음 주소 연동 */
    function execution_daum_address() {

        new daum.Postcode({
            oncomplete: function (data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if (data.userSelectedType === 'R') {
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraAddr !== '') {
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 주소변수 문자열과 참고항목 문자열 합치기
                    addr += extraAddr;

                } else {
                    addr += ' ';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                $(".address_input_1").val(data.zonecode);
                //$("[name=memberAddr1]").val(data.zonecode);	// 대체가능
                $(".address_input_2").val(addr);
                //$("[name=memberAddr2]").val(addr);			// 대체가능
                // 상세주소 입력란 disabled 속성 변경 및 커서를 상세주소 필드로 이동한다.
                $(".address_input_3").attr("readonly", false);
                $(".address_input_3").focus();

            }
        }).open();

    }

    /* 비밀번호 확인 일치 유효성 검사 */

    $('.pwck_input').on("propertychange change keyup paste input", function () {

        var pw = $('.pw_input').val();
        var pwck = $('.pwck_input').val();
        $('.final_pwck_ck').css('display', 'none');

        if (pw == pwck) {
            $('.pwck_input_re_1').css('display', 'block');
            $('.pwck_input_re_2').css('display', 'none');
            pwckcorCheck = true;
        } else {
            $('.pwck_input_re_1').css('display', 'none');
            $('.pwck_input_re_2').css('display', 'block');
            pwckcorCheck = false;
        }


    });


    /* 입력 이메일 형식 유효성 검사 */
    function mailFormCheck(email) {
        var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
        return form.test(email);
    }

</script>
</body>
</html>
