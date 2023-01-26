<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<form id="frm" method="post" action="noticeUpdate.do" enctype="multipart/form-data">
	<input type="hidden" name="noticeId" value="${notice.noticeId}">
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" id="noticeWriter" name ="noticeWriter" value="${name }" readonly></td>
				
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="noticeTitle" name ="noticeTitle" value="${notice.noticeTitle }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="50" rows="10" id="noticeSubject" name ="noticeSubject">${notice.noticeSubject }</textarea></td>
			</tr>
			<tr>
				<th>파일</th>
				<td><input type="file" id="file" name ="file"></td>
			</tr>
		</table><br>
	</form>
	<form method="post" id="hiddenFrm" action="noticeSelect.do">
		<input type="hidden" name="noticeId" value="${notice.noticeId}">
	</form>
		<div>
		<button type="button" onclick="noticeSelect('A')">수정</button>
		<button type="button" onclick="noticeSelect('B')">뒤로가기</button>
		</div>
</div>
<script>
function noticeSelect(n){
	if(n == 'A'){
		frm.submit()
	}else if(n == 'B'){		
		hiddenFrm.submit()
	}
}
</script>
</body>
</html>