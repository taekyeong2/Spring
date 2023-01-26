<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
</head>
<body>
<div align="center">
	<br><br>
	<div><h1>회 원 목 록</h1></div>
	<div>
		<table border="1" id="listTable">
			<thead>
				<tr>
					<td width="150" align="center">아이디</td>
					<td width="150" align="center">이 름</td>
					<td width="150" align="center">나 이</td>
					<td width="150" align="center">전화번호</td>
					<td width="250" align="center">주 소</td>
					<td width="150" align="center">권 한</td>
					<td width="150" align="center">수정</td>
					<td width="150" align="center">삭제</td>
				</tr>
			</thead>
			<tbody id="listTbody">
				<c:forEach items="${members }" var="m">
					<tr onmouseover="this.style.background='#fcecae'" 
						onmouseleave="this.style.background='#FFFFFF'">
					<td width="150" align="center">${m.memberId }</td>
					<td width="150" align="center">${m.memberName }</td>
					<td width="150" align="center">${m.memberAge }</td>
					<td width="150" align="center">${m.memberTel }</td>
					<td width="250" align="center">${m.memberAddress }</td>
					<td width="150" align="center">${m.memberAuthor }</td>
					<td width="150" align="center"><button type="button" onclick="modiInfo(event, '${m.memberId}')">수정</button></td>
					<td width="150" align="center"><button type="button" onclick="delInfo()">삭제</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div><br>
</div>
<script>
function modiInfo(e, m){
	//멤버셀렉트만들기
	$ajax({
		url:''
	})
// 	let tr = $(e.target).parent().parent()
// 	tr.replaceWith(
// 		$('<td>').text(m.memeberId),
// 		$('<td><input type="text" id="memberName" name="memberName"></td>')
// 	)
}
</script>
</body>
</html>