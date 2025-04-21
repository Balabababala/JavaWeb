<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
	</head>
	<body>
		<div class="form-container">
			<h2>咖啡表單</h2>
			<form class="pure-form pure-form-stacked" method="post" action="/JavaWeb/coffee">
				<fieldset>
					<legend>Coffee form</legend> 

					<label>牛奶(ml):</label> 
					<input  name="milk" type="number" min="1" max="1000" step="1" required/ >
					
					<label>咖啡(ml):</label> 
					<input  name="coffee" type="number" min="1" max="1000" step="1" required/>
					
					<button type="submit" class="pure-form pure-form-primary">送出</button>
				</fieldset>
	</body>
</html>