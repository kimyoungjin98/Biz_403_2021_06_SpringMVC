<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보</title>
</head>
<style>
	div#info{
	
	margin-left: 400px;
    display: flex;
    justify-content: center;
    flex-direction: column;
	
	}
	
	div#info button{
		margin-left:6px;
	}
	
	tbody#score tr{
		cursor:pointer;
	}
	
</style>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<div id="info">
		<div>
			<table>
				<thead>
					<tr>
						<td>학번</td>
						<td>이름</td>
						<td>전공</td>
						<td>학년</td>
					</tr>
				</thead>


				<tbody id="student">
					<tr data-num="${ST.st_num}">
						<td>${ST.st_num}</td>
						<td>${ST.st_name}</td>
						<td>${ST.st_dept}</td>
						<td>${ST.st_grade}</td>
					</tr>
				</tbody>
			</table>

			<button id="update" data-num="${ST.st_num}">학생정보 수정</button>
			<button id="tDelete" data-num="${ST.st_num}">학생정보 삭제</button>
		</div>

		<div>
			<table>
				<thead>
					<tr>
						<td>No.</td>
						<td>과목</td>
						<td>점수</td>
					</tr>
				</thead>


				<tbody id="score">
					<c:forEach items="${SCLIST}" var="SC">
						<tr data-seq="${SC.sc_seq}">
							<td>${SC.sc_seq}</td>
							<td>${SC.sc_subject}</td>
							<td>${SC.sc_score}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button id="insert" data-num="${ST.st_num}">성적 추가</button>
		</div>
	</div>
</body>
<script>
document.querySelector("tbody#score").addEventListener("dblclick", (e)=>{
	
	
	
	let seq = e.target.closest("TR").dataset.seq;
	
	if(!confirm("데이터를 삭제하시겠습니까?")){
		
	} else {
		alert("데이터를 삭제합니다");
		location.href = "${rootPath}/score/delete?seq=" + seq;
	}
	
});

document.querySelector("div#info").addEventListener("click", (e)=>{
	
	let para = window.location.search;
	let id = e.target.id;
	
	if(id === "update"){
		location.href = "${rootPath}/student/update" + para;
	} else if (id === "insert"){
		location.href = "${rootPath}/score/insert" + para;	
	} else if (id === "tDelete"){
		location.href = "${rootPath}/student/delete" + para;	
	}
	
});
</script>
</html>