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
	</head>
		<body>
			<div>
				<legend>ice Result</legend>
				<fieldset>
					<table class ="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>No</th>
							<th>主餐</th>
							<th>配料</th>
							<th>價格</th>
						</tr>	
					</thead>
					<tbody>
						<c:forEach varStatus="i" var="iceOrder" items="${iceOrders}">
							<tr>
								<td>${i.index +1}</td>
								<td>${ iceOrder.mainDish.name }</td>
								<td>${ iceOrder.toppings.toppings }</td>
								<td>${ iceOrder.totalPrice }</td>
							</tr>	
						</c:forEach>										
					</tbody>			
				</table>
 
					<a href="/JavaWeb/ice" class="pure-buttom pure-buttom-primary">返回</a>
				</fieldset>
			</div>
		</body>
</html>