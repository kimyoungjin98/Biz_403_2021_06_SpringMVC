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
	td.book_title{
		width:20%;
		max-width:0;
		text-overflow: ellipsis;
		overflow:hidden;
	}
	
	td img {
	padding:0.5rem;
	border:1px solid lightgray;
	width:50px;
	height:50px;
	
	}
</style>
</head>
	<h1>나의 서재</h1>
		<table>
			<tr>
				<th>ISBN</th>
				<th>도서명</th>
				<th>이미지</th>
				<th>출판사</th>
				<th>저자</th>
				<th>출판일</th>
			</tr>
			<c:choose>
				<c:when test="${empty MY_BOOKS}">
					<tr>
						<td colspan="6">데이터 없음</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${MY_BOOKS}" var="BOOK" varStatus="i">
						<tr>
							<td>${BOOK.isbn}</td>
							<td class="book_title">${BOOK.title}</td>
							<td><img width="50px" src="${BOOK.image}" alt="${BOOK.title}"/></td>
							<td>${BOOK.publisher}</td>
							<td>${BOOK.author}</td>
							<td>${BOOK.pubdate}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
<script>
let my_books = document.querySelector("table#my_books")
if(my_books){
	
	my_books.addEventListener("click", ()=>{
		
		let td = e.target
		if(td.tagName === "TD"){
			
			let tr = td.closest("TR")
			let isbn = tr.dataset.isbn
			alert(isbn)
			
		}
		
	})
	
}
</script>
</html>