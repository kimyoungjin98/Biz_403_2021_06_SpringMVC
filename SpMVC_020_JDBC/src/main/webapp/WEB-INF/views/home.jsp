<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<body>

	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<section id="main_sec">
		<article>
			<h3>출판사</h3>
			<ul>
				<c:choose>
					<c:when test="${not empty COMPS}">
						<c:forEach var="index" begin="0" end="4">
							<li>${COMPS[index].cp_title},${COMPS[index].cp_ceo },
								${COMPS[index].cp_genre }</li>
						</c:forEach>
					</c:when>
				</c:choose>
			</ul>
		</article>
		<article>
			<h3>도서정보</h3>
			<ul>
				<li>도서정보</li>
				<li>도서정보</li>
				<li>도서정보</li>
				<li>도서정보</li>
				<li>도서정보</li>
			</ul>
		</article>
		<article>
			<h3>저자정보</h3>
			<ul>
				<c:choose>
					<c:when test="${not empty AUTHORS}">
						<c:forEach var="index" begin="0" end="4">
							<li>${AUTHORS[index].au_name},${AUTHORS[index].au_tel},</li>
						</c:forEach>
					</c:when>
				</c:choose>
			</ul>
		</article>
	</section>
	<section id="ad_sec">
		<article></article>
		<article></article>
		<article></article>
		<article></article>
		<article></article>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
</html>

