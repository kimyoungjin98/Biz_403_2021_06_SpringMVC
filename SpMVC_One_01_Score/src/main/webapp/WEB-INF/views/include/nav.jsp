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
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css">
<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

header {
	background-color: rgba(78, 75, 75, 0.342);
	padding: 40px;
	font-size: 30px;
	color: white;
	text-align: center;
}

nav {
	background-color: lightgray;
}

nav ul {
	display: flex;
	list-style: none;
	margin: 3px 5px;
}

nav li {
	font-size: 20px;
	margin: 5px;
	color: white;
	cursor: pointer;
}

div#nav {
	width: 100%;
}

div#main {
	display: flex;
	justify-content: center;
}

table {
	width: 70%;
	padding: 5px;
	text-align: center;
}

table td{
	padding:3px;
}

thead td {
	color: white;
	background-color: lightgray;
	border: 1px solid lightgray;
	
}

tbody td {
	color:rgba(0,0,0,0.6);
	border: 1px solid lightgray;
	
}

button {
	border: 1px solid lightgray;
	background-color: lightgray;
	cursor: pointer;
	color: white;
	padding: 5px;
	width: 100px;
}

button:hover {
	transition: 0.5s ease;
	background-color: rgba(85, 84, 84, 0.993);
}
</style>
<body>
	<div id="nav">
		<header>대한고교 성적처리 2021 V1</header>
		<nav>
			<ul>
				<li>HOME</li>
				<li>학생정보</li>
				<li>성적 일람표</li>
			</ul>
		</nav>
	</div>
</body>

<script>
document.querySelector("nav").addEventListener("click", (e)=>{
	let path = e.target.textContent;
	if(path === "HOME"){
		location.href="${rootPath}";
	}else if (path === "학생정보"){
		location.href="${rootPath}/student";
	}else if (path === "성적 일람표"){
		
	}
	
});
</script>
</html>