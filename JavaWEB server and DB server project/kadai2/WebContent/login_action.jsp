<%@ page language="java" contentType="text/html;
charset=utf-8" pageEncoding="utf-8"%>
<%
String[][] id_pass_str = {{"numao","masayuki"},
		{"anil","tekeli"},
		{"gunma","tarou"},
		{"hikari",  "light"},
		{"ibuki", "watanuki"}};
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
id = id == null ? "" : id;
String pass = request.getParameter("pass");
pass = pass == null ? "" : pass;
Cookie cookie = new Cookie("id",id);
cookie.setMaxAge(60 * 60 * 24 * 3);
response.addCookie(cookie);
boolean idPassRight= false;
for(String[] var : id_pass_str){
	if(id.equals(var[0]))
		if(pass.equals(var[1]))
			idPassRight = true;
}

if ( idPassRight){
session.setMaxInactiveInterval(60 * 10);
session.setAttribute("login","true");
response.sendRedirect("./member.jsp");
} else {
session.setAttribute("login","false");
response.sendRedirect("./login.jsp");
}
%>
