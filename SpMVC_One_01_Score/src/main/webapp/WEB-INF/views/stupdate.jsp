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
			<form method="post">

				<label>이름<input name="name"
					value="${ST.st_name}"></label> <label>전공<input name="dept"
					value="${ST.st_dept}"></label> <label>학년<input name="grade"
					value="${ST.st_grade}"></label> <label>전화번호<input
					name="tel" value="${ST.st_tel}"></label> <label>주소<input
					name="addr" value="${ST.st_addr}"></label>
		</div>
		<div id="btn">
			<button>전송</button>
		</div>
		</form>
	</div>
</body>
</html>