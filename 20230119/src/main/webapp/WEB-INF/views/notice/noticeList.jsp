<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message }</h1>
<!-- noticeId가 vo의 변수명과 같으니 자동으로 들어간다 -->
<a href="noticeSelect.do?noticeId=18">게시글 상세조회</a><br>  
<c:forEach items="${list }" var="l">
${l.noticeWriter } : ${l.noticeTitle } : ${l.noticeDate }<br>
</c:forEach>
</body>
</html>