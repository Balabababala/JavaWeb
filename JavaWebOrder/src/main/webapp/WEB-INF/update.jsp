<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改訂單</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWebOrder/css/buttons.css">
	</head>
	<body style="padding: 20px">
		
		<form class="pure-form" method="post" action="/JavaWebOrder/order/update">
			<fieldset>
				<legend>修改訂單</legend>
				Index:
				<input type="number" name="index" value="${ index }" readonly /><p />
				品名: 
				<select name="item">
					<c:forEach var="productDTO" items="${productDTOs}">
						<option value="${productDTO.item}">${productDTO.item} ${productDTO.price} 元</option>
					</c:forEach>
				</select>
				<p />
				<button type="submit" class="button-success pure-button">修改訂單</button>
			</fieldset>
		</form>
		
	</body>
</html>