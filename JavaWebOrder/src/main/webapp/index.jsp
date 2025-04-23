<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWebOrder/css/buttons.css">
	</head>
	<body style="padding :20px">
		<form class="pure-form" method="post" action="/JavaWebOrder/order">
			<fieldset>
				<legend>點單表單</legend>
					<label>牛肉麵:</label> 
					<input  name="noodle" type="number" min="0" max="100" step="1" value="0" required/></br>
					<label>陽春麵:</label> 
					<input  name="noodle" type="number" min="0" max="100" step="1" value="0" required/></br>
					<label>番茄麵:</label> 
					<input  name="noodle" type="number" min="0" max="100" step="1" value="0" required/></br>
					
					<button type="submit" class="button-success pure-button">送出訂單</button>						
			</fieldset>
		</form>
		<form class="pure-form" method="get" action="/JavaWebOrder/order">
			<button type="submit" class="button-secondary pure-button">歷史查詢</button>
		</form>	
	</body>
</html>