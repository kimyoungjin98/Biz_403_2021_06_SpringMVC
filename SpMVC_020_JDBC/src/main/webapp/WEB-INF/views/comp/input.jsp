<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<style>
   form#book_input input.search {
      width: 30%;
   }
   form#book_input input span.name {
      color:blue;
      font-weight: bold;
      margin-left: 10px;   
   }
   
</style>
<script>
   var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/book_input.js?ver=2021-06-22-007"></script>
<body>
   <%@ include file="/WEB-INF/views/include/include_header.jspf" %>
   <section class="main_sec">
   <form id="book_input" method="POST">
      <fieldset>
      <legend>도서정보 등록</legend>
      <div>
         <label>ISBN</label>
         <input name="bk_isbn" id="bk_isbn" placeholder=""/>
      </div>
            <div>
         <label>도서명</label>
         <input name="bk_title" id="bk_title" placeholder=""/>
      </div>
            <div>
         <label>출판사</label>
         <input class="search" name="bk_ccode" id="bk_ccode" placeholder=""/>
         <span id="cp_title" class="name">출판사명</span>
      </div>
            <div>
         <label>저자</label>
         <input class="search"  name="bk_acode" id="bk_acode" placeholder=""/>
         <span id="au_name" class="name">저자명</span>
      </div>
            <div>
         <label>출판연도</label>
         <input name="bk_date" id="bk_date" placeholder=""/>
      </div>
            <div>
         <label>가격</label>
         <input name="bk_price" id="bk_price" placeholder=""/>
      </div>
      <div>
         <label>페이지수</label>
         <input name="bk_pages" id="bk_pages" placeholder=""/>
      </div>
      </fieldset>
   <div class="btn_box">
      <button type="button" class="btn_save book">저장</button>
      <button type="reset" class="btn_reset book">새로작성</button>
      <button type="button" class="btn_list book">돌아가기</button>
      <!-- button type을 button으로하면 전송을 막는다.
      스크립트로 처리할 수 있게.
      reset으로하면 input에 적은 내용을 전부 초기화한다. -->
   </div>
   </form>
   </section>
   <%@ include file="/WEB-INF/views/include/include_footer.jspf" %>

</body>
</html>