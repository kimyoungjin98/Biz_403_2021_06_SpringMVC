<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<style>
form {
	width: 80%;
	margin: 80px auto;
}

form div {
	width: 40%;
	margin: 20px;
}

form label {
	display: inline-block;
    margin: 5px;
    text-align: start;
    width: 30%;
    padding: 8px;
    color: rgba(0,0,0,0.6);
}

form input {
	outline: none;
    border: 1px solid rgba(0,0,0,0.2);
    margin: 8px 5px;
    padding: 7px;
    width: 60%;
}

div.input{
	border:1px solid rgba(0,0,0,0.2);
	border-top:2px solid rgba(0,0,0,0.8);
}

form button{
	padding: 10px 50px;
    outline: 0;
    border: 0;
    background-color: rgba(0,0,0,0.2);
    display: inline-block;
    color: white;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<form method="post">

		<div class="input">
			<div>
				<label>출판사명</label><input name="cp_title">
			</div>
			<div>
				<label>대표자명</label><input name="cp_ceo">
			</div>
			<div>
				<label>전화번호</label><input name="cp_tel">
			</div>
			<div>
				<label>주소</label><input name="cp_addr">
			</div>
			<div class="btn_box">
				<button type="button" class="btn_save">저장</button>
				<button type="reset" class="btn_reset">다시작성</button>
				<button type="button" class="btn_list">리스트로</button>
			</div>
		</div>
	</form>
	
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
	// const : 상수를 선언하는 키워드
	//		코드가 진행되는 동안 값이 변경되면 안되는 것
	const doc = document;
	doc
	.querySelector("button.btn_delete")
	.addEventListener("click", (e)=>{
		doc.querySelector("input[name='cpcode']")
		
		let cpcodeObj = doc.querySelector("input#cpcode")
		let cpcode = cpcodeObj.value
		
		alert("삭제버튼 클릭" + cpcode)
		if(confirm(cpcode + " 를 삭제합니다!")){
			location.replace("${rootPath}/comp/delete?cp_code=" + cpcode);
		}
	})
	</script>
</html>