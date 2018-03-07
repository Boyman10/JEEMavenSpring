<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style type="text/css"></style>
</head>
<body>
	<h1>Creating Content</h1>

<form method="POST" action="${pageContext.request.contextPath}/docreate">

<table>
<tr>
	<td>Login name</td><td><input type="text" name="name" /></td></tr>
	<tr><td>Login email</td><td><input type="text" name="email" /></td></tr>
	<tr><td>Text</td><td><textarea name="text"></textarea></td></tr>
	<tr><td></td><td><input type="submit" value="login" /></td></tr>
</tr>
</table>
</form>
</body>
</html>