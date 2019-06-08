<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="User_update" method="post">
	<input type="hidden" name="id" value="${user.id }"/>
		name:<input type="text" name="name" value="${user.name }"/><br>
		brithday:<input type="text" name="brithday" value="${user.brithday }"/><br>
		money:<input type="text" name="money" value="${user.money }"/><br>
		photo:<input type="text" name="photo" value="${user.photo }"/><br>
		<button type="submit">修改</button>
	</form>
</body>
</html>