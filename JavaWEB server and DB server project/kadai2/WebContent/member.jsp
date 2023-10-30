<%@ page language="java" contentType="text/html;
charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("utf-8");
String login = (String)session.getAttribute("login");
if (login == null || !login.equals("true")){
pageContext.forward("./login.jsp");
}
Cookie[] cookies = request.getCookies();
String mid = "";
for(Cookie cookie:cookies)
mid = cookie.getName().equals("id") ? cookie.getValue():
mid;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=utf-8">
<title>Member Page</title>
</head>
<body>
<h1>Member Only</h1>
<h2>Welcome to <%= mid %></h2>
</body>
</html>