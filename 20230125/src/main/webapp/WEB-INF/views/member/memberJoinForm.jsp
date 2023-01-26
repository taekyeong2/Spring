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
		<form id="frm" action="memberJoin.do" method="post" onsubmit="return joinMem()">
			<table>
			<tr>
				<th>아이디*</th>
				<td>
					<input type="text" id="memberId" name="memberId" required>
					<button type="button" id="btn" onclick="idCk()" value="no">중복체크</button>
				</td>
			</tr>
			<tr>
				<th>비밀번호*</th>
				<td>
					<input type="password" id="memberPassword" name="memberPassword" required> 
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인*</th>
				<td>
					<input type="password" id="memberpwck" name="memberpwck" onchange="pwck()" required>
				</td>
			</tr>
			<tr>
				<th>이름*</th>
				<td>
					<input type="text" id="memberName" name="memberName" required>
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
	function joinMem(){
		if($('#memberAge').val()== ''){
			$('#memberAge').val(0)
		}
		frm.submit();
	}

	function idCk(){
		$.ajax({
			url:'ajaxIdCheck.do',
			data:{memberId : $('#memberId').val()},
			dataType: 'json',
			success: function(res){
				console.log(res)
				let td = $('table tr:eq(0)').find('td')
				if($('#memberId').val()==''){
					td.find('p').remove();
					td.append(
						$('<p>').text('아이디값을 입력해주세요')
					)
				}else{
					if(res){
						td.find('p').remove();
						td.append(
								$('<p>').text('사용가능한 아이디입니다.')
							)
						$('#btn').val('yes').prop('disabled', true);
						          
					}else{
						td.find('p').remove();
						td.append(
								$('<p>').text('중복된 아이디입니다.')
							)
						$('#memberId').val('')
					}
				}


			},
			error: function(err){
				console.log(err)
			}
		})
	}
	
	function pwck(){
		let td = $('table tr:eq(2)').find('td')
		console.log(td)
		if($('#memberPassword').val() != $('#memberpwck').val()){
			td.append(
					$('<p>').text('입력된 패스워드와 일치하지 않습니다.')
				)
			
		}else{
			td.find('p').remove();
		}
	}
	
	function joinMem(){
		if($('#memberAge').val()==''){
			$('#memberAge').val(0)
		}
		if($('#btn').val()=='yes'){
			if($('#memberPassword').val() == $('#memberpwck').val()){
				return true;
			}else{
				alert('패스워드 확인을 해주세요')
				return false;
			}
		}else{
			alert('아이디 중복체크를 해주세요')
			return false;
		}
	}
</script>
</body>
</html>