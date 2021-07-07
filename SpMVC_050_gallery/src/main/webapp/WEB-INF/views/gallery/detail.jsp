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
	div#gallery_files{
		display:flex;
		flex-wrap:wrap;	
	}
	div#gallery_files img {
		margin: 2px;
	}

	div.detail{
		display:flex;
		flex-direction: column;
		background-color: white;
	}
	
	div#gallery_info{
		font-size: 15px;
	}
</style>
<body>
	<div class="detail">
	<div id="gallery_info">
		<h3> 제목 : ${GFLIST[0].g_subject}</h3>
		<p> 작성자 : ${GFLIST[0].g_writer}</p>
		<p> 작성일 : ${GFLIST[0].g_date}</p>
		<p> 작성시각: ${GFLIST[0].g_time}</p>
		<p> 내용 : ${GFLIST[0].g_content}</p>
		
	</div>
	
	<div id="galley_files">
		<c:forEach items="${GFLIST}" var="FILE">
			<img src="${rootPath}/files/${FILE.f_upname}" height="100px">
		</c:forEach>
	</div>
	</div>
</body>
</html>