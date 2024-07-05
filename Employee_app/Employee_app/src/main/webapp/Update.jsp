<%@page import="Dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="signin.css" >
</head>
<body>
	<%
	Employee e = (Employee) request.getAttribute("emp");
	%>
	
	<form action="update"   >
	<h2>Edit</h2>
			<input type="number"   name="id"       placeholder="ID"   value="<%=e.getId() %>"  readonly="readonly" >
			<input type="text"     name="name"     placeholder="NAME" value="<%=e.getName() %>"  >
			<input type="email"    name="email"    placeholder="EMAIL" value="<%= e.getEmail() %>" >
			<input type="password" name="password" placeholder="PASSWORD" value="<%= e.getPassword() %>"   >
			<input type="number"   name="phone"       placeholder="PHONE NUMBER"  value="<%=e.getPhone() %>" >
			<input type="submit" id="btn">
			
		</form>


</body>
</html>