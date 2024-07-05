<%@page import="Dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="view.css">
</head>
<body>
	<%
	List<Employee> list = (List<Employee>) request.getAttribute("list");
	%>


	<table border="2px">
		<tr>
			<th>ID</th>
			<th id="name">NAME</th>
			<th>EMAIL</th>
			<th>PASSWORD</th>
			<th>PHONE</th>
			<th>DELETE</th>
			<th>EDIT</th>
		</tr>

		<%
		for (Employee e : list) {
		%>




		<tr>
			<td><%=e.getId()%></td>
			<td id="name"><%=e.getName()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getPassword()%></td>
			<td><%=e.getPhone()%></td>
			<td><a href="delete?id=<%=e.getId()%>">Delete</a></td>
			<td><a href="edit?id=<%=e.getId()%>">Edit</a></td>


		</tr>


		<%
		}
		%>

	</table>









</body>
</html>