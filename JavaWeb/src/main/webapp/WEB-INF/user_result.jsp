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
					姓名: ${user.userName } <p />
					姓別: ${user.gender } <p />
					年齡: ${user.age } <p />
					身高(cm): ${user.height } <p />
					體重(kg): ${user.weight } <p />
					BMI值: ${user.bmiValue } <p />
					BMI判斷: ${user.bmiResult } <p />
					<a href="/JavaWeb/user" class="pure-buttom pure-buttom-primary">返回</a>
				</fieldset>
			</div>
		</body>
</html>