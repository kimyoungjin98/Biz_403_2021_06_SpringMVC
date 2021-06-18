<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<body>
	<form method="post">
		<label>학번 "${num}"</label>
		<label>이름<input value="${SC.sc_name}"></label>
		<label>전공<input value="${SC.sc_dept}"></label>
		<label>학년<input value="${SC.sc_grade}"></label>
		
		<button>전송</button>
	</form>
</body>
</html>
