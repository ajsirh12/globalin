<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Memo Detail</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
	<h3>Memo Detail</h3>
		<table class="table">
			<form method="post" action="memo_update">
				<tr>
				<input type="hidden" class="form-control" name="memoid" value="${memo.memoid }">
				<td>${memo.memoid }</td>
				<td><input type="text" class="form-control" placeholder="이름을 입력하세요." name="name" value="${memo.name }"></td>
				<td><input type="text" class="form-control" placeholder="나이를 입력하세요." name="age" value="${memo.age }"></td>
				</tr>
				<tr>
				<td></td><td></td>
				<td align="right"><input type="submit" class="btn btn-primary" value="수정">
			</form>
			<a href="memo_delete?memoid=${memo.memoid }"><button class="btn btn-primary">삭제</button></a>
			<a href="memo_list"><button class="btn btn-primary">목록</button></a></td>
			
			</tr>
		</table>
	</div>
	</body>
</html>