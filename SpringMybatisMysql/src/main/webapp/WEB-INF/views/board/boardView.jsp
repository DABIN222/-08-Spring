<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<h1>글내용보기</h1>
	<ul>
		<li>번호 : ${vo.no }</li>
		<li>작성자 : ${vo.userid }</li>
		<li>작성일 : ${vo.writedate },  조회수 : ${vo.hit }</li>
		<hr/>
		<li>제목 : ${vo.subject }</li>
		<hr/>
		<li>글 내용</li>
		<li>${vo.content }</li>
	</ul>
	<div>
		<!-- 로그인 아이디와 글쓴이가 같을 경우 수정 -->
		<c:if test="${logId == vo.userid }">
			<a href="/myapp/board/boardEdit?no=${vo.no}">수정</a>
			<a href="">삭제</a>
		</c:if>
	</div>
</div>