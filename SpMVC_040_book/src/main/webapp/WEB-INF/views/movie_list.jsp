<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<c:forEach items="${MOVIES}" var="MOVIE">
	<div class="content">
		<img src="${MOVIE.image}">
		<div>
			<p class="title">
				<a href="${MOVIE.link}" target="_NEW">${MOVIE.title}</a>
			</p>
			<p class="userRating">${MOVIE.userRating}</p>
			<p class="actor">
				<strong>배우 : </strong>${MOVIE.actor}</p>
			<p class="director">
				<strong>감독 : </strong>${MOVIE.director}</p>
			<button class="insert">내 서재등록</button>
		</div>
	</div>
</c:forEach>