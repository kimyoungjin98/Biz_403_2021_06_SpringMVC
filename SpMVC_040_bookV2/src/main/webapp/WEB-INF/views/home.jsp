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

body {
	display: flex;
	flex-direction: column;
	height: 100vh;
}

section.content_box {
	flex: 1;
	overflow: auto;
	border: 1px solid #2DB400;
	padding: 12px 16px;
	display: flex;
	flex-wrap: wrap;
}

section.content_box div.content {
	display: flex;
	border: 1px solid #2DB400;
	margin: 5px auto;
	width: 30%;
	height: 30vh;
	overflow: auto;
}

section.content_box div.content img {
	flex: 1;
	width: 30%;
	height: 80%;
}

section.content_box div.content div {
	flex: 2;
}

p b {
	font-weight: bold;
	color: blue;
}

nav#main_nav {
	background-color: #2DB400;
	display: flex;
	justify-content: center;
	align-items: center;
}

nav#main_nav form {
	margin: 0.6rem;
	width: 50%;
}

nav#main_nav input {
	padding: 8px;
	border: 0;
	outline: 0;
	width: 100%;
}

nav#main_nav select {
	outline: none;
	padding: 8px;
	margin-left: auto;
}

@media ( min-width :1000px) {
	section.content_box div.content {
		width: 20%;
		margin: 5px;
	}
}

@media ( max-width :700px) {
	section.content_box div.content {
		width: 95%;
	}
}

a {
	text-decoration: none;
}

a:hover {
	color: #2DB400;
}

table{
	width:95%;
	border-collapse: collapse;
	border-spacing: 0;
}

/* 전체적으로 th와 td의 위쪽만 선을 만들고 */
th, td{
	white-space: nowrap;
	padding:16px 12px;
	border-top: 1px solid #ddd;
}
/* 가장 끝에 나타난 td에는 아래쪽에도 선을 만들기 */
tr:last-child td{
	border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
	<nav id="main_nav">
	<c:if test="${CAT == 'BOOK'}">
		<c:set var="pHolder" value="도서 검색어"/>
	</c:if>
	<c:if test="${CAT == 'MOVIE'}">
		<c:set var="pHolder" value="영화 검색어"/>
	</c:if>
	<c:if test="${CAT == 'NEWS'}">
		<c:set var="pHolder" value="뉴스 검색어"/>
	</c:if>
		<select name="category">
			<option value="BOOK"
				<c:if test="${CAT == 'BOOK'}">selected=selected</c:if>>도서검색</option>
			<option value="MOVIE"
				<c:if test="${CAT == 'MOVIE'}">selected=selected</c:if>>영화검색</option>
			<option value="NEWS"
				<c:if test="${CAT == 'NEWS'}">selected=selected</c:if>>뉴스검색</option>
		</select>
		<form>
			<input name="search" placeholder="${pHolder}를 입력후 Enter...">
		</form>
	</nav>
	<section class="content_box">
		<%@ include file="/WEB-INF/views/book_list.jsp"%>
		<%@ include file="/WEB-INF/views/movie_list.jsp"%>
		<%@ include file="/WEB-INF/views/news_list.jsp"%>
		
		<c:if test="${not empty MY_BOOKS}">
			<%@ include file="/WEB-INF/views/book/list_view.jsp" %>
		</c:if>
		
	</section>

	<script>
let category = document.querySelector("select[name='category']")
category.addEventListener("change",(e)=>{
	
	let value = category.value
	
	// location.href="${rootPath}/?category=" + value;
	location.href="${rootPath}/naver/" + value;
})
</script>
</body>
</html>