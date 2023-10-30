<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ page import="kadai7.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Login</title>
</head>
<body>
<h1>User Login</h1>
<form method="post" action="./LoginServlet">
<input type="hidden" name="mode" value="login">
ID:<input type="text" size="30" name="ID"><br>
PASS:<input type="password" size="30" name="password"><br>
<br>
<input type="submit" value="login">
<input type="reset" value="reset">
</form>
</body>
</html>