<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

section.content_box {
	border: 1px solid #2DB400;
	padding: 12px 16px;
	display: flex;
	flex-wrap: wrap;
}

section.content_box div.content {
	display: flex;
	border: 1px solid #2DB400;
	margin: 5px auto;
	width:30%;
	height:30vh;
	overflow:auto;
}

section.content_box div.content img {
	flex: 1;
	width:30%;
	height:80%;
}

section.content_box div.content div {
	flex: 2;
}

p b {
	font-weight: bold;
	color:blue;
}

nav#main_nav {
	background-color: #2DB400;
	display: flex;
	justify-content: center;
	align-items: center;
}

nav#main_nav form {
	margin: 0.6rem;
	width:50%;
}

nav#main_nav input{
	padding:8px;
	border:0;
	outline:0;
	width:100%;
}

@media(min-width:1000px) {
	section.content_box div.content{
		width:20%;
		margin:5px;
	}
}

@media(max-width:700px) {
	section.content_box div.content{
		width:95%;
	}
}

a {
	text-decoration: none;
}

a:hover {
	color: #2DB400;
}
</style>
</head>
<body>
	<nav id="main_nav">
		<form>
			<input name="search" placeholder="도서명을 입력후 Enter...">
		</form>
	</nav>
	<section class="content_box">
		<c:forEach items="${BOOKS}" var="BOOK">
			<div class="content">
				<img src="${BOOK.image}">
				<div>
					<p class="title">
						<a href="${BOOK.link}" target="_NEW">${BOOK.title}</a>
					</p>
					<p class="desc">${BOOK.description}</p>
					<p class="author">
						<strong>저자 : </strong>${BOOK.author}</p>
					<p class="publisher">
						<strong>출판사 : </strong>${BOOK.publisher}</p>
						<button class="insert">내 서재등록</button>
				</div>
			</div>
		</c:forEach>
	</section>

	<script>
document.querySelector("button").addEventListener("click", (e)=>{
	
	let search = document.querySelector("input[name='search']").value
	let st_name = document.querySelector("input[name='st_name']").value
	
	// 서버로 fetch(ajax)로 전송하기
	// 1. JSON 데이터로 만들기
	
	let json = {search : search, st_name};
	
	// JSON type의 데이터를 ajax로 전송하기 위한 문자열 화
	// Serialize 라고 한다
	let jsonString = JSON.stringify(json);
	
	alert(jsonString)
	
	fetch("${rootPath}/api",{
		method:"POST",
		body : jsonString,
		headers : {
			"content-Type" : "application/json"
		}
		
	})
	
})	
</script>
</body>
</html>