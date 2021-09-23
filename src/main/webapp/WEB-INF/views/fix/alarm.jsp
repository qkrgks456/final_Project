<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script src="${path}/resources/js/bootstrap.bundle.js"></script>
<script>
$('.toast').hide();
</script>
<div class="toast-container">
<div class="toast position-fixed bottom-0 end-0 mb-3 me-3" role="alert"	aria-live="assertive" aria-atomic="true">
	<!-- <div class="d-flex">
		<div class="toast-body" id="body">내용</div>
		<button id="alarmClose" type="button" class="btn-close me-2 m-auto"
			data-bs-dismiss="toast" aria-label="Close"></button>
	</div> -->
</div>
</div>




<%-- <script src="${path}/resources/js/common.js?var=1"></script> --%>

<script>
var loginId = '<%=(String) session.getAttribute("loginId")%>';

var readInterval = setInterval(alarmRead, 3000);
//#alarmClose
$('.btn-close').on("click", function () {
    $('.toast').hide(300);
})

$('.toast').on("click", function () {
	clearInterval(readInterval);
	alarmDetail();
	$('.toast').show();
})

	if (loginId !== "null") {
		alarmRead();
		$('.toast').show();
	} else{
		$('.toast').hide();
	}

	function alarmRead() {
		$.ajax({
			url : "alarm/read",
			type : 'post',
			data : {
				"loginId" : loginId
			},
			dataType : 'json',
			success : function(data) {
				//console.log(data);
				if(data.alarmTotal=="0"){
				$('.toast').empty();
				}else{
					
				print(data);
				}
			},
			error : function(error) {
				console.log(error);
			}
		});
	}
	
	function alarmDetail() {
		$.ajax({
			url : "alarm/detail",
			type : 'post',
			data : {
				"loginId" : loginId
			},
			dataType : 'json',
			success : function(data) {
				//console.log(data);
				$('.toast').empty();
				printDetail(data.list); 
			},
			error : function(error) {
				console.log(error);
			}
		});
	}

	function print(data) {
		var content = '<div class="d-flex"><div class="toast-body" id="body">총 '	+ data.alarmTotal + ' 건의 알람이 있습니다.</div>';
		content += '<button id="alarmClose" type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button></div>';
		$('.toast').empty();
		$('.toast').append(content);
	}
	
	function printDetail(data){
		console.log(data);
		content1 = "";
		for (var i = 0; i < data.length; i++) {
		content1 +='<div class="d-flex"><div class="toast-body" id="body'+[i]+'">';
		content1 += '<a onclick="update('+data[i].alarmNum+')"';
		
		//게시판 구분
		if(data[i].division =='notice'){
		content1 += 'href="serviceCenter/noticeDetail/'+data[i].divisionNum+'">';
		}
		
		
		//댓글 좋아요 구분
		 if(data[i].content == "cm"){
			content1 += data[i].id+' 님이 게시글에 댓글을 달았습니다.';
		}else{
			content1 += data[i].id+' 님이 게시글에 좋아요를 눌렀습니다.';
		} 
		content1 += '</a></div><button id="alarmClose" type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button></div>';
		}
		
		$('.toast').append(content1);
		console.log(content1);
	}
	
	function update(data){
		$.ajax({
			url : "alarm/update",
			type : 'post',
			data : {
				"alarmNum" : data
			},
			dataType : 'json',
			success : function(data) {
				console.log(data);
				console.log("알림확인");
				readInterval = setInterval(alarmRead, 3000);
			},
			error : function(error) {
				console.log(error);
			}
		});
		
	}
			
	
</script>