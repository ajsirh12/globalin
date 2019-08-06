<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>form tag</title>
	</head>
	
	<body>
		<h3>Input Element</h3>
		<form method="post" action="input_01">
			<input type="text" name="username"/>
			<input type="password" name="password"/>
			<input type="reset"/>
			<input type="submit"/>
		</form>
		
		<form method="post" action="input_02">
			<input type="radio" name="gender" value="male" >남자
			<input type="radio" name="gender" value="female">여자
			<input type="radio" name="gender" value="other">나머지
			<input type="submit">
		</form>
		
		<form method="post" action="input_03">
			<input type="checkbox" name="vehicle" value="Bike">자전거
			<input type="checkbox" name="vehicle" value="Car">차
			<input type="checkbox" name="vehicle" value="Subway">지하철
			<input type="checkbox" name="vehicle" value="Bus">버스
			<input type="submit">
		</form>
		
		<form method="post" action="select">
			<select name = cars>
				<option value="volvo">Volvo</option>
				<option value="audi">Audi</option>
				<option value="bmw">Bmw</option>
			</select>
			<input type="submit">
		</form>
		<form method="post" action="textarea">
			<textarea name="message" rows="10" cols="30"></textarea>
			<input type="submit">
		</form>
	</body>
</html>