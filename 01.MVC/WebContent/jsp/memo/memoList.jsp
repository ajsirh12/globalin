<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<title>메모리스트</title>
		<style>
			#select>a{
				font-size: 20px;
				color: black;
			}
			a:hover {
				color: black;
				text-decoration: none;
			}
		</style>
	</head>
	<body>
	<div class="container">
		<h3>Memo List</h3>
		<table class="table">
		<form action="memo_search" method="post">
		<tr>
			<input type="text" name="name" placeholder="이름을 입력하세요."/>&nbsp;
			<input type="submit" value="검색" class="btn btn-primary"/>&nbsp;
		</form>
			<a href="memo_list"><button class="btn btn-primary">목록</button></a></tr>
		</table>
		<c:if test="${empty memos}">
			<hr/>검색된 결과가 존재하지 않습니다.<hr/>
			<table class="table">
			<tr>
				<td><a href="index.jsp"><button class="btn btn-primary">메모 저장</button></a></td>
				<form method="post" action="memo_save2">	
					<td><input type="text" class="form-control" placeholder="이름을 입력하세요." name="name"/></td>
					<td><input type="text" class="form-control" placeholder="나이를 입력하세요." name="age"/></td>
					<td><button type="submit" class="btn btn-primary">메모 등록</button></td>
				</form>
			</tr>
		</table>
		</c:if>
		<c:if test="${!empty memos}">
			<table class="table">
				<tr>
					<th>메모번호</th>
					<th>이름</th>
					<th>나이</th>
					<!-- <th>상세보기</th> -->
					<th>삭제</th>
				</tr>
				<c:forEach var="memo" items="${memos}">
					<tr>
						<td>${memo.memoid }</td>
						<%-- <td>${memo.name }</td> --%>
						<td><a href="memo_detail?memoid=${memo.memoid }">${memo.name }</a></td>
						<td>${memo.age }</td>
						<%-- <td><a href="memo_detail?memoid=${memo.memoid }">상세보기</a></td> --%>
						<td><a href="memo_delete?memoid=${memo.memoid }">삭제</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td><a href="memo_input"><button class="btn btn-primary">메모 저장</button></a></td>
					<form method="post" action="memo_save2">	
						<td><input type="text" class="form-control" placeholder="이름을 입력하세요." name="name"/></td>
						<td><input type="text" class="form-control" placeholder="나이를 입력하세요." name="age"/></td>
						<td><button type="submit" class="btn btn-primary">메모 등록</button></td>
					</form>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<c:if test="${pageGroupResult.beforPage}">
							<a href="memo_req_list?reqPage=${pageGroupResult.groupStartNumber - 1}">&lt;</a>
						</c:if>
						<c:if test="${!pageGroupResult.beforPage}">
							&lt;
						</c:if>&nbsp&nbsp&nbsp
						<c:forEach var="index" begin="${pageGroupResult.groupStartNumber }" end="${pageGroupResult.groupEndNumber }">
							<c:if test="${index == pageGroupResult.selectPageNumber }">
								<span id="select"><a href="memo_req_list?reqPage=${index }">${index }</a></span>
							</c:if>
							<c:if test="${index != pageGroupResult.selectPageNumber }">
								<a href="memo_req_list?reqPage=${index }">${index }</a>
							</c:if>
						</c:forEach>&nbsp&nbsp&nbsp
						<c:if test="${pageGroupResult.afterPage}">
							<a href="memo_req_list?reqPage=${pageGroupResult.groupEndNumber + 1}">&gt;</a>
						</c:if>
						<c:if test="${!pageGroupResult.afterPage}">
							&gt;
						</c:if>
					</td>
				</tr>
			</table>
		</c:if>
		</div>
	</body>
</html>