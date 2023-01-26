<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<body>
<div align="center">
	<div><h1>회원가입</h1></div>
	<div>
		<form id="frm" action="memberJoin.do" method="post">
			<table>
			<tr>
				<th>아이디*</th>
				<td>
					<input type="text" id="memberId" name="memberId" onchange="idck()">
				</td>
			</tr>
			<tr>
				<th>비밀번호*</th>
				<td>
					<input type="password" id="memberPassword" name="memberPassword">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인*</th>
				<td>
					<input type="password" id="memberpwck" name="memberpwck" onchange="pwck()">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" id="memberName" name="memberName">
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<input type="text" id="memberAge" name="memberAge">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" id="memberAddress" name="memberAddress">
				</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>
					<input type="text" id="memberTel" name="memberTel">
				</td>
			</tr>
			</table>
			<input type="submit" value="회원가입">
			<input type="button" value="뒤로가기" onclick="location.href='home.do'">
		</form>
	</div>
</div>
<script type="text/javascript">
	function idck(){
		$.ajax({
			url:'ajaxList.do',
			dataType: 'json',
			success: function(res){
				console.log(res)
				res.forEach(e=>{
					console.log(e.memberId)
					if($('#memberId').val() == e.memberId){
						alert('중복된 아이디입니다.')
						$('#memberId').val('')
						$('#memberId').focus();
					}
				})
			},
			error: function(err){
				console.log(err)
			}
		})
	}
	
	function pwck(){
		console.log($('#memberPassword').val())
		if($('#memberPassword').val() != $('#memberpwck').val()){
			alert('입력된 패스워드와 일치하지 않습니다.')
			$('#memberpwck').val('')
			$('#memberpwck').focus();
		}
	}
</script>
</body>
</html>