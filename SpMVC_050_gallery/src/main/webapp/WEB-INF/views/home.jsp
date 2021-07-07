<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
@font-face {
	font-family: 'NEXON Lv1 Gothic OTF';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'NEXON Lv1 Gothic OTF';
}

header {
	text-align: center;
	color: linear-gradient(-45deg, #ebbba7, #cfc7f8, #e9defa, #fbfcdb);
	animation: AnimationName 15s ease infinite;
	color:white;
	text-shadow:1px 1px 1px gray;
	font-size:40px;
	padding: 10px;
	margin:200px;
}

button {
	border: 1px solid gray;
	outlone: none;
	cursor: pointer;
	background-color: white;
	color: gray;
}

button:hover {
	background-color: black;
	transition: 0.3s ease;
	color: white;
}

a {
	text-decoration: none;
}

a#insert {
	color: white;
	text-shadow:1px 1px 1px lightgray;
	font-size: 20px;
	margin-left: auto;
	position: relative;
	left: 110px;
}

a#insert:hover {
	transition: 0.3s ease;
	color: linear-gradient(to right, gray, lightgray);
}

body {
	background: linear-gradient(-45deg, #ebbba7, #cfc7f8, #e9defa, #fbfcdb);
	background-size: 800% 800%;
	animation: AnimationName 15s ease infinite;
	width:100%
}

@-webkit-keyframes AnimationName { 0%{background-position:0% 50%} 50%{background-position:100% 50%} 100%{background-position:0% 50%} }

input {
	outlone: none;
}

div#input {
	display: flex;
	flex-direction: column;
	font-size: 15px;
}

a#insert:hover ~ .home_header {

	background-color: black;

}

</style>
<body>
	<header class="home_header">
		<h1>GALLERY</h1>
	</header>


		<c:choose>
			<c:when test="${BODY == 'GA-INPUT' }">
				<%@ include file="/WEB-INF/views/gallery/input.jsp"%>
			</c:when>
			<c:when test="${BODY == 'GA-LIST' }">
			<a href="${rootPath}/gallery/input" id="insert">이미지 등록</a>
				<%@ include file="/WEB-INF/views/gallery/list.jsp"%>
			</c:when>
			<c:when test="${BODY == 'GA-DETAIL' }">
				<%@ include file="/WEB-INF/views/gallery/detail.jsp"%>
				<a href="${rootPath}/gallery">리스트로</a>
			</c:when>
			<c:otherwise>

				<a href="${rootPath}/gallery/input" id="insert">이미지 등록</a>

			</c:otherwise>

		</c:choose>
	

	<c:forEach items="${FILES}" var="FILE">

		<a href="${rootPath}/files/${FILE}" target="_NEW"> <img
			src="${rootPath}/files/${FILE}" width="200px" height="200px" />
		</a>


	</c:forEach>

</body>
</html>