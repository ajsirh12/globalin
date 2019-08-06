<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<title>메모 등록 폼</title>
	</head>
	<body>
		<div class="container">
		<h3>Memo Input</h3>
		<table class="table">
			<form method="post" action="memo_save">
				<tr>이름 <input type="text" class="form-control" placeholder="이름을 입력하세요." name="name"/><br></tr>
				<tr>나이 <input type="text" class="form-control" placeholder="나이를 입력하세요." name="age"/><br></tr>
				<tr>
				<center>
				<td align="right"><button type="submit" class="btn btn-primary">저장</button>
				<!-- <input type="submit" value="메모 등록"/> -->
			</form>
			<a href="memo_list"><button class="btn btn-primary">목록</button></a></td>
			</center>
			</tr>
		</table>
		</div>
	</body>
</html>