<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Guestbook資料結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<div class="pure-form">
			<h2>訪客留言資料結果</h2>
			<fieldset>
				<legend>Guestbook Result</legend>
				本次留言: ${ message }<p />
				歷史留言: ${ guestbooks }<p />
				<a href="/JavaWeb/guestbook" class="pure-button pure-button-primary">返回</a>
			</fieldset>
		</div>
	</body>
</html>