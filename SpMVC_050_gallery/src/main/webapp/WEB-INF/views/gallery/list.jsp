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
	div.ga_box{
		display:flex;
		flex-direction: column;
		border:1px solid white;
		overflow:hidden;
		color:white;
		text-shadow: 1px 1px 1px lightgray;
		margin:10px;
	}
	
	div.ga_box h3 a{
		color:white;
		text-shadow: 1px 1px 1px lightgray;
	}
	
	div.ga_box div:first-of-type {
	
		flex:1;
	}
	
	div.ga_box div:last-of-type {
		
		flex:3;
	
	}
	div.list_ct{
		display:flex;
		margin: 20px 100px;
		flex-wrap: wrap;
	}
	
	div.ga_box a{
		color:black;
	}
	
	
</style>
<body>
<div class="list_ct">
<c:forEach items="${GALLERYS}" var="GALLERY">

<div class="ga_box">
	<div>
		<img src="${rootPath}/files/${GALLERY.g_image}" width="400px">
	</div>
	
	<div class="box_text">
		<h3>
		<a href="${rootPath}/gallery/detail/${GALLERY.g_seq}">${GALLERY.g_subject}</a>
		</h3>
		<p>${GALLERY.g_content}</p>
	</div>
</div>

</c:forEach>
</div>

	
</body>
</html>