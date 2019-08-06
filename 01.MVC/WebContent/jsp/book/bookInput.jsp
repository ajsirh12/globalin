<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script> 
			$(document).ready(function(){
			 	
			});
		</script>
	</head>
	<body>
	<h3>책 등록</h3>
	<form method="post" action="select_book">
		<input type="text" name="bookname" placeholder="책이름 입력하세요"><br>
		<select name = "publisher">
		<c:forEach var="book" items="${books }">
			<option value="${book.publisher }">${book.publisher }</option>
		</c:forEach>
		</select><br>
		<input type="text" name="price" placeholder="가격을 입력하세요">
		<input type="submit" value="제출">
	</form>
		<a href="book_list">책 목록보기</a>
	</body>
</html>