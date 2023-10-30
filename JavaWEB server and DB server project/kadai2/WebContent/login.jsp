<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ログイン画面</title>
<body>
<%
request.setCharacterEncoding("utf-8");
if (session.getAttribute("login") != null &&
!session.getAttribute("login").equals("true"))
out.println("※ログインに失敗しました。");
Cookie[] cookies = request.getCookies();
String pre_id = "";
if (cookies!=null)
for(Cookie cookie:cookies)
pre_id = cookie.getName().equals("id") ?
cookie.getValue():pre_id;
%>
<form method="post" action="./login_action.jsp">
<table>
<tr>
<td>ID:</td><td><input type="text" name="id"
value="<%=pre_id %>"></td>
</tr><tr>
<td>PASS:</td><td><input type="password"
name="pass"></td>
</tr><tr>
<td></td><td><input type="submit" value="login"></td>
</tr>
</table>
</form>
</body>
</html>