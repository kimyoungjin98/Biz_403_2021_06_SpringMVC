<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한고교 성적처리 시스템</title>
</head>
<style>
div#stList{
	margin-left: 400px;
    display: flex;
    justify-content: center;
    flex-direction: column;
}

button#insert{
	margin-left:6px;
}
	
</style>
<body>
<%@ include file="/WEB-INF/views/include/nav.jsp" %>
<div id="stList">
<table>
	<thead>
	<tr>
		<td>학번</td>
		<td>이름</td>
		<td>전공</td>
		<td>학년</td>
		<td>전화번호</td>
		<td>주소</td>
	</tr>
	</thead>
	
	
	<tbody>
	<c:forEach items="${STLIST}" var="ST">
		<tr data-num="${ST.st_num}">
			<td>${ST.st_num}</td>
			<td>${ST.st_name}</td>
			<td>${ST.st_dept}</td>
			<td>${ST.st_grade}</td>
			<td>${ST.st_tel}</td>
			<td>${ST.st_addr}</td>
		</tr>
		</c:forEach>
	</tbody>
	
</table>

<button id="insert">학생정보 입력</button>

</div>
</body>

<script>
document.querySelector("tbody").addEventListener("dblclick", (e)=>{
	
	let num = e.target.closest("TR").dataset.num
	
	location.href="${rootPath}/info?num=" + num;
	
});

document.querySelector("button#insert").addEventListener("click", ()=>{
	location.href="${rootPath}/student/insert";
});
</script>
</html>