<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>訂單首頁</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWebOrder/css/buttons.css">
	</head>
	<body style="padding: 20px">
		
		<form class="pure-form" method="post" action="/JavaWebOrder/order">
			<fieldset>
				<legend>訂單</legend>
				品名: 
				<select name="item">		
					<c:forEach var="productDTO" items="${productDTOs}">
						<option value="${productDTO.item}">${productDTO.item} ${productDTO.price} 元</option>
					</c:forEach>
						
				</select>
				<p />
				數量:<input type="number" name="quality" min="1" max="100" required /><p />
				<button type="submit" class="button-success pure-button">送出訂單</button>
			</fieldset>
		</form>
		
		<form class="pure-form" method="get" action="/JavaWebOrder/order">
			<button type="submit" class="button-secondary pure-button">查看歷史資料</button>
		</form>
		
		
	</body>
</html>