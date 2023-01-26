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
	<form id="frm" method="post" action="noticeInsert.do" enctype="multipart/form-data">
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" id="noticeWriter" name ="noticeWriter" value="${name }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="noticeTitle" name ="noticeTitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="50" rows="10" id="noticeSubject" name ="noticeSubject"></textarea></td>
			</tr>
			<tr>
				<th>파일</th>
				<td><input type="file" id="file" name ="file"></td>
			</tr>
		</table><br>
		<div>
		<input type="submit" value="글작성">
		<button type="button" onclick="location.href='noticeList.do'">뒤로가기</button>
		</div>
	</form>
</div>
</body>
</html>