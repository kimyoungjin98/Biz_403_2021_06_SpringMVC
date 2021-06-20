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
	width: 40%;
	padding: 20px;
	align-items: center;
	flex-direction: column;
}

div#inputbox {
	margin: 20px;
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
	font-size:20px;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<div id="input">
		<div id="inputbox">
			<form method="post" name="form" id="score"  onsubmit="return check()">
				<label>학번 : ${ST.st_num}</label> 
				<label>이름 : ${ST.st_name}</label>
				<div>
					<label>과목<input name="sub" maxlength="2"></label> 
					<label>점수<input
						name="score" maxlength="3"></label>
				</div>
		</div>
		<div id="button">
			<button>전송</button>
		</div>
		</form>
	</div>
</body>
<script>
function check(){
	
	if(form.sub.value == ""){
		alert("과목을 입력하세요!!");
		form.sub.focus;
		return false;
	} 
	if (form.score.value == ""){
		alert("점수를 입력하세요!!")
		form.score.focus;
		return false;
	}
		return true;

}
	
</script>
</html>
