<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${notice.noticeWriter }</td>
			<th>날짜</th>
			<td>${notice.noticeDate }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${notice.noticeTitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<c:if test="${not empty notice.noticeFile }">
					<img src="resources/upload/${notice.noticeFileDir }" alt="게시글 사진" style="width: 500px; height: 500px;"><br>
				</c:if>
				<pre>${notice.noticeSubject }</pre>
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">${notice.noticeFile }</td>
		</tr>
	</table>
	<div>
		<form id="hiddenFrm" method="post">
			<input type="hidden" id="noticeId" name="noticeId" value=${notice.noticeId }>
		</form>
		<c:if test="${name eq notice.noticeWriter }">
			<button type="button" onclick="noticeModi('A')">수정하기</button>
			<button type="button" onclick="noticeModi('B')">삭제하기</button>
			<button type="button" onclick="noticeModi('C')">뒤로가기</button>
		</c:if>
	</div>
</div>
<script>
function noticeModi(n){
	if(n == 'A'){
		hiddenFrm.action = "noticeUpdateForm.do"
		hiddenFrm.submit();
	}else if(n== 'B'){
		let chk = confirm('삭제하시겠습니까?')
		if(chk){
		hiddenFrm.action = "noticeDelete.do"
		hiddenFrm.submit();
		}else{
			return false;
		}
	}else if(n== 'C'){
		hiddenFrm.action = "noticeList.do"
		hiddenFrm.submit();
	}
}
</script>
</html>