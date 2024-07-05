<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css" >
</head>
<body>

	<%
	String message = (String) request.getAttribute("msg");

	if (message != null) {
	%>

	<h1><%=message%></h1>


	<%
	}
	%>


	<form action="login">
	<h2>Login</h2>
		<input type="text" name="email" placeholder="EMAIL"> <input
			type="text" name="pass" placeholder="PASSWORD"> <input
			type="submit" id="btn">
	</form>

</body>
</html>