<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
		<body>
			<div>
				<fieldset>
					<legend>User Result</legend>
					咖啡類型:  ${coffee.result } <p />
					牛奶(ml): ${coffee.milk } <p />
					咖啡(ml): ${coffee.coffee } <p />
					描述:     ${coffee.desctiption }<p />
					<a href="/JavaWeb/coffee" class="pure-buttom pure-buttom-primary">返回</a>
				</fieldset>
			</div>
		</body>
</html>