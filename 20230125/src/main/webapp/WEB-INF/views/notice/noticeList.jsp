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
</div><br>
<div>
	<table border="1" style="text-align: center" id="table">
		<thead>
			<tr>
				<th width="100">순번</th>
				<th width="150">작성자</th>
				<th width="500">제목</th>
				<th width="150">작성일자</th>
				<th width="100">조회수</th>
				<th width="100">첨부파일</th>
			</tr>
		</thead>
		<tbody id="tbdy">
			<c:forEach items="${notices }" var="n">
				<tr onmouseover="this.style.background='#fcecae'"
				    onmouseleave="this.style.background='#ffffff'"
				    onclick="noticeSel(${n.noticeId })">
					<td>${n.noticeId }</td>
					<td>${n.noticeWriter }</td>
					<td>${n.noticeTitle }</td>
					<td>${n.noticeDate }</td>
					<td>${n.noticeHit }</td>
					<td>
						<c:if test="${not empty n.noticeFile }">
							🤍			
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div><br>
<div>
	<c:if test="${not empty id }">
		<button type="button" onclick="location.href='noticeInsertForm.do'">글쓰기</button>
	</c:if>
</div>
<div>
	<form id="hiddenFrm" action="noticeSelect.do" method="post">
		<input type="hidden" name="noticeId" id="noticeId">
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

function htmlConvert(datas) {
	//여기서 화면에 처리하는 과정 작성
	document.querySelector('#tbdy').remove();
	const container = document.createElement('tbody');
	container.id="tbdy"
	container.innerHTML = datas.map(data => createHTMLString(data)).join("")
	document.querySelector('#table').append(container)
}

function createHTMLString(data){
	if(data.noticeFile == null){
		data.noticeFile = ''
	}else{
		data.noticeFile = '🤍'
	}
	
	let str = "<tr onmouseover=this.style.background='#fcecae';"
		str += " onmouseleave=this.style.background='#ffffff';"
		str += " onclick=noticeSel('"+ data.noticeId +"')";
		str += "noticeSel('"+ data.noticeId +"')"+">";
		str += "<td align=center>" + data.noticeId+"</td>";
		str += "<td align=center>" + data.noticeWriter + "</td>";
		str += "<td>" + data.noticeTitle + "</td>";
		str += "<td align=center>" + data.noticeDate + "</td>";
		str += "<td align=center>" + data.noticeHit + "</td>";
		str += "<td align=center>" + data.noticeFile + "</td></tr>";
	return str;
}

function noticeSel(n){
	//여기에 상세보기 호출하기
	document.getElementById("noticeId").value = n;
	hiddenFrm.submit();
	
}
</script>
</body>
</html>