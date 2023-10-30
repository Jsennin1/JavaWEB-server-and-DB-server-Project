<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ page import="kadai7.*" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register Page</title>
</head>
<body>
<script>
function check() {
  if (document.getElementsByName('password')[0].value ==
    document.getElementsByName('confirm_password')[0].value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
    return true;
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'passwords not matching';
    return false;
  }
}
function assignZIP(){
	document.getElementsByName('zip')[1].value =
	    document.getElementsByName('zip')[0].value
}
function Reset(){
	document.form.reset();
	document.getElementsByName('zip')[0].value = "";
	document.getElementsByName('zip')[1].value = "";
	document.getElementsByName('prefecture')[0].value = "";
	document.getElementsByName('city')[0].value = "";
	document.getElementsByName('address')[0].value = "";
}
</script>
<br><hr>
Register<br>
<form method="post" action="./AddressFinder" onchange="assignZIP()">
ZIP：<input type="text" name="zip" value=<%= request.getParameter("zip")==null ? "": (String)request.getParameter("zip") %> > <input type="submit" value="Find by ZIP"><br>
</form>
<form method="post" name="form" action="./Register" onsubmit="return check()">
<input type="hidden" name="zip" value=<%= request.getParameter("zip")==null ? "": (String)request.getParameter("zip") %> >
Prefecture:<input type="text" name="prefecture" value=<%= request.getAttribute("addr1")==null ? "": (String)request.getAttribute("addr1") %>  ><br>
City:<input type="text" name="city" value=<%= request.getAttribute("addr2")==null ? "": (String)request.getAttribute("addr2") %> ><br>
Address:<input type="text" name="address" value=<%= request.getAttribute("addr3")==null ? "": (String)request.getAttribute("addr3") %>><br>
ID：<input type="text" name="ID"><br>
Name：<input type="text" name="name"><br>
Name Kana：<input type="text" name="name_kana"><br>
Email：<input type="email" name="email"><br>
Password：<input type="password" name="password"><br>
Password Again：<input type="password" name="confirm_password">
<span id = "message" style="color:red"> </span><br>
<input type="submit" value="Register"><input type="button" value="Reset" onclick="Reset()">
</form>
</body>
</html>