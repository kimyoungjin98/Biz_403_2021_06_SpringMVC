<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보</title>
</head>
<body>
<table  data-num="${ST.st_num}">
	<thead>
	<tr>
		<td>학번</td>
		<td>이름</td>
		<td>전공</td>
		<td>학년</td>
	</tr>
	</thead>
	
	
	<tbody>
		<tr>
			<td>${ST.st_num}</td>
			<td>${ST.st_name}</td>
			<td>${ST.st_dept}</td>
			<td>${ST.st_grade}</td>
		</tr>
	</tbody>
	</table>
	
	<button id="update">학생정보 수정</button>
	
	<table>
	<thead>
	<tr>
		<td>학번</td>
		<td>과목</td>
		<td>점수</td>
	</tr>
	</thead>
	
	
	<tbody>
	<c:forEach items="${SCLIST}" var="SC">
		<tr>
			<td>${SC.sc_stnum}</td>
			<td>${SC.sc_subject}</td>
			<td>${SC.sc_score}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<button id="insert">성적 추가</button>
</body>
<script>
document.querySelector("BUTTON").addEventListener("click", ) (e)=>{
	
	let num = e.target.closest("TABLE").data.num;
	let id = e.target.id;
	
	if(id === "update"){
	
		location.href = "${rootPath}/score/update?num=";
		
	} else if (id === "insert"){
		
		location.href = "${rootPath}/student/insert?num=";	
	}
	
	
	
	
})
</script>
</html>