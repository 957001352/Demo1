<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>user list</h3>
	<a href="save.jsp">继续注册</a>
	<table>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>brithday</td>
			<td>money</td>
			<td>photo</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="u">
			<tr>
				<td>${u.id}</td>
				<td>${u.name}</td>
				<td>${u.brithday}</td>
				<td>${u.money}</td>
				<td>${u.photo}</td>
				<td>
					<a href="User_delete?id=${u.id }">删除</a>
					|
					<a href="User_updateUI?id=${u.id }">编辑</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>