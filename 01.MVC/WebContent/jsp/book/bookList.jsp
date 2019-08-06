<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
		<tr><td colspan="4" align = "center"><a href="bookinput">홈으로</a></tr>
			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.bookid }</td>
					<td>${book.bookname }</td>
					<td>${book.publisher }</td>
					<td>${book.price }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>