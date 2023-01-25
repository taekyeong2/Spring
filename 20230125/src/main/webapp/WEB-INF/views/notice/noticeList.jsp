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
<div><h1>게시글 목록</h1></div>
<div>
	<c:forEach items="${notices }" var="n">
		${n.noticeWriter } : ${n.noticeTitle }<br>
	</c:forEach>
</div><br>
<div>
	<form id="frm" method="post">
		<div>
			<table>
				<tr>
					<td width="100">
						<select name="key" id="key">
							<option value="all">전체</option>
							<option value="title">제목</option>
							<option value="subject">내용</option>
							<option value="writer">작성자</option>							
							<option value="date">작성일자</option>							
						</select>
					</td>
					<td width="250">
						<input type="text" name="val" id="val">&nbsp;
						<input type="button" onclick="searchList()" value="검색"> 
					</td>
				</tr>
			</table>
	</form>
</div>
</div>
<script type="text/javascript">
function searchList() {
	let url = 'ajaxSearchList.do';
	let key = document.getElementById("key").value;
	let val = document.getElementById("val").value;
	
	let payload = 'key='+key+'&val='+val
	let data = {'key': key, 'val': val}
// 	fetch(url+"?key="+key+"&val="+val)
// 		 .then(response => response.json())
// 		 .then(data => console.log(data));

	fetch(url, {
		  method: 'POST',
		  headers: {
		    'Content-Type': 'application/x-www-form-urlencoded',
		  },
		  body: payload
		})
		.then((response) => response.json())
		.then((data) => {
		  console.log(data);
		  htmlConvert(data)
		})
}

function htmlConvert(data) {
	//여기서 화면에 처리하는 과정 작성
	
}
</script>
</body>
</html>