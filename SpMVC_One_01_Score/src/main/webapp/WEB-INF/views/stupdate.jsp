<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<style>
div#input {
	margin-left: 500px;
	margin: auto;
	display: flex;
	border-top: 1px solid rgba(0, 0, 0, 0.7);
	border: 1px solid rgba(0, 0, 0, 0.3);
	width: 400px;
	padding: 20px;
	align-items: center;
	flex-direction: column;
}

div#inputbox {
	margin: 100px;
}

label {
	font-size: 20px;
	margin: 70px 5px;
	color: rgba(0, 0, 0, 0.5);
}

input {
	border: 1px solid rgba(0, 0, 0, 0.3);
	outline: none;
	padding: 10px;
	margin: 10px;
	font-size: 20px;
}

div#btn {
	margin-left: 8px;
}

form{
	margin:20px auto;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<div id="input">
		<div id="inputbox">
		<label>학번 ${ST.st_num}</label> 
			<form method="post" onsubmit="return check()" name="frm">

				<label>이름<input name="name" value="${ST.st_name}" maxlength="5"></label> 
				<label>전공<input name="dept" value="${ST.st_dept}" maxlength="20"></label> 
				<label>학년<input name="grade" value="${ST.st_grade}" maxlength="1"></label> 
				<label>전화번호<input name="tel" value="${ST.st_tel}" maxlength="13"></label> 
				<label>주소<input name="addr" value="${ST.st_addr}" maxlength="125"></label>
		</div>
		<div id="btn">
			<button>전송</button>
		</div>
		</form>
	</div>
</body>
<script>
function check(){
	
	if(frm.name.value == ""){
		alert("이름을 입력하세요!!");
		frm.name.focus;
		return false;
	}
	if(frm.dept.value == ""){
		alert("전공을 입력하세요!!");
		frm.dept.focus;
		return false;
	} 
	if(frm.grade.value == ""){
		alert("학년을 입력하세요!!");
		frm.grade.focus;
		return false;
	} 
	if(frm.tel.value == ""){
		alert("전화번호를 입력하세요!!");
		frm.tel.focus;
		return false;
	} 
	
	
		return true;

}
	
</script>
</html>