<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한고교 성적처리 시스템</title>
</head>
<style>
#home tbody tr {
	cursor: pointer;
}


button#insert{
	margin-left:294px;
}

a{
	color:rgba(0,0,0,0.6);
	margin-left:300px;
}
</style>
<body>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	
		<a>* 정보를 더블클릭 하세요</a>
	<div>
		<div id="main">
			<table id="home">
				<thead>
					<tr>
						<td>학번</td>
						<td>이름</td>
						<td>전공</td>
						<td>학년</td>
						<td>응시과목</td>
						<td>총점</td>
						<td>평균</td>
					</tr>
				</thead>


				<tbody>
					<c:forEach items="${sList}" var="SD">
						<tr data-num="${SD.v_num}">
							<td>${SD.v_num}</td>
							<td>${SD.v_name}</td>
							<td>${SD.v_dept}</td>
							<td>${SD.v_grade}</td>
							<td>${SD.v_subject}</td>
							<td>${SD.v_sum}</td>
							<td>${SD.v_avg}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		
		</div>
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