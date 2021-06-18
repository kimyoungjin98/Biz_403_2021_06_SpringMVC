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
	
		<label>학번 </label>
		<label>과목<input></label>
		<label>점수<input></label>
		<label>총점<input></label>
		
		<button>전송</button>
	</form>
</body>
</html>